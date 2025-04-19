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
package org.eclipse.chemclipse.converter.io.support;

public interface ILittleEndianArrayReader {

	/*
	 * Unsigned Little Endian
	 */
	short read1BUShortLE();

	int read2BUIntegerLE();

	long read4BULongLE();

	/**
	 * The sign bit will be masked.
	 * 
	 * @return long
	 */
	long read8BULongLE();

	float read4BUFloatLE();

	/*
	 * Signed Little Endian
	 */
	short read1BShortLE();

	short read2BShortLE();

	int read2BIntegerLE();

	int read4BIntegerLE();

	long read4BLongLE();

	long read8BLongLE();

	float read4BFloatLE();

	/*
	 * Generic method
	 */
	/**
	 * The sign bit will be masked if 8 bytes are used.
	 * 
	 * @param numBytes
	 * @return long
	 */
	long readULongLE(int numBytes);

	/**
	 * The sign bit will be not masked if 8 bytes are used.
	 * But note, if less than 8 bytes are read, the sign bit will be not considered
	 * and the value will be read as unsigned.
	 * In such a case, use rather read2BShortLE() ...
	 * 
	 * @param numBytes
	 * @return long
	 */
	long readLongLE(int numBytes);

	/*
	 * Floating Point Little Endian
	 */
	double read8BUDoubleLE();

	double read8BDoubleLE();
}
