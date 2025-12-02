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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.support;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class Segment_1_Test {

	private ISegment segment = new Segment();

	@Test
	public void testPoint_1() {

		assertNotNull(segment.getChromatogramBaselinePoint1());
	}

	@Test
	public void testPoint_2() {

		assertNotNull(segment.getChromatogramBaselinePoint2());
	}

	@Test
	public void testPoint_3() {

		assertNotNull(segment.getPeakBaselinePoint1());
	}

	@Test
	public void testPoint_4() {

		assertNotNull(segment.getPeakBaselinePoint2());
	}
}
