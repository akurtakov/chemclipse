/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.msd.ui.dialogs;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.msd.model.core.IRegularLibraryMassSpectrum;
import org.eclipse.chemclipse.msd.swt.ui.components.identification.SynonymsEditUI;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

public class LibraryEntryEditDialog extends TitleAreaDialog {

	private AtomicReference<Text> textName = new AtomicReference<>();
	private AtomicReference<Text> textCasNumber = new AtomicReference<>();
	private AtomicReference<Text> textSmiles = new AtomicReference<>();

	private IRegularLibraryMassSpectrum massSpectrum;

	public LibraryEntryEditDialog(Shell parentShell, IRegularLibraryMassSpectrum massSpectrum) {

		super(parentShell);
		this.massSpectrum = massSpectrum;
	}

	@Override
	protected void configureShell(Shell shell) {

		super.configureShell(shell);
		shell.setText("Edit Library Entry");
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		setTitle("Library Entry");
		setMessage("Edit the name, CAS number, and SMILES of the library entry.", IMessageProvider.INFORMATION);
		Composite container = (Composite)super.createDialogArea(parent);

		TabFolder tabFolder = new TabFolder(container, SWT.BOTTOM);
		tabFolder.setLayoutData(new GridData(GridData.FILL_BOTH));

		createTabGeneral(tabFolder);
		createTabSynonyms(tabFolder);

		return container;
	}

	@Override
	protected void okPressed() {

		ILibraryInformation libraryInformation = massSpectrum.getLibraryInformation();
		if(libraryInformation != null) {
			libraryInformation.setName(textName.get().getText().trim());
			libraryInformation.setCasNumber(textCasNumber.get().getText().trim());
			libraryInformation.setSmiles(textSmiles.get().getText().trim());
		}
		super.okPressed();
	}

	@Override
	protected boolean isResizable() {

		return true;
	}

	@Override
	protected Point getInitialSize() {

		return new Point(500, 400);
	}

	private void createTabGeneral(TabFolder tabFolder) {

		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("General");

		ILibraryInformation libraryInformation = massSpectrum.getLibraryInformation();

		Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		createLabel(composite, "Name:");
		textName.set(createText(composite, libraryInformation != null ? libraryInformation.getName() : ""));

		createLabel(composite, "CAS Number:");
		textCasNumber.set(createText(composite, libraryInformation != null ? libraryInformation.getCasNumber() : ""));

		createLabel(composite, "SMILES:");
		textSmiles.set(createText(composite, libraryInformation != null ? libraryInformation.getSmiles() : ""));

		tabItem.setControl(composite);
	}

	private void createTabSynonyms(TabFolder tabFolder) {

		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Synonyms");

		Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayout(new FillLayout());

		SynonymsEditUI synonymsEditUI = new SynonymsEditUI(composite, SWT.NONE);
		synonymsEditUI.update(massSpectrum.getLibraryInformation());

		tabItem.setControl(composite);
	}

	private void createLabel(Composite parent, String text) {

		Label label = new Label(parent, SWT.NONE);
		label.setText(text);
	}

	private Text createText(Composite parent, String value) {

		Text text = new Text(parent, SWT.BORDER);
		text.setText(value != null ? value : "");
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return text;
	}
}