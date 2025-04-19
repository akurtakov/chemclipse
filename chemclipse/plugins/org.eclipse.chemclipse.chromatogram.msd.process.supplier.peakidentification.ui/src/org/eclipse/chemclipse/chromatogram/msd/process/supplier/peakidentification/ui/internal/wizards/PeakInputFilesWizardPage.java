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

import org.eclipse.core.filesystem.EFS;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.chemclipse.ux.extension.msd.ui.provider.PeakFileExplorerContentProvider;
import org.eclipse.chemclipse.ux.extension.msd.ui.provider.PeakFileExplorerLabelProvider;

/**
 * @author Dr. Philip Wenig
 * 
 */
public class PeakInputFilesWizardPage extends WizardPage {

	private TreeViewer peakFileViewer;

	/**
	 * @param pageName
	 */
	protected PeakInputFilesWizardPage(String pageName) {
		super(pageName);
		setTitle("Peak Input Files");
		setDescription("This wizard lets you select several peak input files.");
	}

	/**
	 * Returns the chromatogram viewer selection.
	 * 
	 * @return
	 */
	public ISelection getSelection() {

		return peakFileViewer.getSelection();
	}

	@Override
	public void createControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());
		/*
		 * Chromatogram Tree Viewer
		 */
		peakFileViewer = new TreeViewer(composite, SWT.MULTI);
		peakFileViewer.setLabelProvider(new PeakFileExplorerLabelProvider());
		peakFileViewer.setContentProvider(new PeakFileExplorerContentProvider());
		peakFileViewer.setInput(EFS.getLocalFileSystem());
		/*
		 * Set the control.
		 */
		setControl(composite);
	}
}
