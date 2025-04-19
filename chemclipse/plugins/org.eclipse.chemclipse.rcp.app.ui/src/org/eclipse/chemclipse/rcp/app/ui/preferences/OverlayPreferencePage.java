/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.rcp.app.ui.preferences;

import org.eclipse.chemclipse.rcp.app.ui.Activator;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class OverlayPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public OverlayPreferencePage() {

		super(GRID);
	}

	@Override
	public void init(IWorkbench workbench) {

		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setTitle("Overlay");
		setDescription("");
	}

	@Override
	protected void createFieldEditors() {

	}
}
