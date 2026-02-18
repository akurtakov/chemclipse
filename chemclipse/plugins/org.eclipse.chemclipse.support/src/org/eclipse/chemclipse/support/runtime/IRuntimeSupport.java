/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
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

import java.io.IOException;
import java.util.List;

public interface IRuntimeSupport {

	/**
	 * Executes the run command and returns the process instance.
	 */
	Process executeRunCommand() throws IOException;

	/**
	 * Executes the open command and returns the process instance.
	 */
	Process executeOpenCommand() throws IOException;

	/**
	 * Executes the kill command and returns the process instance.
	 */
	Process executeKillCommand() throws IOException;

	/**
	 * Returns the path/file of the application exe.<br/>
	 * e.g.:<br/>
	 * "C:\Programs\NIST\MSSEARCH\NISTMS$.EXE"
	 */
	String getApplication();

	/**
	 * Returns the parameter.
	 * E.g. /INSTRUMENT /PAR=2
	 */
	List<String> getParameters();

	/**
	 * Return the path of the application exe.<br/>
	 * e.g.:<br/>
	 * "C:\Programs\NIST\MSSEARCH\"
	 */
	String getApplicationPath();

	List<String> getCommand();

	/**
	 * "nistms$.exe"
	 */
	String getApplicationExecutable();

	/**
	 * Tests whether the NistExecutable is valid.
	 * It should prevent killing other files than the nistms$.exe.
	 */
	boolean isValidApplicationExecutable();

	/**
	 * Default: 1000 ms
	 * 
	 * The execution works smoothly under Windows.
	 * But if it will be executed under Linux, the program execution shall be
	 * delayed depending on the numbers of unknown entries to process.
	 */
	int getSleepMillisecondsBeforeExecuteRunCommand();
}
