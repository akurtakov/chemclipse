/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.text;

import java.text.NumberFormat;
import java.text.ParseException;

import junit.framework.TestCase;

public class ValueFormat_4_Test extends TestCase {

	private NumberFormat numberFormat;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		numberFormat = ValueFormat.getNumberFormatEnglish();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void test1() {

		try {
			assertEquals(0.0d, numberFormat.parse("0.0").doubleValue());
		} catch(ParseException e) {
			assertTrue(false);
		}
	}

	public void test2() {

		try {
			assertEquals(0.1d, numberFormat.parse("0.1").doubleValue());
		} catch(ParseException e) {
			assertTrue(false);
		}
	}

	public void test3() {

		try {
			assertEquals(1.0d, numberFormat.parse("1.0").doubleValue());
		} catch(ParseException e) {
			assertTrue(false);
		}
	}

	public void test4() {

		try {
			assertEquals(1.1d, numberFormat.parse("1.1").doubleValue());
		} catch(ParseException e) {
			assertTrue(false);
		}
	}
}
