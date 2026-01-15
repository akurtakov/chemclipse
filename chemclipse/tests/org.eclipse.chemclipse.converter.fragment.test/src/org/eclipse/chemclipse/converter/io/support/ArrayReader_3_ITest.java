/*******************************************************************************
 * Copyright (c) 2012, 2026 Lablicate GmbH.
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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.converter.PathResolver;
import org.eclipse.chemclipse.converter.TestPathHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.osgi.framework.FrameworkUtil;

public class ArrayReader_3_ITest {

	/*
	 * Little Endian
	 */
	private IArrayReader arrayReader;

	@BeforeEach
	public void setUp() throws IOException {

		/*
		 * IMPORT_BIN_TEST:
		 * F0 A7 C1 0B 04 9F 01 3B
		 * 11110000 10100111 11000001 00001011 00000100 10011111 00000001 00111011
		 */
		File file = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.TESTFILE_IMPORT_BIN_TEST);
		arrayReader = new ArrayReaderTestImplementation(file);
	}

	@Test
	public void testRead4BUIntegerME_1() {

		assertEquals(670043073, arrayReader.read4BUIntegerME());
	}

	@Test
	public void testRead4BULongME_1() {

		assertEquals(2817526721L, arrayReader.read4BULongME());
	}
}
