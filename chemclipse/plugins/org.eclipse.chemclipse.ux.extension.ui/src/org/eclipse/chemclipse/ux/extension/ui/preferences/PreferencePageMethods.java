/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
 * 
 * All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.preferences;

import org.eclipse.chemclipse.ux.extension.ui.Activator;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePageMethods extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public PreferencePageMethods() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setTitle("Process Methods");
		setDescription("");
	}

	@Override
	public void createFieldEditors() {

		addField(new BooleanFieldEditor(PreferenceSupplierMethods.P_CREATE_METHOD_ENABLE_RESUME, "Create Methods (enable resume)", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplierMethods.P_SHOW_RESUME_METHOD_DIALOG, "Show Resume Method Dialog", getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {

	}
}