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
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.columns.ISeparationColumnIndices;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.support.events.IChemClipseEvents;
import org.eclipse.chemclipse.support.events.IPerspectiveAndViewIds;
import org.eclipse.chemclipse.support.ui.workbench.DisplayUtils;
import org.eclipse.chemclipse.support.ui.workbench.EditorSupport;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.event.EventHandler;

import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;

public class EditorCalibration {

	public static final String ID = "org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.editors.editorCalibration";
	public static final String CONTRIBUTION_URI = "bundleclass://org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui/org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.editors.EditorCalibration";
	public static final String ICON_URI = ApplicationImageFactory.getInstance().getURI(IApplicationImage.IMAGE_REPORT, IApplicationImageProvider.SIZE_16x16);
	public static final String TOOLTIP = "Retention Index Calibration";

	private static final Logger logger = Logger.getLogger(EditorCalibration.class);

	private final MPart part;
	private final MDirtyable dirtyable;
	private final MApplication application;
	private final EModelService modelService;
	private final Shell shell;

	private PageCalibration pageCalibration;
	private File file;
	private ISeparationColumnIndices separationColumnIndices;

	private ArrayList<EventHandler> registeredEventHandler = new ArrayList<>();
	private List<Object> objects = new ArrayList<>();
	private IEventBroker eventBroker;

	@Inject
	public EditorCalibration(Composite parent, MPart part, MDirtyable dirtyable, MApplication application, EModelService modelService, Shell shell, IEventBroker eventBroker) {

		this.part = part;
		this.dirtyable = dirtyable;
		this.application = application;
		this.modelService = modelService;
		this.shell = shell;
		this.eventBroker = eventBroker;

		initialize(parent);
	}

	@Focus
	public void setFocus() {

		pageCalibration.getControl().setFocus();
	}

	@Persist
	public void save() {

		if(file != null && separationColumnIndices != null) {
			CalibrationFileWriter calibrationFileWriter = new CalibrationFileWriter();
			calibrationFileWriter.write(file, separationColumnIndices);
			dirtyable.setDirty(false);
		}
	}

	public boolean saveAs() {

		FileDialog fileDialog = new FileDialog(shell, SWT.SAVE);
		fileDialog.setText("Save the *.cal file.");
		fileDialog.setFilterExtensions(new String[]{"*.cal"});
		fileDialog.setFilterNames(new String[]{"AMDIS Calibration *.cal"});
		String pathRetentionIndexFile = fileDialog.open();
		if(pathRetentionIndexFile != null) {
			File newFile = new File(pathRetentionIndexFile);
			CalibrationFileWriter calibrationFileWriter = new CalibrationFileWriter();
			calibrationFileWriter.write(newFile, separationColumnIndices);
			dirtyable.setDirty(false);
			return true;
		}
		return false;
	}

	@PreDestroy
	private void preDestroy() {

		if(eventBroker != null) {
			for(EventHandler eventHandler : registeredEventHandler) {
				eventBroker.unsubscribe(eventHandler);
			}
		}
		if(modelService != null && application != null) {
			MPartStack partStack = (MPartStack)modelService.find(IPerspectiveAndViewIds.EDITOR_PART_STACK_ID, application);
			part.setToBeRendered(false);
			part.setVisible(false);
			DisplayUtils.getDisplay().asyncExec(() -> partStack.getChildren().remove(part));
		}
	}

	private void initialize(Composite parent) {

		loadData();
		createPage(parent);
	}

	private void loadData() {

		try {
			Object object = part.getObject();
			if(object instanceof Map<?, ?> map) {
				file = new File((String)map.get(EditorSupport.MAP_FILE));
				CalibrationFileReader calibrationFileReader = new CalibrationFileReader();
				separationColumnIndices = calibrationFileReader.parse(file);
				part.setLabel(file.getName());
			}
		} catch(Exception e) {
			logger.warn(e);
		}
	}

	private void createPage(Composite parent) {

		pageCalibration = new PageCalibration(parent);
		if(file != null && separationColumnIndices != null) {
			pageCalibration.showData(file, separationColumnIndices);
		}
		registerEvents();
	}

	private void registerEvent(String topic, String[] properties) {

		if(eventBroker != null) {
			registeredEventHandler.add(registerEventHandler(eventBroker, topic, properties));
		}
	}

	private void registerEvents() {

		registerEvent(IChemClipseEvents.TOPIC_RI_LIBRARY_UPDATE, new String[]{IChemClipseEvents.EVENT_BROKER_DATA});
	}

	private EventHandler registerEventHandler(IEventBroker eventBroker, String topic, String[] properties) {

		EventHandler eventHandler = event -> {
			try {
				objects.clear();
				for(String property : properties) {
					Object object = event.getProperty(property);
					objects.add(object);
				}
				updateObjects(objects);
			} catch(Exception e) {
				logger.warn(e + "\t" + event);
			}
		};
		eventBroker.subscribe(topic, eventHandler);
		return eventHandler;
	}

	private void updateObjects(List<Object> objects) {

		if(objects.size() == 1) {
			Object object = objects.get(0);
			if(object instanceof Object[] array) {
				if(array.length == 2) {
					Object content = array[1];
					if(content instanceof ISeparationColumnIndices columnIndices) {
						if(this.separationColumnIndices == columnIndices) {
							dirtyable.setDirty(columnIndices.isDirty());
						}
					}
				}
			}
		}
	}
}
