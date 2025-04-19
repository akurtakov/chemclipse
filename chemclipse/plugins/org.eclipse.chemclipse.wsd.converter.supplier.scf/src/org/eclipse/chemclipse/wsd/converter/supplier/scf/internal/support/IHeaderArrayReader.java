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

public interface IHeaderArrayReader extends IArrayReader {

	String readMagicNumber();

	/** @return Number of elements in Samples matrix */
	int readSampleNumber();

	/** @return Byte offset from start of file */
	int readSampleOffset();

	/** @return Number of bases in Bases matrix */
	int readBaseNumber();

	/** @return No. bases in left clip (vector) */
	@Deprecated
	int readBasesLeftClip();

	/** @return No. bases in right clip (qual) */
	@Deprecated
	int readBasesRightClip();

	/** @return Byte offset from start of file */
	int readBasesOffset();

	/** @return Number of bytes in Comment section */
	int readCommentsSize();

	/** @return Byte offset from start of file */
	int readCommentsOffset();

	/** @return "version.revision", e.g. '3' '.' '0' '0' */
	String readVersion();

	/** @return Size of samples in bytes */
	int readSampleSize();

	/** @return code set used (but ignored) */
	int readCodeSet();

	/** @return No. of bytes of Private data, 0 if none */
	int readPrivateSize();

	/** @return Byte offset from start of file */
	int readPrivateOffset();

	/** Unused */
	void skipSpare();
}
