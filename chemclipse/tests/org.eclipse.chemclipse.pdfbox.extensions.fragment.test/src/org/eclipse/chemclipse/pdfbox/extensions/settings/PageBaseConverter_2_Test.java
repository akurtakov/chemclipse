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

import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PageBaseConverter_2_Test {

	private IPageBaseConverter converter;
	private PDRectangle pdRectangle;

	@BeforeAll
	public void setUp() {

		converter = ConverterFactory.getInstance(PageBase.TOP_LEFT);
		pdRectangle = PDRectangle.A4;
	}

	@Test
	public void test1a() {

		assertEquals(-1.0f, converter.getPositionX(pdRectangle.getWidth(), -1.0f), 0);
	}

	@Test
	public void test1b() {

		assertEquals(0.0f, converter.getPositionX(pdRectangle.getWidth(), 0.0f), 0);
	}

	@Test
	public void test1c() {

		assertEquals(1.0f, converter.getPositionX(pdRectangle.getWidth(), 1.0f), 0);
	}

	@Test
	public void test2a() {

		assertEquals(842.8898f, converter.getPositionY(pdRectangle.getHeight(), -1.0f), 0);
	}

	@Test
	public void test2b() {

		assertEquals(841.8898f, converter.getPositionY(pdRectangle.getHeight(), 0.0f), 0);
	}

	@Test
	public void test2c() {

		assertEquals(840.8898f, converter.getPositionY(pdRectangle.getHeight(), 1.0f), 0);
	}
}
