/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.pcr.report.supplier.tabular.csv.ui.preferences;

import org.eclipse.chemclipse.pcr.report.supplier.tabular.csv.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.pcr.report.supplier.tabular.csv.ui.Activator;
import org.eclipse.chemclipse.pcr.report.supplier.tabular.ui.editors.VirtualChannelFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class VirtualChannelsPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public VirtualChannelsPreferencePage() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Adds extra channels by combining existing ones according to these rules.");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	@Override
	public void createFieldEditors() {

		addField(new VirtualChannelFieldEditor(PreferenceSupplier.P_VIRTUAL_CHANNELS, "", getFieldEditorParent()));
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {

	}
}
