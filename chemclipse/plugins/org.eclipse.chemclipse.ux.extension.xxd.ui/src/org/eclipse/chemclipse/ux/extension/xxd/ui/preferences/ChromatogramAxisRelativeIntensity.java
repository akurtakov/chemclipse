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

public class ChromatogramAxisRelativeIntensity extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public ChromatogramAxisRelativeIntensity() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setTitle("Chromatogram Intensity% (Y Axis)");
		setDescription("");
	}

	@Override
	public void createFieldEditors() {

		addField(new StringFieldEditor(PreferenceSupplier.P_FORMAT_Y_AXIS_RELATIVE_INTENSITY, ExtensionMessages.format + ":", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_SHOW_Y_AXIS_RELATIVE_INTENSITY, ExtensionMessages.show, getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_POSITION_Y_AXIS_RELATIVE_INTENSITY, ExtensionMessages.position + ":", ChartOptions.POSITIONS, getFieldEditorParent()));
		addField(new ComboFieldEditor(PreferenceSupplier.P_GRIDLINE_STYLE_Y_AXIS_RELATIVE_INTENSITY, ExtensionMessages.gridLineStyle + ":", ChartOptions.LINE_STYLES, getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceSupplier.P_SHOW_Y_AXIS_TITLE_RELATIVE_INTENSITY, ExtensionMessages.showAxisTitle, getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {

	}
}
