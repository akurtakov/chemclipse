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

import junit.framework.TestCase;

public class UnitConverter_4_Test extends TestCase {

	private IUnitConverter converter;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		converter = ConverterFactory.getInstance(Unit.PT);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void test1a() {

		assertEquals(-1.0f, converter.convertToPt(-1.0f));
	}

	public void test1b() {

		assertEquals(-1.0f, converter.convertFromPt(-1.0f));
	}

	public void test2a() {

		assertEquals(0.0f, converter.convertToPt(0.0f));
	}

	public void test2b() {

		assertEquals(0.0f, converter.convertFromPt(0.0f));
	}

	public void test3a() {

		assertEquals(1.0f, converter.convertToPt(1.0f));
	}

	public void test3b() {

		assertEquals(1.0f, converter.convertFromPt(1.0f));
	}
}
