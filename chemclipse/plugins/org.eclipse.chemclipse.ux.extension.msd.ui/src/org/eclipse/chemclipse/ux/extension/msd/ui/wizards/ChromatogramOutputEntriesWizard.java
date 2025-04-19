/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.msd.ui.wizards;

import org.eclipse.jface.wizard.Wizard;

import org.eclipse.chemclipse.converter.exceptions.NoConverterAvailableException;
import org.eclipse.chemclipse.converter.model.IChromatogramOutputEntry;

/**
 * @author Dr. Philip Wenig
 * 
 */
public class ChromatogramOutputEntriesWizard extends Wizard {

	private ChromatogramOutputEntriesWizardPage outputEntriesPage;
	private IChromatogramOutputEntry outputEntry = null;

	public ChromatogramOutputEntriesWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * Returns the chromatogram output entry.
	 * May return null.
	 * 
	 * @return IChromatogramOutputEntry
	 */
	public IChromatogramOutputEntry getChromatogramOutputEntry() {

		return outputEntry;
	}

	@Override
	public boolean performFinish() {

		try {
			outputEntry = outputEntriesPage.getChromatogramOutputEntry();
		} catch(NoConverterAvailableException e) {
			outputEntry = null;
		}
		return true;
	}

	@Override
	public void addPages() {

		outputEntriesPage = new ChromatogramOutputEntriesWizardPage("Output Chromatogram Formats");
		addPage(outputEntriesPage);
	}
}
