/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.wsd.converter.supplier.scf.internal.support;

import org.eclipse.chemclipse.converter.io.support.IArrayReader;
import org.eclipse.chemclipse.wsd.converter.supplier.scf.model.Probability;

public interface ISequenceInformationArrayReader extends IArrayReader {

	int[] readPeakIndices(int numberBases);

	Probability readProbabilities(int numberBases);

	char[] readBaseCalls(int numberBases);

	byte[] readSpares(int numberBases);
}
