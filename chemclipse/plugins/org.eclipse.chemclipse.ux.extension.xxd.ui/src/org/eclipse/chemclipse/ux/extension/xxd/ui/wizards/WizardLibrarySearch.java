/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.wizards;

import org.eclipse.chemclipse.model.library.LibrarySearchSettings;
import org.eclipse.jface.wizard.Wizard;

public class WizardLibrarySearch extends Wizard {

	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 400;
	//
	private PageLibrarySearch pageLibrarySearch;
	private LibrarySearchSettings librarySearchSettings;

	public WizardLibrarySearch(LibrarySearchSettings librarySearchSettings) {

		this.librarySearchSettings = librarySearchSettings;
	}

	@Override
	public void addPages() {

		super.addPages();
		addPage(pageLibrarySearch = new PageLibrarySearch(librarySearchSettings));
	}

	@Override
	public boolean canFinish() {

		return pageLibrarySearch.canFinish();
	}

	@Override
	public boolean performFinish() {

		return true;
	}
}