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
package org.eclipse.chemclipse.msd.model.xic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.eclipse.chemclipse.model.signals.ITotalScanSignal;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.model.signals.TotalScanSignal;
import org.eclipse.chemclipse.model.signals.TotalScanSignals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class TotalIonSignals_1_Test {

	private ITotalScanSignals signals;
	private ITotalScanSignal signal;

	@BeforeAll
	public void setUp() {

		signals = new TotalScanSignals(10);
		for(int i = 1; i <= 10; i++) {
			signal = new TotalScanSignal(i * 100, 0.0f, i * 100);
			signals.add(signal);
		}
	}

	@Test
	public void testSize_1() {

		assertEquals(10, signals.size());
	}

	@Test
	public void testGetTotalIonSignal_1() {

		signal = signals.getTotalScanSignal(1);
		assertEquals(1 * 100, signal.getRetentionTime());
		assertEquals(0.0f, signal.getRetentionIndex(), 0);
		assertEquals(1 * 100.0f, signal.getTotalSignal(), 0);
	}

	@Test
	public void testGetTotalIonSignal_2() {

		signal = signals.getTotalScanSignal(5);
		assertEquals(5 * 100, signal.getRetentionTime());
		assertEquals(0.0f, signal.getRetentionIndex(), 0);
		assertEquals(5 * 100.0f, signal.getTotalSignal(), 0);
	}

	@Test
	public void testGetTotalIonSignal_3() {

		signal = signals.getTotalScanSignal(10);
		assertEquals(10 * 100, signal.getRetentionTime());
		assertEquals(0.0f, signal.getRetentionIndex(), 0);
		assertEquals(10 * 100.0f, signal.getTotalSignal(), 0);
	}

	@Test
	public void testGetTotalIonSignal_4() {

		signal = signals.getTotalScanSignal(0);
		assertNull(signal);
	}

	@Test
	public void testGetTotalIonSignal_5() {

		signal = signals.getTotalScanSignal(11);
		assertNull(signal);
	}

	@Test
	public void testGetTotalIonSignal_6() {

		signal = signals.getTotalScanSignal(-1);
		assertNull(signal);
	}
}
