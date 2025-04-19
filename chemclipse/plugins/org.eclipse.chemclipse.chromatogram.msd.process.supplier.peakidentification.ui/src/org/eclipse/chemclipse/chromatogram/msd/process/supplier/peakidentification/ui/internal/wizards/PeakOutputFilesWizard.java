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
package org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.ui.internal.wizards;

import org.eclipse.jface.wizard.Wizard;

import org.eclipse.chemclipse.converter.exceptions.NoConverterAvailableException;
import org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.model.IPeakOutputEntry;

/**
 * @author Dr. Philip Wenig
 * 
 */
public class PeakOutputFilesWizard extends Wizard {

	private PeakOutputFilesWizardPage outputEntriesPage;
	private IPeakOutputEntry outputEntry = null;

	public PeakOutputFilesWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * Returns the chromatogram output entry.
	 * May return null.
	 * 
	 * @return IChromatogramOutputEntry
	 */
	public IPeakOutputEntry getPeakOutputEntry() {

		return outputEntry;
	}

	@Override
	public boolean performFinish() {

		try {
			outputEntry = outputEntriesPage.getPeakOutputEntry();
		} catch(NoConverterAvailableException e) {
			outputEntry = null;
		}
		return true;
	}

	@Override
	public void addPages() {

		outputEntriesPage = new PeakOutputFilesWizardPage("Output Peak Formats");
		addPage(outputEntriesPage);
	}
}
