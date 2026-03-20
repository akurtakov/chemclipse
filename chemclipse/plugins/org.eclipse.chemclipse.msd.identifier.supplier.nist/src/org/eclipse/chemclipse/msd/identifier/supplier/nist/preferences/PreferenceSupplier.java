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
 * Christoph Läubrich - using a global configuration for the nist path + add support for validate the path
 *******************************************************************************/
package org.eclipse.chemclipse.msd.identifier.supplier.nist.preferences;

import java.io.File;

import org.eclipse.chemclipse.support.preferences.AbstractPreferenceSupplier;
import org.eclipse.chemclipse.support.preferences.IPreferenceSupplier;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.osgi.framework.FrameworkUtil;

public class PreferenceSupplier extends AbstractPreferenceSupplier {

	public static final String MSP_EXPORT_FILE_NAME = "openchrom-unknown.msp";
	/*
	 * Preferences
	 */
	public static final String P_NIST_APPLICATION = "nistApplication";
	public static final String P_MAC_WINE_BINARY = "macWineBinary";
	public static final String DEF_MAC_WINE_BINARY = "/Applications/Wine.app";

	public static IPreferenceSupplier INSTANCE() {

		return INSTANCE(PreferenceSupplier.class);
	}

	@Override
	public String getPreferenceNode() {

		return FrameworkUtil.getBundle(PreferenceSupplier.class).getSymbolicName();
	}

	@Override
	public void initializeDefaults() {

		putDefault(P_MAC_WINE_BINARY, DEF_MAC_WINE_BINARY);
	}

	/**
	 * This fetches the <b>FOLDER</b> where the NIST application is stored (e.g. c:\NIST\MSSEARCH)
	 *
	 * @return the path where the NIST application is stored or <code>null</code> if no such folder is currently stored or exits
	 */
	public static File getNistInstallationFolder() {

		IEclipsePreferences preferences = INSTANCE().getPreferences();
		String path = preferences.get(P_NIST_APPLICATION, "");
		if(!path.isEmpty()) {
			File filePath = new File(path);
			if(filePath.isFile()) {
				filePath.getParentFile();
			}
			if(filePath.isDirectory()) {
				File subfolder = new File(filePath, "MSSEARCH");
				if(subfolder.isDirectory()) {
					return subfolder;
				}
				return filePath;
			}
		}
		return null;
	}

	public static IStatus validateLocation(File location) {

		if(location == null) {
			return error("No Program-Location configured");
		}
		if(!location.isDirectory()) {
			return error("Location " + location.getAbsolutePath() + " does not exits or is not a directory");
		}
		File file = getNistExecutable(location);
		if(!file.isFile()) {
			return error("Can't find nistms.exe at path " + location.getAbsolutePath() + " or it can't be accessed");
		}
		File[] libraries = getLibraries(location);
		if(libraries.length == 0) {
			return error("Can't find any libraries at path " + location.getAbsolutePath());
		}
		return Status.OK_STATUS;
	}

	public static File[] getLibraries(File location) {

		if(location.isDirectory()) {
			File[] files = location.listFiles(File::isDirectory);
			if(files != null) {
				return files;
			}
		}
		return new File[0];
	}

	public static File getNistExecutable(File location) {

		File file = new File(location, "nistms.exe");
		if(!file.exists()) {
			File subfolder = new File(location, "MSSEARCH");
			if(subfolder.isDirectory()) {
				return getNistExecutable(subfolder);
			}
		}
		return file;
	}

	private static final IStatus error(String message) {

		return Status.error(message);
	}

	public static String getMacWineBinary() {

		return INSTANCE().get(P_MAC_WINE_BINARY, DEF_MAC_WINE_BINARY);
	}
}