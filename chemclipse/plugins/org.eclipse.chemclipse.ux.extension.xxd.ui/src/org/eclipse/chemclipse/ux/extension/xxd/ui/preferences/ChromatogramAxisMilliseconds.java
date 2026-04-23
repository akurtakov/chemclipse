/*******************************************************************************
 * Copyright (c) 2018, 2026 Lablicate GmbH.
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

import org.eclipse.chemclipse.ux.extension.xxd.ui.Activator;
import org.eclipse.chemclipse.ux.extension.xxd.ui.l10n.ExtensionMessages;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swtchart.extensions.charts.ChartOptions;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class ChromatogramAxisMilliseconds extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public ChromatogramAxisMilliseconds() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setTitle(ExtensionMessages.chromatogramMillisecondsXAxis);
		setDescription("");
	}

	@Override
	public void createFieldEditors() {

		addField(new StringFieldEditor(PreferenceSupplier.P_FORMAT_X_AXIS_MILLISECONDS, ExtensionMessages.format + ":", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_SHOW_X_AXIS_MILLISECONDS, ExtensionMessages.show, getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_POSITION_X_AXIS_MILLISECONDS, ExtensionMessages.position + ":", ChartOptions.POSITIONS, getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_GRIDLINE_STYLE_X_AXIS_MILLISECONDS, ExtensionMessages.gridLineStyle + ":", ChartOptions.LINE_STYLES, getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_SHOW_X_AXIS_TITLE_MILLISECONDS, ExtensionMessages.showAxisTitle + ":", getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {

	}
}