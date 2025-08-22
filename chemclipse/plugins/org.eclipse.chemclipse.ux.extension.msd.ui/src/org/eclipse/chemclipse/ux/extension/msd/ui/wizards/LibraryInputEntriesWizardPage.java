/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - use {@link DataExplorerTreeUI}
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.msd.ui.wizards;

import java.util.Collections;

import org.eclipse.chemclipse.ux.extension.msd.ui.Activator;
import org.eclipse.chemclipse.ux.extension.msd.ui.support.DatabaseSupport;
import org.eclipse.chemclipse.ux.extension.ui.swt.DataExplorerTreeRoot;
import org.eclipse.chemclipse.ux.extension.ui.swt.DataExplorerTreeUI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class LibraryInputEntriesWizardPage extends WizardPage {

	private TreeViewer libraryViewer;

	protected LibraryInputEntriesWizardPage(String pageName, String title, String description) {

		super(pageName);
		setTitle(title);
		setDescription(description);
	}

	/**
	 * Returns the library viewer selection.
	 * 
	 * @return
	 */
	public ISelection getSelection() {

		return libraryViewer.getSelection();
	}

	@Override
	public void createControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());

		DataExplorerTreeUI treeUI = new DataExplorerTreeUI(parent, DataExplorerTreeRoot.DRIVES, Collections.singleton(DatabaseSupport.getInstanceEditorSupport()));
		treeUI.expandLastDirectoryPath(Activator.getDefault().getPreferenceStore());
		libraryViewer = treeUI.getTreeViewer();

		setControl(composite);
	}
}
