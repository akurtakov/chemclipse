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

import org.eclipse.jface.wizard.Wizard;

import org.eclipse.chemclipse.chromatogram.xxd.report.exceptions.NoReportSupplierAvailableException;
import org.eclipse.chemclipse.chromatogram.xxd.report.model.IChromatogramReportSupplierEntry;

/**
 * @author Dr. Philip Wenig
 * 
 */
public class ChromatogramReportEntriesWizard extends Wizard {

	private ChromatogramReportEntriesWizardPage reportEntriesPage;
	private IChromatogramReportSupplierEntry reportEntry = null;

	public ChromatogramReportEntriesWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * Returns the chromatogram report entry.
	 * May return null.
	 * 
	 * @return IChromatogramReportEntry
	 */
	public IChromatogramReportSupplierEntry getChromatogramReportEntry() {

		return reportEntry;
	}

	@Override
	public boolean performFinish() {

		try {
			reportEntry = reportEntriesPage.getChromatogramReportEntry();
		} catch(NoReportSupplierAvailableException e) {
			reportEntry = null;
		}
		return true;
	}

	@Override
	public void addPages() {

		reportEntriesPage = new ChromatogramReportEntriesWizardPage("Chromatogram Report Supplier");
		addPage(reportEntriesPage);
	}
}
