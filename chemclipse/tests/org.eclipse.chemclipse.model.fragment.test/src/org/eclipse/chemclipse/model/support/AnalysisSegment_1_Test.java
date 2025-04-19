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

import junit.framework.TestCase;

public class AnalysisSegment_1_Test extends TestCase {

	private IAnalysisSegment segment;
	private final int startScan = 50;
	private final int segmentWidth = 120;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
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

	@Override
	protected void tearDown() throws Exception {

		segment = null;
		super.tearDown();
	}

	public void testGetStartScan_1() {

		assertEquals("StartScan", startScan, segment.getStartScan());
	}

	public void testGetStopScan_1() {

		assertEquals("StopScan", (segmentWidth + startScan - 1), segment.getStopScan());
	}

	public void testGetSegmentWidth_1() {

		assertEquals("SegmentWidth", segmentWidth, segment.getWidth());
	}
}
