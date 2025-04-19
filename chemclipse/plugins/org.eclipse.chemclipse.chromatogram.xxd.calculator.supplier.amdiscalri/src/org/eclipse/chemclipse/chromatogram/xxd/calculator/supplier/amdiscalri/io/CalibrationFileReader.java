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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.io;

import java.io.File;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.io.AMDISConverter;
import org.eclipse.chemclipse.model.columns.ISeparationColumnIndices;

public class CalibrationFileReader {

	public ISeparationColumnIndices parse(File file) {

		return new AMDISConverter().parse(file);
	}
}