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

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class AnalysisSupport_6_Test {

	private IAnalysisSupport support;
	private IScanRange scanRange;

	@BeforeAll
	public void setUp() {

		scanRange = new ScanRange(178, 250);
		support = new AnalysisSupport(scanRange, 10);
	}

	@Test
	public void testGetNumberOfAnalysisSegments_1() {

		assertEquals(8, support.getNumberOfAnalysisSegments());
	}

	@Test
	public void testSegment_1() {

		List<IAnalysisSegment> segments = support.getAnalysisSegments();
		IAnalysisSegment segment = segments.get(0);
		assertEquals(178, segment.getStartScan());
		assertEquals(187, segment.getStopScan());
		assertEquals(10, segment.getWidth());
	}

	@Test
	public void testSegment_2() {

		List<IAnalysisSegment> segments = support.getAnalysisSegments();
		IAnalysisSegment segment = segments.get(7);
		assertEquals(248, segment.getStartScan());
		assertEquals(250, segment.getStopScan());
		assertEquals(3, segment.getWidth());
	}
}
