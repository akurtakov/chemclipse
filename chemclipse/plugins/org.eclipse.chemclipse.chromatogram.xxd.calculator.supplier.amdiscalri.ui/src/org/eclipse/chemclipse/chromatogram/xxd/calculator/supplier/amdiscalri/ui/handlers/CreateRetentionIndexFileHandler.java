/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.handlers;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.wizards.WizardCreateRetentionIndexFile;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;

public class CreateRetentionIndexFileHandler {

	@Execute
	public void execute() {

		WizardCreateRetentionIndexFile wizard = new WizardCreateRetentionIndexFile();
		WizardDialog wizardDialog = new WizardDialog(Display.getCurrent().getActiveShell(), wizard);
		wizardDialog.setPageSize(WizardCreateRetentionIndexFile.PREFERRED_WIDTH, WizardCreateRetentionIndexFile.PREFERRED_HEIGHT);
		try {
			wizardDialog.open();
		} finally {
			wizard.dispose();
		}
	}
}
