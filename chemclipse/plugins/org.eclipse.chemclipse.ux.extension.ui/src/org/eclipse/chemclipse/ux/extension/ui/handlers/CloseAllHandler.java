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
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class CloseAllHandler {

	@CanExecute
	boolean canExecute(EPartService partService) {

		for(MPart part : partService.getParts()) {
			if(part.getObject() instanceof IChemClipseEditor) {
				return true;
			}
		}
		return false;
	}

	@Execute
	void execute(EPartService partService) {

		for(MPart part : partService.getParts()) {
			if(part.getObject() instanceof IChemClipseEditor) {
				partService.hidePart(part, true);
			}
		}
	}
}
