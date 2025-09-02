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
package org.eclipse.chemclipse.support.traces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TraceFactory_03_Test {

	@Test
	public void test01() {

		assertEquals("b", TraceFactory.validate("139b > 111.0 @12 (x5.8)"));
	}

	@Test
	public void test02() {

		assertEquals("a", TraceFactory.validate("400.01627±10ppma (x4.7)"));
	}

	@Test
	public void test03() {

		assertEquals("a b x", TraceFactory.validate("18x 28b 32 84 207a"));
	}

	@Test
	public void test04() {

		assertEquals("Tab", TraceFactory.validate("18 28	32 84 207a"));
	}

	@Test
	public void test05() {

		assertEquals("New Line", TraceFactory.validate("18 28\n32 84 207a"));
	}

	@Test
	public void test06() {

		assertEquals("Carriage Return", TraceFactory.validate("18 28\r32 84 207a"));
	}
}