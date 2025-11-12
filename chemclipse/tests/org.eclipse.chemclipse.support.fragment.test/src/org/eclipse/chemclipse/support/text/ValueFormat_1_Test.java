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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ValueFormat_1_Test {

	private DecimalFormat decimalFormat;

	@BeforeAll
	public void setUp() {

		decimalFormat = ValueFormat.getDecimalFormatEnglish();
	}

	@Test
	public void test1() {

		assertEquals("0", decimalFormat.format(0.0d));
	}

	@Test
	public void test2() {

		assertEquals("0.1", decimalFormat.format(0.1d));
	}

	@Test
	public void test3() {

		assertEquals("1", decimalFormat.format(1.0d));
	}

	@Test
	public void test4() {

		assertEquals("1.1", decimalFormat.format(1.1d));
	}
}
