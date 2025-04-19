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
package org.eclipse.chemclipse.model.ranges;

import junit.framework.TestCase;

public class TimeRange_11_Test extends TestCase {

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void test1() {

		try {
			/*
			 * Original
			 */
			TimeRange timeRange = new TimeRange("Styrene", 500, 1500);
			assertEquals(500, timeRange.getStart());
			assertEquals(1000, timeRange.getCenter());
			assertEquals(1500, timeRange.getStop());
			timeRange.setTraces("103 104");
			assertEquals("103 104", timeRange.getTraces());
			/*
			 * Copy
			 */
			TimeRange timeRangeCopy = new TimeRange(timeRange);
			assertEquals(500, timeRangeCopy.getStart());
			assertEquals(1000, timeRangeCopy.getCenter());
			assertEquals(1500, timeRangeCopy.getStop());
			assertEquals("103 104", timeRangeCopy.getTraces());
		} catch(IllegalArgumentException e) {
			assertTrue(false);
		}
	}
}