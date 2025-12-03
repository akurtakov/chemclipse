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
package org.eclipse.chemclipse.msd.model.core.support;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.core.IPeakIntensityValues;
import org.eclipse.chemclipse.model.exceptions.PeakException;
import org.eclipse.chemclipse.model.signals.ITotalScanSignal;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.model.signals.TotalScanSignal;
import org.eclipse.chemclipse.model.signals.TotalScanSignals;
import org.eclipse.chemclipse.numeric.core.IPoint;
import org.eclipse.chemclipse.numeric.core.Point;
import org.eclipse.chemclipse.numeric.equations.Equations;
import org.eclipse.chemclipse.numeric.equations.LinearEquation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Test the peak exceptions.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class PeakBuilder_26_Test {

	private ITotalScanSignals totalIonSignals;
	private ITotalScanSignals totalIonSignalsModified;
	private ITotalScanSignal totalIonSignal;
	private LinearEquation backgroundEquation;

	@BeforeAll
	public void setUp() {

		List<Float> intensities = new ArrayList<Float>();
		intensities.add(1000.0f);
		intensities.add(5578.14f);
		intensities.add(7596.27f);
		intensities.add(9386.37f);
		intensities.add(5000.0f);
		intensities.add(2709.21f);
		intensities.add(1440.9f);
		intensities.add(810.72f);
		intensities.add(538.22f);
		intensities.add(400.00f);
		totalIonSignals = new TotalScanSignals(1, 10);
		float abundance = 0.0f;
		for(int scan = 1; scan <= 10; scan++) {
			abundance = intensities.get(scan - 1);
			totalIonSignal = new TotalScanSignal(scan * 10, 0.0f, abundance);
			totalIonSignals.add(totalIonSignal);
		}
		IPoint p1 = new Point(10, 1000);
		IPoint p2 = new Point(100, 400);
		backgroundEquation = Equations.createLinearEquation(p1, p2);
	}

	@Test
	public void testAdjustTotalIonSignals_1() {

		assertDoesNotThrow(() -> {
			totalIonSignalsModified = PeakBuilderMSD.adjustTotalIonSignals(totalIonSignals, backgroundEquation);
			assertNotSame(totalIonSignalsModified, totalIonSignals);
			totalIonSignal = totalIonSignalsModified.getTotalScanSignal(1);
			assertEquals(0.0f, totalIonSignal.getTotalSignal(), 0);
			totalIonSignal = totalIonSignalsModified.getTotalScanSignal(4);
			assertEquals(IPeakIntensityValues.MAX_INTENSITY, totalIonSignal.getTotalSignal(), 0);
			totalIonSignal = totalIonSignalsModified.getTotalScanSignal(10);
			assertEquals(0.0f, totalIonSignal.getTotalSignal(), 0);
		});
	}

	@Test
	public void testAdjustTotalIonSignals_2() {

		assertThrows(PeakException.class, () -> {
			totalIonSignalsModified = PeakBuilderMSD.adjustTotalIonSignals(null, backgroundEquation);
		});
	}

	@Test
	public void testAdjustTotalIonSignals_3() {

		assertThrows(PeakException.class, () -> {
			totalIonSignalsModified = PeakBuilderMSD.adjustTotalIonSignals(totalIonSignals, null);
		});
	}
}
