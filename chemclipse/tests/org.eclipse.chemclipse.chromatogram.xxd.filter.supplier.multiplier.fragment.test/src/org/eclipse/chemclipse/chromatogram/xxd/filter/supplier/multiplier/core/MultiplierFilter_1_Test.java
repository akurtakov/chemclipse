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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.multiplier.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.chromatogram.filter.core.chromatogram.IChromatogramFilter;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.multiplier.settings.MultiplierSettings;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MultiplierFilter_1_Test extends ChromatogramImporterTestCase {

	private IChromatogramFilter chromatogramFilter;
	private MultiplierSettings multiplierFilterSettings;

	@Override
	@BeforeAll
	public void setUp() {

		super.setUp();
		chromatogramFilter = new MultiplierChromatogramFilter();
		multiplierFilterSettings = new MultiplierSettings();
		multiplierFilterSettings.setMultiplier(0.01f);
	}

	@Test
	public void testApplyFilter_1() {

		float totalSignal;

		totalSignal = chromatogram.getScan(1).getTotalSignal();
		assertEquals(67864.0f, totalSignal, 0);
		totalSignal = chromatogram.getScan(5726).getTotalSignal();
		assertEquals(152824.0f, totalSignal, 0);
		totalSignal = chromatogram.getScan(238).getTotalSignal();
		assertEquals(94184.0f, totalSignal, 0);
		totalSignal = chromatogram.getScan(628).getTotalSignal();
		assertEquals(2747568.0f, totalSignal, 0);

		chromatogramFilter.applyFilter(chromatogramSelection, multiplierFilterSettings, new NullProgressMonitor());

		totalSignal = chromatogram.getScan(1).getTotalSignal();
		assertEquals(678.640f, totalSignal, 10E-2);
		totalSignal = chromatogram.getScan(5726).getTotalSignal();
		assertEquals(1528.240f, totalSignal, 10E-2);
		totalSignal = chromatogram.getScan(238).getTotalSignal();
		assertEquals(941.840f, totalSignal, 10E-2);
		totalSignal = chromatogram.getScan(628).getTotalSignal();
		assertEquals(27475.680f, totalSignal, 10E-2);
	}
}
