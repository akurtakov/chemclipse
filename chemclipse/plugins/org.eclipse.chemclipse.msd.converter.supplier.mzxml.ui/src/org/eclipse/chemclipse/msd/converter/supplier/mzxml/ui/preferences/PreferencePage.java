/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.mzxml.ui.preferences;

import org.eclipse.chemclipse.msd.converter.supplier.mzxml.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.ui.Activator;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.SpacerFieldEditor;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public PreferencePage() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("mzXML Converter");
	}

	@Override
	public void createFieldEditors() {

		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_CHROMATOGRAM_VERSION_SAVE, "Save (*.mzXML) chromatograms as version:", PreferenceSupplier.getChromatogramVersions(), getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_MASS_SPECTRUM_VERSION_SAVE, "Save (*.mzXML) mass spectra as version:", PreferenceSupplier.getMassSpectrumVersions(), getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_CHROMATOGRAM_SAVE_COMPRESSION, "Compress values", getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {

	}
}
