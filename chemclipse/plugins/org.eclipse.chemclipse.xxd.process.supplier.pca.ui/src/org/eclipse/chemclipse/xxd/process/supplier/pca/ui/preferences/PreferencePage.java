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
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.preferences;

import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.ExtendedIntegerFieldEditor;
import org.eclipse.chemclipse.support.ui.preferences.fieldeditors.SpacerFieldEditor;
import org.eclipse.chemclipse.swt.ui.support.Colors;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Algorithm;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.LabelOptionPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.Activator;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public PreferencePage() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setTitle("PCA");
		setDescription("");
	}

	@Override
	public void init(IWorkbench workbench) {

	}

	@Override
	protected void createFieldEditors() {

		addField(new ExtendedIntegerFieldEditor(PreferenceSupplier.P_NUMBER_OF_COMPONENTS, "Number of Components", PreferenceSupplier.MIN_NUMBER_OF_COMPONENTS, PreferenceSupplier.MAX_NUMBER_OF_COMPONENTS, getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_ALGORITHM, "Algorithm:", Algorithm.getOptions(), getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_REMOVE_USELESS_VARIABLES, "Remove Useless Variables", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_CROSS_VALIDATION, "Run Cross-validation", getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_LABEL_OPTION_PCA, "Label Option", LabelOptionPCA.getOptions(), getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_COLOR_SCHEME, "Color Scheme", Colors.getAvailableColorSchemes(), getFieldEditorParent()));

		addField(new SpacerFieldEditor(getFieldEditorParent()));
		addField(new FileFieldEditor(PreferenceSupplier.P_MAIN_DATA_FILE, "Main Data File for Long Data import", getFieldEditorParent()) {

			{
				setFileExtensions(new String[]{"*.pdl"});
			}
		});
	}
}