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
package org.eclipse.chemclipse.msd.converter.supplier.amdis.internal.converter;

import java.io.File;

public class SpecificationValidatorELU {

	/**
	 * Use only static methods.
	 */
	private SpecificationValidatorELU() {
	}

	/**
	 * Validates the given mass spectrum file.<br/>
	 * If the file is denoted only by a directory path, /MASSSPECTRA.ELU will be
	 * added. E.g.: /home/user/database will be validated to
	 * /home/user/database/MASSSPECTRA.ELU
	 * 
	 * @param file
	 */
	public static File validateSpecification(File file) {

		if(file == null) {
			return null;
		}
		/*
		 * Check the extension.
		 */
		File validFile;
		String path = file.getAbsolutePath().toUpperCase();
		if(file.isDirectory()) {
			validFile = new File(file.getAbsolutePath() + File.separator + "MASSSPECTRA.ELU");
		} else {
			if(path.endsWith(".")) {
				validFile = new File(file.getAbsolutePath() + "ELU");
			} else if(!path.endsWith(".ELU")) {
				validFile = new File(file.getAbsolutePath() + ".ELU");
			} else {
				validFile = file;
			}
		}
		return validFile;
	}
}
