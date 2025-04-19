/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.ui.handlers;

import java.util.Collection;

import jakarta.inject.Named;

import org.eclipse.chemclipse.ux.extension.ui.editors.IChemClipseEditor;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;

public class PreviousChromatogramHandler {

	@CanExecute
	boolean canExecute(@Named(IServiceConstants.ACTIVE_PART) MPart part) {

		if(part != null) {
			if(part.getObject() instanceof IChemClipseEditor) {
				return true;
			}
		}
		return false;
	}

	@Execute
	void execute(EPartService partService, @Named(IServiceConstants.ACTIVE_PART) MPart selectedPart) {

		if(selectedPart != null) {
			Collection<MPart> parts = partService.getParts();
			MPart inputPartPrevious = null;
			exitloop:
			for(MPart part : parts) {
				if(selectedPart == part) {
					if(inputPartPrevious != null) {
						partService.showPart(inputPartPrevious, PartState.ACTIVATE);
						break exitloop;
					}
				} else {
					inputPartPrevious = part;
				}
			}
		}
	}
}
