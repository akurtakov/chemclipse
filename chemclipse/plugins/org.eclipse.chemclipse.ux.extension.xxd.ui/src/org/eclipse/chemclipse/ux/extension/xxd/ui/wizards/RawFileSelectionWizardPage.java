/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - complete rework and move to generic package
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.wizards;

import java.util.Collections;

import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.ux.extension.ui.swt.DataExplorerTreeRoot;
import org.eclipse.chemclipse.ux.extension.ui.swt.DataExplorerTreeUI;
import org.eclipse.chemclipse.xxd.process.files.SupplierFileIdentifier;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class RawFileSelectionWizardPage extends WizardPage {

	private TreeViewer treeViewer;
	private DataType dataType;

	public RawFileSelectionWizardPage(DataType dataType, String title, ImageDescriptor titleImage) {

		super(RawFileSelectionWizardPage.class.getName(), title, titleImage);
		this.dataType = dataType;
	}

	public IStructuredSelection getSelection() {

		return treeViewer.getStructuredSelection();
	}

	@Override
	public void createControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());

		DataExplorerTreeUI treeUI = new DataExplorerTreeUI(composite, DataExplorerTreeRoot.DRIVES, Collections.singleton(new SupplierFileIdentifier(dataType)));
		treeUI.expandLastDirectoryPath(new ScopedPreferenceStore(InstanceScope.INSTANCE, RawFileSelectionWizardPage.class.getName()));
		treeViewer = treeUI.getTreeViewer();

		setControl(composite);
	}
}