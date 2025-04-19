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

public class SamplePointsByteArrayReader extends AbstractArrayReader implements ISamplePointsByteArrayReader {

	public SamplePointsByteArrayReader(File file) throws IOException {

		super(file);
	}

	@Override
	public byte[] readAdenine(int numberBases) {

		return readBytes(numberBases);
	}

	@Override
	public byte[] readThymine(int numberBases) {

		return readBytes(numberBases);
	}

	@Override
	public byte[] readGuanine(int numberBases) {

		return readBytes(numberBases);
	}

	@Override
	public byte[] readCytosine(int numberBases) {

		return readBytes(numberBases);
	}
}
