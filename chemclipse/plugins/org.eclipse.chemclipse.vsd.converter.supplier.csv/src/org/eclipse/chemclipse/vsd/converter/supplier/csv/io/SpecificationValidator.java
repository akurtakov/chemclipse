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
package org.eclipse.chemclipse.vsd.converter.supplier.csv.io;

import java.io.File;

public class SpecificationValidator {

	/**
	 * Use only static methods.
	 */
	private SpecificationValidator() {

	}

	public static File validateSpecification(File file) {

		if(file == null) {
			return null;
		}
		/*
		 * Validate
		 */
		String path = file.getAbsolutePath().toLowerCase();
		if(path.endsWith(".csv")) {
			return file;
		} else {
			return null;
		}
	}
}
