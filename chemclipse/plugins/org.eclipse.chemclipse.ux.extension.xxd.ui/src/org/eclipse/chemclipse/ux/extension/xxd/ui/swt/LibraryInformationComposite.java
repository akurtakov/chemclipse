/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.swt;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.support.events.IChemClipseEvents;
import org.eclipse.chemclipse.swt.ui.components.InformationUI;
import org.eclipse.chemclipse.ux.extension.ui.support.DataUpdateSupport;
import org.eclipse.chemclipse.ux.extension.ui.swt.IExtendedPartUI;
import org.eclipse.chemclipse.ux.extension.xxd.ui.Activator;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public abstract class LibraryInformationComposite extends Composite implements IExtendedPartUI {

	private AtomicReference<Button> buttonToolbarInfoControl = new AtomicReference<>();
	private AtomicReference<InformationUI> toolbarInfo = new AtomicReference<>();

	private ILibraryInformation libraryInformation = null;

	public LibraryInformationComposite(Composite parent, int style) {

		super(parent, style);
	}

	public void clear() {

		setInput(null);
	}

	public void setInput(ILibraryInformation libraryInformation) {

		if(this.libraryInformation != libraryInformation) {
			this.libraryInformation = libraryInformation;
			updateToolbarInfo();
			updateInput();
		}
	}

	@Override
	@Focus
	public boolean setFocus() {

		DataUpdateSupport dataUpdateSupport = Activator.getDefault().getDataUpdateSupport();
		String topic = IChemClipseEvents.TOPIC_IDENTIFICATION_TARGET_UPDATE;
		List<Object> objects = dataUpdateSupport.getUpdates(topic);
		if(!objects.isEmpty()) {
			Object last = objects.get(0);
			if(last instanceof IIdentificationTarget identificationTarget) {
				setInput(identificationTarget.getLibraryInformation());
			}
		}

		return true;
	}

	public ILibraryInformation getLibraryInformation() {

		return libraryInformation;
	}

	protected abstract void updateInput();

	protected void createButtonToolbarInfo(Composite parent) {

		buttonToolbarInfoControl.set(createButtonToggleToolbar(parent, toolbarInfo, IMAGE_INFO, TOOLTIP_INFO));
	}

	protected void initializeToolbarInfo() {

		enableToolbar(toolbarInfo, buttonToolbarInfoControl.get(), IApplicationImage.IMAGE_INFO, TOOLTIP_INFO, true);
	}

	protected void createToolbarInfo(Composite parent) {

		InformationUI informationUI = new InformationUI(parent, SWT.NONE);
		informationUI.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		toolbarInfo.set(informationUI);
	}

	protected AtomicReference<InformationUI> getToolbarInfo() {

		return toolbarInfo;
	}

	protected void updateToolbarInfo() {

		if(libraryInformation != null) {
			toolbarInfo.get().setText(libraryInformation.getName());
		} else {
			toolbarInfo.get().setText("--");
		}
	}
}