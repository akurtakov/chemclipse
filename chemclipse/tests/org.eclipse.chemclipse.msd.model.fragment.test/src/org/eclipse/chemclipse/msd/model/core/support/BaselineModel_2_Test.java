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
package org.eclipse.chemclipse.msd.model.core.support;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.easymock.EasyMock;
import org.eclipse.chemclipse.model.baseline.BaselineModel;
import org.eclipse.chemclipse.model.baseline.IBaselineModel;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaselineModel_2_Test {

	private IChromatogramMSD chromatogram;
	private IBaselineModel baselineModel;

	@BeforeEach
	public void setUp() {

		chromatogram = EasyMock.createMock(IChromatogramMSD.class);
		EasyMock.expect(chromatogram.getStartRetentionTime()).andStubReturn(1000);
		EasyMock.expect(chromatogram.getStopRetentionTime()).andStubReturn(100000);
		EasyMock.replay(chromatogram);
		baselineModel = new BaselineModel(chromatogram);
		baselineModel.addBaseline(5000, 50000, 100, 10000, true);
	}

	@Test
	public void testChromatogram_1() {

		assertEquals(1000, chromatogram.getStartRetentionTime(), 0);
		assertEquals(100000, chromatogram.getStopRetentionTime(), 0);
	}

	@Test
	public void testBaseline_1() {

		assertEquals(100.0f, baselineModel.getBackground(5000), 0);
		assertEquals(10000.0f, baselineModel.getBackground(50000), 0);
		assertEquals(5600.0f, baselineModel.getBackground(30000), 0);
	}

	@Test
	public void testBaseline_2() {

		baselineModel.removeBaseline();
		assertEquals(0.0f, baselineModel.getBackground(30000), 0);
	}

	@Test
	public void testBaseline_3() {

		/*
		 * Cut an existing segment into two peaces.
		 */
		baselineModel.removeBaseline(25000, 35000);
		assertEquals(4499.78f, baselineModel.getBackground(24999), 0);
		assertEquals(0.0f, baselineModel.getBackground(25000), 0);
		assertEquals(0.0f, baselineModel.getBackground(30000), 0);
		assertEquals(0.0f, baselineModel.getBackground(35000), 0);
		assertEquals(6700.22f, baselineModel.getBackground(35001), 0);
	}

	@Test
	public void testBaseline_4() {

		/*
		 * Cut the ending part of an existing segment.
		 */
		baselineModel.removeBaseline(40000, 60000);
		assertEquals(7799.78f, baselineModel.getBackground(39999), 0);
		assertEquals(0.0f, baselineModel.getBackground(40000), 0);
		assertEquals(0.0f, baselineModel.getBackground(60000), 0);
		assertEquals(0.0f, baselineModel.getBackground(100000), 0);
	}

	@Test
	public void testBaseline_5() {

		/*
		 * Cut the beginning part of an existing segment.
		 */
		baselineModel.removeBaseline(1000, 10000);
		assertEquals(0.0f, baselineModel.getBackground(1000), 0);
		assertEquals(0.0f, baselineModel.getBackground(5000), 0);
		assertEquals(0.0f, baselineModel.getBackground(10000), 0);
		assertEquals(1200.22f, baselineModel.getBackground(10001), 0);
	}

	@Test
	public void testBaseline_6() {

		/*
		 * The baseline will be removed after calling
		 * baselineModel.removeBaseline(1000, 10000). But now check that the
		 * segment is right in place.
		 */
		baselineModel.addBaseline(2000, 4000, 500, 500, true);
		assertEquals(500.0f, baselineModel.getBackground(2000), 0);
		assertEquals(500.0f, baselineModel.getBackground(2500), 0);
		assertEquals(500.0f, baselineModel.getBackground(4000), 0);
		/*
		 * The baseline will be removed after calling
		 * baselineModel.removeBaseline(1000, 10000). But now check that the
		 * segment is right in place.
		 */
		baselineModel.addBaseline(4500, 8000, 800, 800, true);
		assertEquals(800.0f, baselineModel.getBackground(4500), 0);
		assertEquals(800.0f, baselineModel.getBackground(6500), 0);
		assertEquals(800.0f, baselineModel.getBackground(8000), 0);
		/*
		 * If the segment is totally hidden by the segment to be inserted,
		 * remove it.
		 */
		baselineModel.removeBaseline(1000, 10000);
		assertEquals(0.0f, baselineModel.getBackground(1000), 0);
		assertEquals(0.0f, baselineModel.getBackground(2000), 0);
		assertEquals(0.0f, baselineModel.getBackground(2500), 0);
		assertEquals(0.0f, baselineModel.getBackground(4000), 0);
		assertEquals(0.0f, baselineModel.getBackground(4500), 0);
		assertEquals(0.0f, baselineModel.getBackground(6500), 0);
		assertEquals(0.0f, baselineModel.getBackground(8000), 0);
		assertEquals(0.0f, baselineModel.getBackground(10000), 0);
		assertEquals(1200.22f, baselineModel.getBackground(10001), 0);
	}
}
