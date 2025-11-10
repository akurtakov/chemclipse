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
public class AnalysisSupport_1_Test {

	private IAnalysisSupport support;

	@BeforeAll
	public void setUp() {

		support = new AnalysisSupport(5726, 13);
	}

	@Test
	public void testGetNumberOfAnalysisSegments_1() {

		assertEquals(441, support.getNumberOfAnalysisSegments());
	}

	@Test
	public void testSegment_1() {

		List<IAnalysisSegment> segments = support.getAnalysisSegments();
		IAnalysisSegment segment = segments.get(439);
		assertEquals(5708, segment.getStartScan());
		assertEquals(5720, segment.getStopScan());
		assertEquals(13, segment.getWidth());
	}

	@Test
	public void testSegment_2() {

		List<IAnalysisSegment> segments = support.getAnalysisSegments();
		IAnalysisSegment segment = segments.get(440);
		assertEquals(5721, segment.getStartScan());
		assertEquals(5726, segment.getStopScan());
		assertEquals(6, segment.getWidth());
	}
}
