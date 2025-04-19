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

import jakarta.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class QuitHandler {

	@Execute
	public void execute(IWorkbench workbench, @Named(IServiceConstants.ACTIVE_SHELL) Shell shell, EPartService partService) {

		if(partService.saveAll(true)) {
			workbench.close();
		} else {
			if(MessageDialog.openConfirm(shell, "Exit", "Some parts have not been saved. Exit anyhow?")) {
				workbench.close();
			}
		}
	}
}
