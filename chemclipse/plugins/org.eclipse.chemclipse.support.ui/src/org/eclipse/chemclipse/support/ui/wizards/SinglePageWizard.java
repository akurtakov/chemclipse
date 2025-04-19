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

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

/**
 * A {@link Wizard} that only shows a single page
 *
 */
public class SinglePageWizard extends SimpleWizard {

	public SinglePageWizard(String title, WizardPage page) {
		this(title, false, page);
	}

	public SinglePageWizard(String title, boolean needsProgressMonitor, WizardPage page) {
		super(title, needsProgressMonitor, page);
	}

	@Override
	public boolean performFinish() {

		return true;
	}
}
