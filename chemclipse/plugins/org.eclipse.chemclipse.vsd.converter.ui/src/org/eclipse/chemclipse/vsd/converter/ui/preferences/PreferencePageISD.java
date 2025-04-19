/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.vsd.converter.ui.preferences;

import org.eclipse.chemclipse.vsd.converter.ui.Activator;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePageISD extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public PreferencePageISD() {

		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setTitle("ISD Converter");
		setDescription("");
	}

	@Override
	protected void createFieldEditors() {

	}

	@Override
	public void init(IWorkbench workbench) {

	}
}