/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - add support for different datatype sets
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.methods;

import java.util.Collections;
import java.util.Map;

import org.eclipse.chemclipse.processing.DataCategory;
import org.eclipse.chemclipse.processing.methods.IProcessEntry;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplierContext;
import org.eclipse.chemclipse.ux.extension.ui.l10n.ExtensionMessages;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

public class ProcessingWizard extends Wizard {

	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 400;
	public static final String PROCESSING_SECTION = "JsonSection";
	public static final String PROCESSING_SETTINGS = "JsonSettings";

	private ProcessingWizard() {

		setWindowTitle(ExtensionMessages.settings);
		setDialogSettings(new DialogSettings(PROCESSING_SECTION));
		setNeedsProgressMonitor(true);
	}

	@Override
	public boolean performFinish() {

		return true;
	}

	public static Map<IProcessSupplierContext, IProcessEntry> open(Shell shell, Map<IProcessSupplierContext, String> contexts, DataCategory[] dataCategories) {

		ProcessingWizard wizard = new ProcessingWizard();
		ProcessingWizardPage wizardPage = new ProcessingWizardPage(contexts, dataCategories);
		wizard.addPage(wizardPage);
		WizardDialog wizardDialog = new WizardDialog(shell, wizard);
		wizardDialog.setMinimumPageSize(ProcessingWizard.DEFAULT_WIDTH, ProcessingWizard.DEFAULT_HEIGHT);
		wizardDialog.create();

		if(wizardDialog.open() == WizardDialog.OK) {
			return Collections.singletonMap(wizardPage.getProcessSupplierContext(), wizardPage.getProcessEntry());
		}

		return null;
	}
}
