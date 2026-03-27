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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.handlers;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.wizards.WizardCreateRetentionIndexFile;
import org.eclipse.e4.core.contexts.Active;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

public class CreateRetentionIndexFileHandler {

	@Execute
	public void execute(@Active Shell shell) {

		WizardCreateRetentionIndexFile wizard = new WizardCreateRetentionIndexFile();
		WizardDialog wizardDialog = new WizardDialog(shell, wizard);
		wizardDialog.setPageSize(WizardCreateRetentionIndexFile.PREFERRED_WIDTH, WizardCreateRetentionIndexFile.PREFERRED_HEIGHT);
		try {
			wizardDialog.open();
		} finally {
			wizard.dispose();
		}
	}
}
