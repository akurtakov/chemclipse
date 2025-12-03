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
package org.eclipse.chemclipse.msd.model.core.selection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.easymock.EasyMock;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramSelection_3_Test {

	private IChromatogramMSD chromatogram;
	private IChromatogramSelectionMSD selection;

	@BeforeAll
	public void setUp() {

		/*
		 * Use createNiceMock if you use void methods that are not important to
		 * test.
		 */
		chromatogram = EasyMock.createNiceMock(IChromatogramMSD.class);
		EasyMock.expect(chromatogram.getStartRetentionTime()).andStubReturn(4500);
		EasyMock.expect(chromatogram.getStopRetentionTime()).andStubReturn(25000);
		EasyMock.expect(chromatogram.getMaxSignal()).andStubReturn(560000.0f);
		EasyMock.replay(chromatogram);
		/*
		 * Default values from IChromatogram will be chosen.
		 */
		selection = new ChromatogramSelectionMSD(chromatogram);
	}

	@Test
	public void testChromatogram_1() {

		assertEquals(4500, chromatogram.getStartRetentionTime());
		assertEquals(25000, chromatogram.getStopRetentionTime());
		assertEquals(560000.0f, chromatogram.getMaxSignal(), 0);
	}

	@Test
	public void testGetChromatogram_1() {

		assertNotNull(selection.getChromatogram());
	}

	@Test
	public void testGetStartRetentionTime_1() {

		selection.setStartRetentionTime(6500);
		selection.reset();
		assertEquals(4500, selection.getStartRetentionTime());
	}

	@Test
	public void testGetStopRetentionTime_1() {

		selection.setStopRetentionTime(24000);
		selection.reset();
		assertEquals(25000, selection.getStopRetentionTime());
	}

	@Test
	public void testGetStartAbundance_1() {

		selection.setStartAbundance(0.5f);
		selection.reset();
		assertEquals(0.0f, selection.getStartAbundance(), 0);
	}

	@Test
	public void testGetStopAbundance_1() {

		selection.setStopAbundance(250000.0f);
		selection.reset();
		assertEquals(560000.0f, selection.getStopAbundance(), 0);
	}
}
