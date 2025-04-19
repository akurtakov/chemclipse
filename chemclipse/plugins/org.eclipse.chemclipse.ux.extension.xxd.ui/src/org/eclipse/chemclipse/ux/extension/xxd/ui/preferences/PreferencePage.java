/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.processing.converter.ISupplierFileIdentifier;
import org.eclipse.chemclipse.ux.extension.xxd.ui.Activator;
import org.eclipse.chemclipse.ux.extension.xxd.ui.l10n.ExtensionMessages;
import org.eclipse.chemclipse.ux.extension.xxd.ui.services.EditorServicesSupport;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public PreferencePage() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setTitle("User Interface Settings");
		setDescription("");
	}

	@Override
	public void createFieldEditors() {

		addField(new DirectoryFieldEditor(PreferenceSupplier.P_TIME_RANGE_TEMPLATE_FOLDER, ExtensionMessages.timeRangePath, getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_EDITOR_TSD, ExtensionMessages.editorTSD, EditorServicesSupport.getAvailableEditors(ISupplierFileIdentifier.TYPE_TSD), getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_HEADER_DATA_USE_RICH_TEXT_EDITOR, "Rich Text Editor (Header Data)", getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {

	}
}