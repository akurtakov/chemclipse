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
package org.eclipse.chemclipse.model.baseline;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.support.traces.TraceEmpty;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class BaselineSegment_1_Test {

	private IBaselineSegment segment;
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
		segment = new BaselineSegment(startRetentionTime, stopRetentionTime, new TraceEmpty());
		segment.setStartBackgroundAbundance(startBackgroundAbundance);
		segment.setStopBackgroundAbundance(stopBackgroundAbundance);
	}

	@Test
	public void testGetStartRetentionTime_1() {

		assertEquals(startRetentionTime, segment.getStartRetentionTime());
	}

	@Test
	public void testGetStopRetentionTime_1() {

		assertEquals(stopRetentionTime, segment.getStopRetentionTime());
	}

	@Test
	public void testGetStartBackgroundAbundance_1() {

		assertEquals(startBackgroundAbundance, segment.getStartBackgroundAbundance(), 0);
	}

	@Test
	public void testGetStopBackgroundAbundance_1() {

		assertEquals(stopBackgroundAbundance, segment.getStopBackgroundAbundance(), 0);
	}
}
