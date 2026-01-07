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
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.eclipse.chemclipse.model.exceptions.PeakException;
import org.eclipse.chemclipse.model.signals.ITotalScanSignal;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.model.signals.TotalScanSignal;
import org.eclipse.chemclipse.model.signals.TotalScanSignals;
import org.eclipse.chemclipse.model.support.BackgroundAbundanceRange;
import org.eclipse.chemclipse.model.support.IBackgroundAbundanceRange;
import org.eclipse.chemclipse.model.support.IScanRange;
import org.eclipse.chemclipse.model.support.ScanRange;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Test the peak exceptions.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class PeakBuilder_22_Test {

	private ITotalScanSignals totalIonSignals;
	private IScanRange scanRange;
	private IBackgroundAbundanceRange backgroundAbundanceRange;
	private IBackgroundAbundanceRange correctedBackground;

	@BeforeAll
	public void setUp() {

		totalIonSignals = new TotalScanSignals(20, 30);
		scanRange = new ScanRange(20, 30);
		for(int scan = 20; scan <= 30; scan++) {
			ITotalScanSignal totalIonSignal = new TotalScanSignal(scan * 10, 0.0f, 1000.0f);
			totalIonSignals.add(totalIonSignal);
		}
	}

	@Test
	public void testCheckBackgroundAbundanceRange_1() {

		backgroundAbundanceRange = new BackgroundAbundanceRange(1500.0f, 1500.0f);
		correctedBackground = PeakBuilderMSD.checkBackgroundAbundanceRange(totalIonSignals, scanRange, backgroundAbundanceRange);
		assertEquals(1000.0f, correctedBackground.getStartBackgroundAbundance(), 0);
		assertEquals(1000.0f, correctedBackground.getStopBackgroundAbundance(), 0);
	}

	@Test
	public void testCheckBackgroundAbundanceRange_2() {

		backgroundAbundanceRange = new BackgroundAbundanceRange(800.0f, 1500.0f);
		correctedBackground = PeakBuilderMSD.checkBackgroundAbundanceRange(totalIonSignals, scanRange, backgroundAbundanceRange);
		assertEquals(800.0f, correctedBackground.getStartBackgroundAbundance(), 0);
		assertEquals(1000.0f, correctedBackground.getStopBackgroundAbundance(), 0);
	}

	@Test
	public void testCheckBackgroundAbundanceRange_3() {

		backgroundAbundanceRange = new BackgroundAbundanceRange(1500.0f, 750.0f);
		correctedBackground = PeakBuilderMSD.checkBackgroundAbundanceRange(totalIonSignals, scanRange, backgroundAbundanceRange);
		assertEquals(1000.0f, correctedBackground.getStartBackgroundAbundance(), 0);
		assertEquals(750.0f, correctedBackground.getStopBackgroundAbundance(), 0);
	}

	@Test
	public void testCheckBackgroundAbundanceRange_4() {

		backgroundAbundanceRange = new BackgroundAbundanceRange(1500.0f, 750.0f);
		assertThrows(PeakException.class, () -> {
			correctedBackground = PeakBuilderMSD.checkBackgroundAbundanceRange(null, scanRange, backgroundAbundanceRange);
		});
	}

	@Test
	public void testCheckBackgroundAbundanceRange_5() {

		backgroundAbundanceRange = new BackgroundAbundanceRange(1500.0f, 750.0f);
		assertThrows(PeakException.class, () -> {
			correctedBackground = PeakBuilderMSD.checkBackgroundAbundanceRange(totalIonSignals, null, backgroundAbundanceRange);
		});
	}

	@Test
	public void testCheckBackgroundAbundanceRange_6() {

		assertThrows(PeakException.class, () -> {
			correctedBackground = PeakBuilderMSD.checkBackgroundAbundanceRange(totalIonSignals, scanRange, null);
		});
	}
}
