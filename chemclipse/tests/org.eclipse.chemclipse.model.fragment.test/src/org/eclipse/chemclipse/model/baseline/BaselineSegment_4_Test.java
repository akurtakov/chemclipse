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
package org.eclipse.chemclipse.model.baseline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class BaselineSegment_4_Test {

	private IBaselineSegment segmentI;
	private IBaselineSegment segmentII;
	private int startRetentionTime;
	private int stopRetentionTime;
	private float startBackgroundAbundance;
	private float stopBackgroundAbundance;

	@BeforeAll
	public void setUp() {

		startRetentionTime = 4500;
		stopRetentionTime = 10500;
		startBackgroundAbundance = 500.0f;
		stopBackgroundAbundance = 4000.0f;
		segmentI = new BaselineSegment(startRetentionTime, stopRetentionTime);
		segmentI.setStartBackgroundAbundance(startBackgroundAbundance);
		segmentI.setStopBackgroundAbundance(stopBackgroundAbundance);
		segmentII = new BaselineSegment(startRetentionTime, stopRetentionTime);
		segmentII.setStartBackgroundAbundance(startBackgroundAbundance);
		segmentII.setStopBackgroundAbundance(stopBackgroundAbundance);
	}

	@Test
	public void testEquals_1() {

		assertEquals(segmentI, segmentII);
	}

	@Test
	public void testEquals_2() {

		assertEquals(segmentII, segmentI);
	}

	@Test
	public void testNotNull_1() {

		assertNotNull(segmentI);
	}

	@Test
	public void testAssertNotNull_2() {

		assertNotNull(segmentII);
	}

	@Test
	public void testEquals_5() {

		assertNotEquals(segmentI, new Object());
	}

	@Test
	public void testEquals_6() {

		assertNotEquals(segmentII, new Object());
	}

	@Test
	public void testHashCode_1() {

		assertEquals(segmentI.hashCode(), segmentII.hashCode());
	}

	@Test
	public void testHashCode_2() {

		assertEquals(segmentII.hashCode(), segmentI.hashCode());
	}
}
