/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.runtime;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public abstract class AbstractWineRuntimeSupport extends AbstractRuntimeSupport implements IWineRuntimeSupport {

	private String wineEnvironment = "";
	private String wineApplication = "";

	protected AbstractWineRuntimeSupport(String application, List<String> parameters) throws FileNotFoundException {

		super(application, parameters);
		extractValues();
	}

	@Override
	public String getWineEnvironment() {

		return wineEnvironment;
	}

	@Override
	public String getWineApplication() {

		return wineApplication;
	}

	/**
	 * Extracts the values from the application path.
	 */
	private void extractValues() {

		String dosDevices = File.separator + "dosdevices" + File.separator;
		String drive = File.separator + "drive_";
		String[] parts = null;
		/*
		 * Get the parts.
		 */
		String nistApplication = getApplication();
		if(nistApplication.contains(dosDevices)) {
			/*
			 * /home/chemclipse/.wine/dosdevices/c:/Programme/NIST/MSSEARCH/nistms$.exe
			 * =>
			 * parts[0] = /home/chemclipse/.wine
			 * parts[1] = c:/Programme/NIST/MSSEARCH/nistms$.exe
			 */
			parts = nistApplication.split(dosDevices);
		} else if(nistApplication.contains(drive)) {
			/*
			 * /home/chemclipse/.wine/drive_c/Programme/NIST/MSSEARCH/nistms$.exe
			 * =>
			 * parts[0] = /home/chemclipse/.wine
			 * parts[1] = c/Programme/NIST/MSSEARCH/nistms$.exe
			 */
			parts = nistApplication.split(drive);
			/*
			 * parts[1] = c/Programme/NIST/MSSEARCH/nistms$.exe
			 * =>
			 * parts[1] = c:/Programme/NIST/MSSEARCH/nistms$.exe
			 */
			parts[1] = parts[1].replaceFirst("/", ":/");
		}
		/*
		 * Set the variables.
		 */
		if(parts != null) {
			wineEnvironment = parts[0]; // "/home/chemclipse/.wine"
			wineApplication = parts[1].replace("/", "\\"); // "c:\\Programme\\NIST\MSSEARCH\\nistms$.exe"
		}
	}
}
