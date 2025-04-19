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

public class HeaderArrayReader extends AbstractArrayReader implements IHeaderArrayReader {

	public HeaderArrayReader(File file) throws IOException {

		super(file);
	}

	@Override
	public String readMagicNumber() {

		return readBytesAsString(4);
	}

	@Override
	public int readSampleNumber() {

		return read4BIntegerBE();
	}

	@Override
	public int readSampleOffset() {

		return read4BIntegerBE();
	}

	@Override
	public int readBaseNumber() {

		return read4BIntegerBE();
	}

	@Override
	public int readBasesLeftClip() {

		return read4BIntegerBE();
	}

	@Override
	public int readBasesRightClip() {

		return read4BIntegerBE();
	}

	@Override
	public int readBasesOffset() {

		return read4BIntegerBE();
	}

	@Override
	public int readCommentsSize() {

		return read4BIntegerBE();
	}

	@Override
	public int readCommentsOffset() {

		return read4BIntegerBE();
	}

	@Override
	public String readVersion() {

		return readBytesAsString(4);
	}

	@Override
	public int readSampleSize() {

		return read4BIntegerBE();
	}

	@Override
	public int readCodeSet() {

		return read4BIntegerBE();
	}

	@Override
	public int readPrivateSize() {

		return read4BIntegerBE();
	}

	@Override
	public int readPrivateOffset() {

		return read4BIntegerBE();
	}

	@Override
	public void skipSpare() {

		skipBytes(18);
	}
}
