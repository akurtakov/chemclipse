/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.converter.io.reports;

import java.io.File;

public abstract class AbstractReportExportConverter {

	protected static final String DELIMITER = ",";

	protected File getFile(File sinkDirectory, String fileName, String extension) {

		return getFile(sinkDirectory, "", fileName, extension);
	}

	protected File getFile(File sinkDirectory, String folder, String fileName, String extension) {

		String directory = sinkDirectory.getAbsolutePath();
		if(!directory.endsWith(File.separator)) {
			directory += File.separator;
		}
		/*
		 * Try to create the specified folder on demand.
		 */
		if(folder != null && !folder.equals("")) {
			if(!folder.endsWith(File.separator)) {
				folder += File.separator;
			}

			directory += folder;

			File exportFolder = new File(directory);
			if(!exportFolder.exists()) {
				exportFolder.mkdir();
			}
		}

		return new File(directory + fileName + extension);
	}
}
