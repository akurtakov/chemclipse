/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.jcampdx.ui.preferences;

import org.eclipse.chemclipse.support.model.SeparationColumnType;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.LabelFieldEditor;
import org.eclipse.chemclipse.xxd.converter.supplier.jcampdx.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.xxd.converter.supplier.jcampdx.ui.Activator;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public PreferencePage() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setTitle("JCAMP-DX");
		setDescription("");
	}

	@Override
	public void createFieldEditors() {

		addField(new LabelFieldEditor("Separation Column Types", getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_SEPARATION_COLUMN_TYPE_RETENTION_INDEX_1, "Retention Index 1", SeparationColumnType.getOptions(), getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_SEPARATION_COLUMN_TYPE_RETENTION_INDEX_2, "Retention Index 2", SeparationColumnType.getOptions(), getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_SEPARATION_COLUMN_TYPE_RETENTION_INDEX_3, "Retention Index 3", SeparationColumnType.getOptions(), getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {

	}
}