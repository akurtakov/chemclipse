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

import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.model.signals.TotalScanSignals;
import org.eclipse.chemclipse.model.signals.TotalScanSignalsModifier;

import junit.framework.TestCase;

public class TotalIonSignalsModifier_7_Test extends TestCase {

	private ITotalScanSignals signals;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testCalculateMovingAverage_1() {

		signals = null;
		TotalScanSignalsModifier.calculateMovingAverage(signals, 5);
		assertNull(signals);
	}

	public void testCalculateMovingAverage_2() {

		signals = new TotalScanSignals(5);
		TotalScanSignalsModifier.calculateMovingAverage(signals, 5);
		assertNotNull(signals);
	}
}
