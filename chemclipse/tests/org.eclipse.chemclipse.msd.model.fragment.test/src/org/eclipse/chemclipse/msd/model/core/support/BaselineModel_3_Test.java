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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class BaselineModel_3_Test {

	private IChromatogramMSD chromatogram;
	private IBaselineModel baselineModel;

	@BeforeAll
	public void setUp() {

		chromatogram = EasyMock.createMock(IChromatogramMSD.class);
		EasyMock.expect(chromatogram.getStartRetentionTime()).andStubReturn(1000);
		EasyMock.expect(chromatogram.getStopRetentionTime()).andStubReturn(100000);
		EasyMock.replay(chromatogram);
		baselineModel = new BaselineModel(chromatogram);
		baselineModel.addBaseline(500, 50000, 100, 100, true);
		baselineModel.addBaseline(90000, 150000, 200, 200, true);
	}

	@Test
	public void testChromatogram_1() {

		assertEquals(1000, chromatogram.getStartRetentionTime());
		assertEquals(100000, chromatogram.getStopRetentionTime());
	}

	@Test
	public void testBaseline_1() {

		assertEquals(200.0f, baselineModel.getBackground(90000), 0);
		assertEquals(200.0f, baselineModel.getBackground(100000), 0);
		assertEquals(200.0f, baselineModel.getBackground(95000), 0);
		assertEquals(0.0f, baselineModel.getBackground(150000), 0);
	}

	@Test
	public void testBaseline_2() {

		assertEquals(0.0f, baselineModel.getBackground(500), 0);
		assertEquals(100.0f, baselineModel.getBackground(1000), 0);
		assertEquals(100.0f, baselineModel.getBackground(50000), 0);
		assertEquals(100.0f, baselineModel.getBackground(5000), 0);
	}
}
