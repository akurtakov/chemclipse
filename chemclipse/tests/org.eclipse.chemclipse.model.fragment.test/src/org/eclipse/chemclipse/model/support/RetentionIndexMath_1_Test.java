/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.support;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RetentionIndexMath_1_Test {

	@Test
	public void test1() {

		/*
		 * On purpose - underlying RI calculation needs to be inspected.
		 */
		assertEquals(1498, RetentionIndexMath.rasterAlkaneIndex(1498.4f));
	}

	@Test
	public void test2() {

		assertEquals(1500, RetentionIndexMath.rasterAlkaneIndex(1498.5f));
	}

	@Test
	public void test3() {

		assertEquals(1500, RetentionIndexMath.rasterAlkaneIndex(1499.4f));
	}

	@Test
	public void test4() {

		assertEquals(1500, RetentionIndexMath.rasterAlkaneIndex(1499.5f));
	}

	@Test
	public void test5() {

		assertEquals(1500, RetentionIndexMath.rasterAlkaneIndex(1500.0f));
	}

	@Test
	public void test6() {

		assertEquals(1500, RetentionIndexMath.rasterAlkaneIndex(1500.4f));
	}

	@Test
	public void test7() {

		assertEquals(1500, RetentionIndexMath.rasterAlkaneIndex(1500.5f));
	}

	@Test
	public void test8() {

		assertEquals(1500, RetentionIndexMath.rasterAlkaneIndex(1501.4f));
	}

	@Test
	public void test9() {

		/*
		 * On purpose - underlying RI calculation needs to be inspected.
		 */
		assertEquals(1502, RetentionIndexMath.rasterAlkaneIndex(1501.5f));
	}
}