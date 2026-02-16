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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.model.baseline.BaselineModel;
import org.eclipse.chemclipse.model.baseline.IBaselineModel;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;
import org.eclipse.chemclipse.msd.model.implementation.ScanMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class BaselineSupport_3_Test {

	private IBaselineSupport baselineSupport;
	private IBaselineModel baselineModel;

	@BeforeAll
	public void setUp() {

		baselineSupport = new BaselineSupport();
		IChromatogramMSD chromatogram = new ChromatogramMSD();
		chromatogram.setScanDelay(500);
		chromatogram.setScanInterval(1000);
		for(int scan = 1; scan <= 100; scan++) {
			IScanMSD ms = new ScanMSD();
			chromatogram.addScan(ms);
		}
		chromatogram.recalculateRetentionTimes();
		baselineModel = new BaselineModel(chromatogram);
		baselineModel.addBaseline(500, 99500, 4000.0f, 4000.0f, true);
		baselineSupport.setBaselineModel(baselineModel);
	}

	@Test
	public void testSetBaselineModel_1() {

		assertEquals(0.0f, baselineModel.getBackground(400), 0);
		assertEquals(0.0f, baselineSupport.getBackgroundAbundance(400), 0);
	}

	@Test
	public void testSetBaselineModel_2() {

		assertEquals(4000.0f, baselineModel.getBackground(500), 0);
		assertEquals(4000.0f, baselineSupport.getBackgroundAbundance(500), 0);
	}

	@Test
	public void testSetBaselineModel_3() {

		assertEquals(4000.0f, baselineModel.getBackground(18500), 0);
		assertEquals(4000.0f, baselineSupport.getBackgroundAbundance(18500), 0);
	}

	@Test
	public void testSetBaselineModel_4() {

		assertEquals(4000.0f, baselineModel.getBackground(99500), 0);
		assertEquals(4000.0f, baselineSupport.getBackgroundAbundance(99500), 0);
	}

	@Test
	public void testSetBaselineModel_5() {

		assertEquals(0.0f, baselineModel.getBackground(100000), 0);
		assertEquals(0.0f, baselineSupport.getBackgroundAbundance(100000), 0);
	}
}
