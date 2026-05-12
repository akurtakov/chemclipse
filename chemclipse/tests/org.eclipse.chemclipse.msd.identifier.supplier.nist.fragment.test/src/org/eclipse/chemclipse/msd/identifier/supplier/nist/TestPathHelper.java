/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.identifier.supplier.nist;

import java.io.File;

import org.eclipse.chemclipse.logging.support.Settings;

public class TestPathHelper {

	public static String getStoragePath() {

		return System.getProperty("user.home") + File.separator + "." + Settings.getApplicationName().toLowerCase() + "/" + Settings.getVersionIdentifier() + "/org.eclipse.chemclipse.msd.identifier.supplier.nist";
	}
}
