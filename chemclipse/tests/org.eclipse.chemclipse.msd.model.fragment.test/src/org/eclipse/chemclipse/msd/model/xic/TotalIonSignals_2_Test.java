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

import org.eclipse.chemclipse.model.signals.ITotalScanSignal;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.model.signals.TotalScanSignals;

import junit.framework.TestCase;

public class TotalIonSignals_2_Test extends TestCase {

	private ITotalScanSignals signals;
	private ITotalScanSignal signal;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		signals = null;
		signal = null;
		super.tearDown();
	}

	public void testConstructor_1() {

		signals = new TotalScanSignals(0);
		assertEquals("StartScan", 0, signals.getStartScan());
		assertEquals("StopScan", 0, signals.getStopScan());
		int scan;
		scan = signals.getStartScan();
		signal = signals.getTotalScanSignal(scan);
		assertNull("Null", signal);
		scan = signals.getStopScan();
		signal = signals.getTotalScanSignal(scan);
		assertNull("Null", signal);
	}

	public void testConstructor_2() {

		signals = new TotalScanSignals(-1, -1);
		assertEquals("StartScan", 0, signals.getStartScan());
		assertEquals("StopScan", 0, signals.getStopScan());
		int scan;
		scan = signals.getStartScan();
		signal = signals.getTotalScanSignal(scan);
		assertNull("Null", signal);
		scan = signals.getStopScan();
		signal = signals.getTotalScanSignal(scan);
		assertNull("Null", signal);
	}
}
