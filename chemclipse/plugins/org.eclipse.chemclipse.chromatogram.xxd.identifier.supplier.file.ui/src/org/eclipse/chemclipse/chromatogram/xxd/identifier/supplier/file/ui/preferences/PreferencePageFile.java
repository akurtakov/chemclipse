/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.ui.preferences;

import org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.ui.Activator;
import org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.ui.editors.IdentifierTableEditor;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.SpacerFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePageFile extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public PreferencePageFile() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setTitle("File Identifier");
		setDescription("");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	@Override
	public void createFieldEditors() {

		/*
		 * Display all available import converter.
		 */
		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(createDatabaseFieldEditor(getFieldEditorParent()));
	}

	private IdentifierTableEditor createDatabaseFieldEditor(Composite parent) {

		return new IdentifierTableEditor(PreferenceSupplier.P_MASS_SPECTRA_FILES, "Mass Spectrum Libraries Cache (required for backwards search)", parent);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {

	}
}
