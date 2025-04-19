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
package org.eclipse.chemclipse.chromatogram.xxd.report.ui.internal.wizards;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Dr. Philip Wenig
 * 
 */
public class ProcessWizardDialog extends WizardDialog {

	/**
	 * @param parentShell
	 * @param newWizard
	 */
	public ProcessWizardDialog(Shell parentShell, IWizard newWizard) {
		super(parentShell, newWizard);
	}
}
