/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.support.ui.wizards;

import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Shell;

/**
 * A {@link Wizard} that only shows a single page
 *
 */
public class SimpleWizard extends Wizard {

	public SimpleWizard(String title, boolean needsProgressMonitor, WizardPage... page) {

		for(WizardPage wizardPage : page) {
			addPage(wizardPage);
		}
		setWindowTitle(title);
		setNeedsProgressMonitor(needsProgressMonitor);
	}

	@Override
	public boolean performFinish() {

		return true;
	}

	public boolean openMaximized(Shell shell) {

		WizardDialog wizardDialog = new WizardDialog(shell, this) {

			@Override
			protected void constrainShellSize() {

				super.constrainShellSize();
				getShell().setMaximized(true);
			}
		};
		if(wizardDialog.open() == Window.OK) {
			return true;
		} else {
			return false;
		}
	}

	public boolean open(Shell shell, int width, int height) {

		WizardDialog wizardDialog = new WizardDialog(shell, this);
		wizardDialog.setMinimumPageSize(width, height);
		wizardDialog.setPageSize(width, height);
		if(wizardDialog.open() == Window.OK) {
			return true;
		} else {
			return false;
		}
	}
}
