/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.pdfbox.extensions.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class UnitConverter_2_Test {

	private IUnitConverter converter;

	@BeforeAll
	public void setUp() {

		converter = ConverterFactory.getInstance(Unit.INCH);
	}

	@Test
	public void test1a() {

		assertEquals(-72.0f, converter.convertToPt(-1.0f), 0);
	}

	@Test
	public void test1b() {

		assertEquals(-1.0f, converter.convertFromPt(-72.0f), 0);
	}

	@Test
	public void test2a() {

		assertEquals(0.0f, converter.convertToPt(0.0f), 0);
	}

	@Test
	public void test2b() {

		assertEquals(0.0f, converter.convertFromPt(0.0f), 0);
	}

	@Test
	public void test3a() {

		assertEquals(72.0f, converter.convertToPt(1.0f), 0);
	}

	@Test
	public void test3b() {

		assertEquals(1.0f, converter.convertFromPt(72.0f), 0);
	}
}
