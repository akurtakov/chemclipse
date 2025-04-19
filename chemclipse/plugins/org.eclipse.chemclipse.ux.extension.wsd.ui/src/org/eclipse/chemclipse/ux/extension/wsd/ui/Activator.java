/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.wsd.ui;

import org.eclipse.chemclipse.support.ui.activator.AbstractActivatorUI;
import org.eclipse.chemclipse.ux.extension.wsd.ui.preferences.PreferenceSupplier;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.service.datalocation.Location;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractActivatorUI {

	private static Activator plugin;

	public void start(BundleContext context) throws Exception {

		super.start(context);
		plugin = this;
		initializePreferenceStore(PreferenceSupplier.INSTANCE());
	}

	public void stop(BundleContext context) throws Exception {

		plugin = null;
		super.stop(context);
	}

	public static Activator getDefault() {

		return plugin;
	}

	/**
	 * Returns the absolute path of the specified Folder.
	 * 
	 * @return String
	 */
	public String getSettingsPath() {

		Location location = Platform.getUserLocation();
		return location.getURL().getPath().toString();
	}
}