/*******************************************************************************
 * Copyright (c) 2016, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.editors;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.io.CalibrationFileReader;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.io.CalibrationFileWriter;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.Activator;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.columns.ISeparationColumnIndices;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.support.events.IChemClipseEvents;
import org.eclipse.chemclipse.support.ui.workbench.EditorSupport;
import org.eclipse.chemclipse.ux.extension.ui.editors.IChemClipseEditor;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.osgi.service.event.EventHandler;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;

public class EditorCalibration implements IChemClipseEditor {

	public static final String ID = "org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.editors.editorCalibration";
	public static final String CONTRIBUTION_URI = "bundleclass://org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui/org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.editors.EditorCalibration";
	public static final String ICON_URI = ApplicationImageFactory.getInstance().getURI(IApplicationImage.IMAGE_REPORT, IApplicationImageProvider.SIZE_16x16);
	public static final String TOOLTIP = "Retention Index Calibration";

	private static final Logger logger = Logger.getLogger(EditorCalibration.class);

	@Inject
	MPart part;
	@Inject
	MDirtyable dirtyable;

	private PageCalibration pageCalibration;
	private File file;

	private ISeparationColumnIndices separationColumnIndices;

	private ArrayList<EventHandler> registeredEventHandler;
	private List<Object> objects = new ArrayList<>();

	@Persist
	public void save() {

		CalibrationFileWriter calibrationFileWriter = new CalibrationFileWriter();
		calibrationFileWriter.write(file, separationColumnIndices);
		dirtyable.setDirty(false);
	}

	@Override
	public boolean saveAs() {

		FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
		fileDialog.setText("Save the *.cal file.");
		fileDialog.setFilterExtensions("*.cal");
		fileDialog.setFilterNames("AMDIS Calibration *.cal");
		String pathRetentionIndexFile = fileDialog.open();
		if(pathRetentionIndexFile != null) {
			File saveFile = new File(pathRetentionIndexFile);
			CalibrationFileWriter calibrationFileWriter = new CalibrationFileWriter();
			calibrationFileWriter.write(saveFile, separationColumnIndices);
			dirtyable.setDirty(false);
			return true;
		}
		return false;
	}

	@PostConstruct
	public void initialize(Composite parent) {

		Object object = part.getObject();
		if(object instanceof Map<?, ?> map) {
			Object fileObject = map.get(EditorSupport.MAP_FILE);
			if(fileObject instanceof String filePath) {
				file = new File(filePath);
			}
		}
		/*
		 * Create the UI.
		 */
		pageCalibration = new PageCalibration(parent);
		registeredEventHandler = new ArrayList<>();
		registerEvents();
		/*
		 * Load data if file is available.
		 */
		if(file != null) {
			CalibrationFileReader calibrationFileReader = new CalibrationFileReader();
			separationColumnIndices = calibrationFileReader.parse(file);
			pageCalibration.showData(file, separationColumnIndices);
		}
	}

	@Focus
	public void setFocus() {

		if(pageCalibration != null) {
			pageCalibration.getControl().setFocus();
		}
	}

	public void setDirty(boolean isDirty) {

		dirtyable.setDirty(isDirty);
	}

	public void updateObjects(List<Object> objects) {

		if(objects.size() == 1) {
			Object object = objects.get(0);
			if(object instanceof Object[] array) {
				if(array.length == 2) {
					Object content = array[1];
					if(content instanceof ISeparationColumnIndices separationColumnIndices) {
						if(this.separationColumnIndices == separationColumnIndices) {
							setDirty(separationColumnIndices.isDirty());
						}
					}
				}
			}
		}
	}

	public void registerEvent(String topic, String property) {

		registerEvent(topic, new String[]{property});
	}

	public void registerEvent(String topic, String[] properties) {

		IEventBroker eventBroker = Activator.getDefault().getEventBroker();
		if(eventBroker != null) {
			registeredEventHandler.add(registerEventHandler(eventBroker, topic, properties));
		}
	}

	public void registerEvents() {

		registerEvent(IChemClipseEvents.TOPIC_RI_LIBRARY_UPDATE, IChemClipseEvents.EVENT_BROKER_DATA);
	}

	@PreDestroy
	void preDestroy() {

		IEventBroker eventBroker = Activator.getDefault().getEventBroker();
		if(eventBroker != null) {
			for(EventHandler eventHandler : registeredEventHandler) {
				eventBroker.unsubscribe(eventHandler);
			}
		}
	}

	private EventHandler registerEventHandler(IEventBroker eventBroker, String topic, String[] properties) {

		EventHandler eventHandler = event -> {
			try {
				objects.clear();
				for(String property : properties) {
					Object object = event.getProperty(property);
					objects.add(object);
				}
				update(topic);
			} catch(Exception e) {
				logger.warn(e + "\t" + event);
			}
		};
		eventBroker.subscribe(topic, eventHandler);
		return eventHandler;
	}

	private void update(String topic) {

		updateObjects(objects);
	}
}
