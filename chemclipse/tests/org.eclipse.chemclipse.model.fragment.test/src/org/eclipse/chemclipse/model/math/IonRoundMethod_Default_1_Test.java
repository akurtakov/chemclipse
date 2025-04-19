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

public class IonRoundMethod_Default_1_Test extends TestCase {

	private IonRoundMethod ionRoundMethod = IonRoundMethod.DEFAULT;

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

		assertEquals(18, ionRoundMethod.round(18.0d));
	}

	public void test6() {

		assertEquals(18, ionRoundMethod.round(18.49d));
	}

	public void test7() {

		assertEquals(19, ionRoundMethod.round(18.50d));
	}

	public void test8() {

		assertEquals(19, ionRoundMethod.round(18.99d));
	}

	public void test10() {

		assertEquals("Default: round to nearest integer", ionRoundMethod.label());
	}
}