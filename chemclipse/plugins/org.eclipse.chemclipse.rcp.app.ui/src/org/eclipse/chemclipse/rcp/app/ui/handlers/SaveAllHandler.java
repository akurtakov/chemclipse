/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.rcp.app.ui.handlers;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class SaveAllHandler {

	@CanExecute
	boolean canExecute(@Optional MWindow window) {

		if(window != null) {
			IEclipseContext context = window.getContext();
			if(context != null) {
				EPartService partService = context.get(EPartService.class);
				if(partService != null) {
					return !partService.getDirtyParts().isEmpty();
				}
			}
		}
		return false;
	}

	@Execute
	void execute(EPartService partService) {

		partService.saveAll(false);
	}
}
