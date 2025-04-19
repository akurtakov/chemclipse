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
package org.eclipse.chemclipse.model.ranges;

import junit.framework.TestCase;

public class TimeRange_6_Test extends TestCase {

	private TimeRange timeRange;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		timeRange = new TimeRange("Test", 500, 350, 200);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void test0() {

		assertEquals("Test", timeRange.getIdentifier());
	}

	public void test1() {

		assertEquals(200, timeRange.getStart());
	}

	public void test2() {

		assertEquals(350, timeRange.getMaximum());
	}

	public void test3() {

		assertEquals(500, timeRange.getStop());
	}
}
