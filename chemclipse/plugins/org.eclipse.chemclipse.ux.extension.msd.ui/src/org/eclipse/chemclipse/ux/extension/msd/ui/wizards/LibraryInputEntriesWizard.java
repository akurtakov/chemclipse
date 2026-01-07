/*******************************************************************************
 * Copyright (c) 2015, 2026 Lablicate GmbH.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;

public class LibraryInputEntriesWizard extends Wizard {

	private LibraryInputEntriesWizardPage inputEntriesPage;
	private List<String> selectedLibraries;
	private String pageName;
	private String title;
	private String description;

	public LibraryInputEntriesWizard(String pageName, String title, String description) {

		super();
		setNeedsProgressMonitor(true);
		this.pageName = pageName;
		this.title = title;
		this.description = description;
	}

	@Override
	public boolean performFinish() {

		ISelection selection = inputEntriesPage.getSelection();
		IStructuredSelection structuredSelection = (IStructuredSelection)selection;
		selectedLibraries = new ArrayList<>();
		for(Object element : structuredSelection.toList()) {
			selectedLibraries.add(element.toString());
		}
		return true;
	}

	/**
	 * Returns the selected libraries.
	 * 
	 * @return List<String>
	 */
	public List<String> getSelectedLibraries() {

		return selectedLibraries;
	}

	@Override
	public void addPages() {

		inputEntriesPage = new LibraryInputEntriesWizardPage(pageName, title, description);
		addPage(inputEntriesPage);
	}
}
