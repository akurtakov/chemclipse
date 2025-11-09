/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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

/**
 * Tests the class IonRange.
 */
public class ScanRange_1_Test {

	@Test
	public void testSetup_1() {

		IScanRange scanRange = new ScanRange(1, 5);
		assertEquals(1, scanRange.getStartScan());
		assertEquals(5, scanRange.getStopScan());
	}

	@Test
	public void testSetup_2() {

		IScanRange scanRange = new ScanRange(5, 1);
		assertEquals(1, scanRange.getStartScan());
		assertEquals(5, scanRange.getStopScan());
		assertEquals(5, scanRange.getWidth());
	}

	@Test
	public void testSetup_3() {

		IScanRange scanRange = new ScanRange(0, 5);
		assertEquals(IScanRange.MIN_SCAN, scanRange.getStartScan());
		assertEquals(5, scanRange.getStopScan());
		assertEquals(5, scanRange.getWidth());
	}

	@Test
	public void testSetup_4() {

		IScanRange scanRange = new ScanRange(1, 0);
		assertEquals(1, scanRange.getStartScan());
		assertEquals(IScanRange.MIN_SCAN, scanRange.getStopScan());
		assertEquals(1, scanRange.getWidth());
	}

	@Test
	public void testSetup_5() {

		// Because IScanRange.MAX_SCAN+1 is negative.
		IScanRange scanRange = new ScanRange(IScanRange.MAX_SCAN + 1, 5);
		assertEquals(1, scanRange.getStartScan());
		assertEquals(5, scanRange.getStopScan());
		assertEquals(5, scanRange.getWidth());
	}

	@Test
	public void testSetup_6() {

		// Because IScanRange.MAX_SCAN+1 is negative.
		IScanRange scanRange = new ScanRange(1, IScanRange.MAX_SCAN + 1);
		assertEquals(1, scanRange.getStartScan());
		assertEquals(1, scanRange.getStopScan());
		assertEquals(1, scanRange.getWidth());
	}

	@Test
	public void testSetup_7() {

		// Because IScanRange.MAX_SCAN+1 is negative.
		IScanRange scanRange = new ScanRange(-1, IScanRange.MAX_SCAN + 1);
		assertEquals(1, scanRange.getStartScan());
		assertEquals(IScanRange.MAX_SCAN, scanRange.getStopScan());
		assertEquals(IScanRange.MAX_SCAN, scanRange.getWidth());
	}
}
