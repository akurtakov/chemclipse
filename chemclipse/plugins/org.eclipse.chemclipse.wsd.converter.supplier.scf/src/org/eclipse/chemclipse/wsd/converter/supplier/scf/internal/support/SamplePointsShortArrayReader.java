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

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.converter.io.support.AbstractArrayReader;

public class SamplePointsShortArrayReader extends AbstractArrayReader implements ISamplePointsShortArrayReader {

	public SamplePointsShortArrayReader(File file) throws IOException {

		super(file);
	}

	@Override
	public short[] readAdenine(int numberBases) {

		return readShorts(numberBases);
	}

	@Override
	public short[] readThymine(int numberBases) {

		return readShorts(numberBases);
	}

	@Override
	public short[] readGuanine(int numberBases) {

		return readShorts(numberBases);
	}

	@Override
	public short[] readCytosine(int numberBases) {

		return readShorts(numberBases);
	}

	private short[] readShorts(int dataPoints) {

		short[] shortArray = new short[dataPoints];
		for(int i = 0; i < dataPoints; i++) {
			shortArray[i] = read2BShortBE();
		}
		return shortArray;
	}
}
