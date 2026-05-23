/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.massspectrum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.converter.core.Converter;
import org.junit.jupiter.api.Test;

/**
 * Testing MassSpectrumConverters isValid(String input) method. This method
 * tests if the input string contains not allowed characters like \/:*?"&lt;&gt;|
 */
public class MassSpectrumConverter_1_Test {

	@Test
	public void testIsValid_1() {

		String input = "abcdefg";
		boolean actual = Converter.isValid(input);
		assertEquals(true, actual, "Allowed characters");
	}

	@Test
	public void testIsValid_2() {

		String input = "\\/:*?\"<>|";
		boolean actual = Converter.isValid(input);
		assertEquals(false, actual, "Denied characters");
	}

	@Test
	public void testIsValid_3() {

		String input = "a\\";
		boolean actual = Converter.isValid(input);
		assertEquals(false, actual, "Denied characters");
	}

	@Test
	public void testIsValid_4() {

		String input = "a/";
		boolean actual = Converter.isValid(input);
		assertEquals(false, actual, "Denied characters");
	}

	@Test
	public void testIsValid_5() {

		String input = "a:";
		boolean actual = Converter.isValid(input);
		assertEquals(false, actual, "Denied characters");
	}

	@Test
	public void testIsValid_6() {

		String input = "a*";
		boolean actual = Converter.isValid(input);
		assertEquals(false, actual, "Denied characters");
	}

	@Test
	public void testIsValid_7() {

		String input = "a?";
		boolean actual = Converter.isValid(input);
		assertEquals(false, actual, "Denied characters");
	}

	@Test
	public void testIsValid_8() {

		String input = "a\"";
		boolean actual = Converter.isValid(input);
		assertEquals(false, actual, "Denied characters");
	}

	@Test
	public void testIsValid_9() {

		String input = "a<";
		boolean actual = Converter.isValid(input);
		assertEquals(false, actual, "Denied characters");
	}

	@Test
	public void testIsValid_10() {

		String input = "a>";
		boolean actual = Converter.isValid(input);
		assertEquals(false, actual, "Denied characters");
	}

	@Test
	public void testIsValid_11() {

		String input = "a|";
		boolean actual = Converter.isValid(input);
		assertEquals(false, actual, "Denied characters");
	}

	@Test
	public void testIsValid_12() {

		String input = "";
		boolean actual = Converter.isValid(input);
		assertEquals(true, actual, "Allowed characters");
	}

	@Test
	public void testIsValid_13() {

		String input = null;
		boolean actual = Converter.isValid(input);
		assertEquals(false, actual, "When input == null it should be false.");
	}
}
