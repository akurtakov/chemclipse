/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.files;

import java.io.File;

import org.eclipse.chemclipse.logging.core.Logger;

public class FileSpecificationValidator {

	private static final Logger logger = Logger.getLogger(FileSpecificationValidator.class);

	public File validate(File file, String directoryExtension) {

		/*
		 * Check
		 */
		if(file == null) {
			return null;
		}
		//
		if(file.isDirectory()) {
			validateAndPatchDirectory(file, directoryExtension);
		} else {
		}
		//
		return file;
	}

	public File validateAndPatchDirectory(File file, String directoryExtension) {

		String fileName = file.getName().toLowerCase();
		directoryExtension = directoryExtension.toLowerCase();
		//
		if(!fileName.endsWith(directoryExtension)) {
			file = new File(file.getAbsolutePath() + directoryExtension);
			if(!file.mkdir()) {
				logger.info("The directory already exists: " + file.getAbsolutePath());
			}
		}
		//
		return file;
	}
}
