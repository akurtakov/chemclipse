/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.preferences;

import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.LabelFieldEditor;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.SpacerFieldEditor;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.SpinnerFieldEditor;
import org.eclipse.chemclipse.ux.extension.xxd.ui.Activator;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swtchart.extensions.preferences.PreferenceSupport;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePageChromatogramScans extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public PreferencePageChromatogramScans() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setTitle("Chromatogram Scans");
		setDescription("");
	}

	@Override
	public void createFieldEditors() {

		addField(new LabelFieldEditor("Selected Scan", getFieldEditorParent()));
		addField(new ColorFieldEditor(PreferenceSupplier.P_COLOR_CHROMATOGRAM_SELECTED_SCAN, "Color:", getFieldEditorParent()));
		addField(new SpinnerFieldEditor(PreferenceSupplier.P_CHROMATOGRAM_SELECTED_SCAN_MARKER_SIZE, "Marker Size:", PreferenceSupplier.MIN_SYMBOL_SIZE, PreferenceSupplier.MAX_SYMBOL_SIZE, getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_CHROMATOGRAM_SELECTED_SCAN_MARKER_TYPE, "Marker Type:", PreferenceSupport.SYMBOL_TYPES, getFieldEditorParent()));

		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new LabelFieldEditor("Scan Labels", getFieldEditorParent()));

		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new LabelFieldEditor("Scan", getFieldEditorParent()));
		addField(new SpinnerFieldEditor(PreferenceSupplier.P_CHROMATOGRAM_SCAN_LABEL_SYMBOL_SIZE, "Marker Size:", PreferenceSupplier.MIN_SYMBOL_SIZE, PreferenceSupplier.MAX_SYMBOL_SIZE, getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_CHROMATOGRAM_SCAN_MARKER_TYPE, "Marker Type (Normal):", PreferenceSupport.SYMBOL_TYPES, getFieldEditorParent()));
		addField(new ColorFieldEditor(PreferenceSupplier.P_COLOR_CHROMATOGRAM_IDENTIFIED_SCAN, "Color (Identified):", getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_CHROMATOGRAM_IDENTIFIED_SCAN_MARKER_TYPE, "Marker Type (Identified):", PreferenceSupport.SYMBOL_TYPES, getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {

	}
}
