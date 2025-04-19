/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.report.supplier.txt.internal.support;

import java.io.File;

public class SpecificationValidator {

	/**
	 * Use only static methods.
	 */
	private SpecificationValidator() {

	}

	/**
	 * Validates the given file.<br/>
	 * 
	 * @param file
	 */
	public static File validateSpecification(File file) {

		if(file == null) {
			return null;
		}
		/*
		 * Validate
		 */
		File validFile;
		String path = file.getAbsolutePath().toLowerCase();
		if(file.isDirectory()) {
			validFile = new File(file.getAbsolutePath() + File.separator + "ChemClipseReport.txt");
		} else {
			if(path.endsWith(".")) {
				validFile = new File(file.getAbsolutePath() + "txt");
			} else if(!path.endsWith(".txt")) {
				validFile = new File(file.getAbsolutePath() + ".txt");
			} else {
				validFile = file;
			}
		}
		return validFile;
	}
}