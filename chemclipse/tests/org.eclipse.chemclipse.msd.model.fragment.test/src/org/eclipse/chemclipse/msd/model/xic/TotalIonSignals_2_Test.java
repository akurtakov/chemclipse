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
import org.eclipse.chemclipse.model.signals.TotalScanSignals;
import org.junit.jupiter.api.Test;

public class TotalIonSignals_2_Test {

	@Test
	public void testConstructor_1() {

		ITotalScanSignals signals = new TotalScanSignals(0);
		assertEquals(0, signals.getStartScan());
		assertEquals(0, signals.getStopScan());
		int scan;
		scan = signals.getStartScan();
		ITotalScanSignal signal = signals.getTotalScanSignal(scan);
		assertNull(signal);
		scan = signals.getStopScan();
		signal = signals.getTotalScanSignal(scan);
		assertNull(signal);
	}

	@Test
	public void testConstructor_2() {

		ITotalScanSignals signals = new TotalScanSignals(-1, -1);
		assertEquals(0, signals.getStartScan());
		assertEquals(0, signals.getStopScan());
		int scan;
		scan = signals.getStartScan();
		ITotalScanSignal signal = signals.getTotalScanSignal(scan);
		assertNull(signal);
		scan = signals.getStopScan();
		signal = signals.getTotalScanSignal(scan);
		assertNull(signal);
	}
}
