/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.ui.preferences;

import org.eclipse.chemclipse.msd.converter.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.msd.converter.ui.Activator;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.LabelFieldEditor;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.SpacerFieldEditor;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class ConverterPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public ConverterPreferencePage() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setTitle("Converter (MSD)");
		setDescription("");
	}

	@Override
	protected void createFieldEditors() {

		addField(new StringFieldEditor(PreferenceSupplier.P_REFERENCE_IDENTIFIER_MARKER, "Reference ID Marker", getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceSupplier.P_REFERENCE_IDENTIFIER_PREFIX, "Reference ID Prefix", getFieldEditorParent()));
		//
		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new LabelFieldEditor("MassLib", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_USE_MASSLIB_CHROMATOGRAM_NAME, "Use Chromatogram Name", getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceSupplier.P_MASSLIB_DEFAULT_NAME, "Default Name", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_PARSE_MASSLIB_RETENTION_INDEX_DATA, "Parse Retention Index Data", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_PARSE_MASSLIB_TARGET_DATA, "Parse Target Data", getFieldEditorParent()));
		//
		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new LabelFieldEditor("AMDIS", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_USE_AMDIS_CHROMATOGRAM_NAME, "Use Chromatogram Name", getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceSupplier.P_AMDIS_DEFAULT_NAME, "Default Name", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_PARSE_AMDIS_RETENTION_INDEX_DATA, "Parse Retention Index Data", getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {

	}
}