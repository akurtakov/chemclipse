/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - adapted for MALDI
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.msd.ui.parts;

import java.util.List;

import org.eclipse.chemclipse.support.events.IChemClipseEvents;
import org.eclipse.chemclipse.ux.extension.msd.ui.Activator;
import org.eclipse.chemclipse.ux.extension.msd.ui.swt.ExtendedMassSpectrumTargetsUI;
import org.eclipse.chemclipse.ux.extension.ui.parts.AbstractPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import jakarta.inject.Inject;

public class MassSpectrumTargetsPart extends AbstractPart<ExtendedMassSpectrumTargetsUI> {

	private static final String TOPIC = IChemClipseEvents.TOPIC_SCAN_XXD_UPDATE_SELECTION;

	@Inject
	public MassSpectrumTargetsPart(Composite parent) {

		super(parent, TOPIC, Activator.getDefault().getDataUpdateSupport());
	}

	@Override
	protected ExtendedMassSpectrumTargetsUI createControl(Composite parent) {

		return new ExtendedMassSpectrumTargetsUI(parent, SWT.NONE);
	}

	@Override
	public void setFocus() {

		ExtendedMassSpectrumTargetsUI control = getControl();
		if(control != null) {
			control.setFocus();
		}
	}

	@Override
	protected boolean updateData(List<Object> objects, String topic) {

		if(objects.size() == 1) {
			Object object = objects.get(0);
			if(isPartUpdateEvent(topic)) {
				getControl().updatePart();
			} else if(isScanTopic(topic) || isIdentificationTopic(topic)) {
				getControl().update(object);
				return true;
			}
		}

		return false;
	}

	@Override
	protected boolean isUpdateTopic(String topic) {

		return isPartUpdateEvent(topic) || //
				isScanTopic(topic) || isIdentificationTopic(topic); //
	}

	private boolean isScanTopic(String topic) {

		return IChemClipseEvents.TOPIC_SCAN_XXD_UPDATE_SELECTION.equals(topic);
	}

	private boolean isIdentificationTopic(String topic) {

		return IChemClipseEvents.TOPIC_IDENTIFICATION_TARGETS_UPDATE_SELECTION.equals(topic);
	}

	private boolean isPartUpdateEvent(String topic) {

		return IChemClipseEvents.TOPIC_PART_UPDATE.equals(topic);
	}
}
