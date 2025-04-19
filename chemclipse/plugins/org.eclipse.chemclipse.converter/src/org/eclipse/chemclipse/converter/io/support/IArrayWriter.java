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

public interface IArrayWriter {

	void write(byte[] bytes);

	void skipBytes(int bytes);

	byte[] getBytesStringTerminated(int writeBytes, String entry);

	byte[] getBytesStringNullTerminated(int writeBytes, String entry);

	void writeIntegerAsBigEndian(int value);

	byte[] get2BytesAsShortBigEndian(int value);

	byte[] get4BytesAsIntegerBigEndian(int value);

	void write2BytesUnsignedIntegerLittleEndian(int value);

	void write4BytesUnsignedIntegerLittleEndian(int value);

	void write8BytesUnsignedLittleEndian(long value);

	byte[] get2BytesLittleEndian(int value);

	byte[] get4BytesLittleEndian(int value);

	byte[] get8BytesLittleEndian(long value);
}
