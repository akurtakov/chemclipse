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
 * Philip Wenig - enable profiles
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.methods;

import java.io.IOException;

import org.eclipse.chemclipse.processing.supplier.IProcessorPreferences;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Listener;

public interface SettingsUIProvider<SettingType> {

	SettingsUIControl createUI(Composite parent, IProcessorPreferences<SettingType> preferences, boolean showProfileToolbar) throws IOException;

	interface SettingsUIControl {

		void setEnabled(boolean enabled);

		IStatus validate();

		String getSettings() throws IOException;

		void addChangeListener(Listener listener);

		Control getControl();

		void restoreDefaults();
	}
}