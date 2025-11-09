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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class AnalysisSegment_3_Test {

	private IAnalysisSegment segment;
	private final int startScan = -5;
	private final int segmentWidth = -5;

	@BeforeAll
	public void setUp() {

		segment = new AnalysisSegment(startScan, segmentWidth) {

			@Override
			public int getStartRetentionTime() {

				return 0;
			}

			@Override
			public int getStopRetentionTime() {

				return 0;
			}
		};
	}

	@Test
	public void testGetStartScan_1() {

		assertEquals(0, segment.getStartScan());
	}

	@Test
	public void testGetStopScan_1() {

		assertEquals(0, segment.getStopScan());
	}

	@Test
	public void testGetSegmentWidth_1() {

		assertEquals(0, segment.getWidth());
	}
}
