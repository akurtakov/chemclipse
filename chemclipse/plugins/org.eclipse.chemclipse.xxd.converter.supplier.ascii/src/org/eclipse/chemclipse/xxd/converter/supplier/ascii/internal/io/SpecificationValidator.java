/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.ascii.internal.io;

import java.io.File;

public class SpecificationValidator {

	/**
	 * Use only static methods.
	 */
	private SpecificationValidator() {
	}

	public static File validateSpecification(File file, String extension) {

		if(file == null) {
			return null;
		}
		/*
		 * Validate
		 */
		File validFile;
		String path = file.getAbsolutePath().toLowerCase();
		if(file.isDirectory()) {
			validFile = new File(file.getAbsolutePath() + File.separator + "LIB." + extension);
		} else {
			if(path.endsWith(".")) {
				validFile = new File(file.getAbsolutePath() + extension);
			} else if(!path.endsWith("." + extension)) {
				validFile = new File(file.getAbsolutePath() + "." + extension);
			} else {
				validFile = file;
			}
		}
		return validFile;
	}
}
