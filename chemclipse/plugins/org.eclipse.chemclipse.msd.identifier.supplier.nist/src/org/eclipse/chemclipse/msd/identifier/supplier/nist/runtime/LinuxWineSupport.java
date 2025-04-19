/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - using a path instead of a string
 *******************************************************************************/
package org.eclipse.chemclipse.msd.identifier.supplier.nist.runtime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.chemclipse.msd.identifier.supplier.nist.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.support.runtime.AbstractLinuxWineSupport;

public class LinuxWineSupport extends AbstractLinuxWineSupport implements IExtendedRuntimeSupport {

	private final INistSupport nistSupport;

	public LinuxWineSupport(File applicationFolder, List<String> parameters) throws FileNotFoundException {

		super(PreferenceSupplier.getNistExecutable(applicationFolder).getAbsolutePath(), parameters);
		nistSupport = new NistSupport(this);
	}

	@Override
	public int getSleepMillisecondsBeforeExecuteRunCommand() {

		/*
		 * I've recognized that the e.g. NIST-DB sometimes don't start.
		 * Does a sleep time preventing this?
		 */
		return 4000;
	}

	@Override
	public boolean isValidApplicationExecutable() {

		return nistSupport.validateExecutable();
	}

	@Override
	public INistSupport getNistSupport() {

		return nistSupport;
	}

	@Override
	public Process executeKillCommand() throws IOException {

		return getKillCommand().start();
	}

	@Override
	public Process executeOpenCommand() throws IOException {

		return getOpenCommand().start();
	}

	private ProcessBuilder getKillCommand() {

		if(isValidApplicationExecutable()) {
			/*
			 * "pkill -f nist"
			 */
			return new ProcessBuilder("pkill", "-f", "nist");
		}
		return new ProcessBuilder();
	}

	private ProcessBuilder getOpenCommand() {

		/*
		 * "env WINEPREFIX=/home/eselmeister/.wine wine start C:\\programme\\nist\\MSSEARCH\\nistms.exe"
		 */
		String nistms = getWineApplication().replace("$.exe", ".exe"); // run the GUI version
		ProcessBuilder processBuilder = new ProcessBuilder("wine", "start", nistms);
		Map<String, String> environment = processBuilder.environment();
		environment.put("WINEPREFIX", getWineEnvironment());
		return processBuilder;
	}
}
