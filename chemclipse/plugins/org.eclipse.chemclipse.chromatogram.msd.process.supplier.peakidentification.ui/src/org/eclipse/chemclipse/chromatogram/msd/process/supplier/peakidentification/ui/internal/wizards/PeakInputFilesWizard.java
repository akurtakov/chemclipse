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
package org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.ui.internal.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;

/**
 * @author Dr. Philip Wenig
 * 
 */
public class PeakInputFilesWizard extends Wizard {

	private PeakInputFilesWizardPage inputEntriesPage;
	private List<String> selectedPeakFiles;

	public PeakInputFilesWizard() {

		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public boolean performFinish() {

		ISelection selection = inputEntriesPage.getSelection();
		IStructuredSelection structuredSelection = (IStructuredSelection)selection;
		selectedPeakFiles = new ArrayList<>();
		for(Object element : structuredSelection.toList()) {
			selectedPeakFiles.add(element.toString());
		}
		return true;
	}

	/**
	 * Returns the selected chromatograms.
	 * 
	 * @return List<String>
	 */
	public List<String> getSelectedPeakFiles() {

		return selectedPeakFiles;
	}

	@Override
	public void addPages() {

		inputEntriesPage = new PeakInputFilesWizardPage("Input Peak Files");
		addPage(inputEntriesPage);
	}
}
