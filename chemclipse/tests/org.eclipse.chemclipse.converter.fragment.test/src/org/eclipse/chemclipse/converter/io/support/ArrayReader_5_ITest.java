/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ArrayReader_5_ITest {

	/*
	 * Little Endian
	 */
	private byte[] prefix = new byte[]{31, -117, 8, 0, 0, 0, 0, 0, 4, 0};
	private byte[] tmp;

	@BeforeAll
	public void setUp() throws IOException {

		/*
		 * IMPORT_BIN_TEST:
		 * F0 A7 C1 0B 04 9F 01 3B
		 * 11110000 10100111 11000001 00001011 00000100 10011111 00000001 00111011
		 */
		File file = new File("testData/files/import/bin-test");
		IArrayReader arrayReader = new ArrayReaderTestImplementation(file);
		tmp = arrayReader.readBytes(prefix, 4);
	}

	@Test
	public void test_1() {

		assertEquals(14, tmp.length);
	}

	@Test
	public void test_2() {

		assertEquals(31, tmp[0]);
	}

	@Test
	public void test_3() {

		assertEquals(-117, tmp[1]);
	}

	@Test
	public void test_4() {

		assertEquals(4, tmp[8]);
	}

	@Test
	public void test_5() {

		assertEquals(0, tmp[9]);
	}

	@Test
	public void test_6() {

		assertEquals(-16, tmp[10]);
	}

	@Test
	public void test_7() {

		assertEquals(11, tmp[13]);
	}
}
