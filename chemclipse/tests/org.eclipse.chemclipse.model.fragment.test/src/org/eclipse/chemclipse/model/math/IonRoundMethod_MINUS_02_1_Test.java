/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.math;

import junit.framework.TestCase;

public class IonRoundMethod_MINUS_02_1_Test extends TestCase {

	private IonRoundMethod ionRoundMethod = IonRoundMethod.MINUS_02;

	public void test1() {

		assertEquals(0, ionRoundMethod.round(Double.NaN));
	}

	public void test2() {

		assertEquals(0, ionRoundMethod.round(Double.NEGATIVE_INFINITY));
	}

	public void test3() {

		assertEquals(0, ionRoundMethod.round(Double.POSITIVE_INFINITY));
	}

	public void test4() {

		assertEquals(0, ionRoundMethod.round(-Double.MIN_NORMAL));
	}

	public void test5() {

		assertEquals(17, ionRoundMethod.round(17.7d));
	}

	public void test6() {

		assertEquals(18, ionRoundMethod.round(17.8d));
	}

	public void test7() {

		assertEquals(18, ionRoundMethod.round(17.9d));
	}

	public void test8() {

		assertEquals(18, ionRoundMethod.round(18.7d));
	}

	public void test9() {

		assertEquals(19, ionRoundMethod.round(18.8d));
	}

	public void test10() {

		assertEquals("Round m/z from -0.2 (incl.) to +0.8 (excl.)", ionRoundMethod.label());
	}
}