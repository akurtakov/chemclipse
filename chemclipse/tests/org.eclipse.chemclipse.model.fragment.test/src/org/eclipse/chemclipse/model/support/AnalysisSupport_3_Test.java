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
public class AnalysisSupport_3_Test {

	private IAnalysisSupport support;

	@BeforeAll
	public void setUp() {

		support = new AnalysisSupport(100, 10);
	}

	@Test
	public void testGetNumberOfAnalysisSegments_1() {

		assertEquals(10, support.getNumberOfAnalysisSegments());
	}

	@Test
	public void testSegment_1() {

		List<IAnalysisSegment> segments = support.getAnalysisSegments();
		IAnalysisSegment segment = segments.get(0);
		assertEquals(1, segment.getStartScan());
		assertEquals(10, segment.getStopScan());
		assertEquals(10, segment.getWidth());
	}

	@Test
	public void testSegment_2() {

		List<IAnalysisSegment> segments = support.getAnalysisSegments();
		IAnalysisSegment segment = segments.get(9);
		assertEquals(91, segment.getStartScan());
		assertEquals(100, segment.getStopScan());
		assertEquals(10, segment.getWidth());
	}
}
