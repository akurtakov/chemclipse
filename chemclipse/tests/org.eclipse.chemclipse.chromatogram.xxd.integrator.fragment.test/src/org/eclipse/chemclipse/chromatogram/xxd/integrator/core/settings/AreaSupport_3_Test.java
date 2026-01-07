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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.easymock.EasyMock;
import org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings.peaks.AreaSupport;
import org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings.peaks.IAreaSupport;
import org.eclipse.chemclipse.msd.model.core.IChromatogramPeakMSD;
import org.eclipse.chemclipse.msd.model.core.IPeakModelMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class AreaSupport_3_Test {

	private IAreaSupport areaSupport;

	@BeforeAll
	public void setUp() {

		areaSupport = new AreaSupport();
		areaSupport.setMinimumArea(4500.0d);
		areaSupport.setAreaSumOn(1500, 5500);
		areaSupport.setAreaSumOn(8500, 10500);
	}

	@Test
	public void testGetMinimumArea_1() {

		assertEquals(4500.0d, areaSupport.getMinimumArea(), 0);
	}

	@Test
	public void testIsAreaSumOn_1() {

		assertFalse(areaSupport.isAreaSumOn(1499));
		assertTrue(areaSupport.isAreaSumOn(1500));
		assertTrue(areaSupport.isAreaSumOn(5500));
		assertFalse(areaSupport.isAreaSumOn(5501));
		assertFalse(areaSupport.isAreaSumOn(8499));
		assertTrue(areaSupport.isAreaSumOn(8500));
		assertTrue(areaSupport.isAreaSumOn(10500));
		assertFalse(areaSupport.isAreaSumOn(10501));
	}

	@Test
	public void testReport_1() {

		/*
		 * Peak model and peak mocks.
		 */
		IPeakModelMSD peakModel = EasyMock.createMock(IPeakModelMSD.class);
		EasyMock.expect(peakModel.getStartRetentionTime()).andStubReturn(4500);
		EasyMock.replay(peakModel);
		IChromatogramPeakMSD peak = EasyMock.createMock(IChromatogramPeakMSD.class);
		EasyMock.expect(peak.getPeakModel()).andStubReturn(peakModel);
		EasyMock.expect(peak.getIntegratedArea()).andStubReturn(4500.0d);
		EasyMock.replay(peak);
		assertTrue(areaSupport.report(peak));
	}
}
