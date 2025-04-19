/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - refactoring settings preference page
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.preferences;

import org.eclipse.chemclipse.processing.supplier.IProcessSupplierContext;
import org.eclipse.chemclipse.processing.system.ProcessSettingsSupport;
import org.eclipse.chemclipse.ux.extension.ui.methods.SettingsPreferencesEditPage;
import org.eclipse.chemclipse.xxd.process.support.ProcessTypeSupport;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class PreferencePageProcessors extends PreferencePage {

	private IProcessSupplierContext processSupplierContext = new ProcessTypeSupport();

	public PreferencePageProcessors() {

		setTitle("User Process Settings");
		setDescription("Currently stored processor options, manage or remove the stored state.");
		noDefaultAndApplyButton();
	}

	@Override
	protected Control createContents(Composite parent) {

		SettingsPreferencesEditPage page = new SettingsPreferencesEditPage(() -> ProcessSettingsSupport.getPreferences(processSupplierContext));
		page.createControl(parent);
		//
		return page.getControl();
	}
}