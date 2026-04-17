/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.preferences;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.Activator;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.LabelFieldEditor;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.SpacerFieldEditor;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public PreferencePage() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setTitle("Retention Index");
		setDescription("");
	}

	@Override
	protected void createFieldEditors() {

		addField(new LabelFieldEditor("Export Options", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_CALIBRATION_EXPORT_USE_CURATED_NAMES, "Use Curated Names", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_CALIBRATION_EXPORT_DERIVE_MISSING_INDICES, "Derive Missing Indices", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_OPEN_CALIBRATION_FILE_AFTER_PROCESSING, "Open calibration file after processing", getFieldEditorParent()));

		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new LabelFieldEditor("Import Calibration Files (*.cal)", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_USE_DIRECTORY_IMPORT_CALIBRATION_FILES, "Use a standard directory", getFieldEditorParent()));
		addField(new DirectoryFieldEditor(PreferenceSupplier.P_STANDARD_DIRECTORY_IMPORT_CALIBRATION_FILES, "Load files from directory", getFieldEditorParent()));

		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new LabelFieldEditor("Auto Loader", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_USE_AMDIS_CHROMATOGRAM_NAME, "Use Chromatogram Name", getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceSupplier.P_AMDIS_DEFAULT_NAME, "Default Name", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_PARSE_AMDIS_RETENTION_INDEX_DATA, "Parse Retention Index Data", getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {

	}
}
