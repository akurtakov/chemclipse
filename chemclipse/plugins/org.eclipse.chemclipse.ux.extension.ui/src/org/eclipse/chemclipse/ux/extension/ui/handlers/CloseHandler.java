/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.handlers;

import org.eclipse.chemclipse.ux.extension.ui.editors.IChemClipseEditor;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import jakarta.inject.Named;

public class CloseHandler {

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
	void execute(EPartService partService, @Named(IServiceConstants.ACTIVE_PART) MPart part) {

		if(part != null) {
			Object object = part.getObject();
			if(object != null) {
				if(object instanceof IChemClipseEditor) {
					partService.hidePart(part, true);
				}
			}
		}
	}
}
