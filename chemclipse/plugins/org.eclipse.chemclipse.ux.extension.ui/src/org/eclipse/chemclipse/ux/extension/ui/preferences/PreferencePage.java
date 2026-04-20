/*******************************************************************************
 * Copyright (c) 2016, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.ui.preferences;

import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.LabelFieldEditor;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.SpacerFieldEditor;
import org.eclipse.chemclipse.ux.extension.ui.Activator;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public PreferencePage() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setTitle("Drive Settings");
		setDescription("");
	}

	@Override
	public void createFieldEditors() {

		addField(new BooleanFieldEditor(PreferenceSupplierDataExplorer.P_OPEN_FIRST_DATA_MATCH_ONLY, "Open First Data Match Only", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplierDataExplorer.P_OPEN_EDITOR_MULTIPLE_TIMES, "Open Editor Multiple Times", getFieldEditorParent()));
		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new LabelFieldEditor("Uncheck for better performance:", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplierDataExplorer.P_EXPAND_PRECHECK, "Check if folders can be expanded.", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplierDataExplorer.P_FILTER_FILES, "Only show applicable files.", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplierDataExplorer.P_SHOW_ICONS, "Display icons matching the file type.", getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {

	}
}