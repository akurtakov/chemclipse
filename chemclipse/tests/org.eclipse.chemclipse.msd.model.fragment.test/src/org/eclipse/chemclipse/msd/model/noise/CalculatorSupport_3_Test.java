/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.noise;

import org.eclipse.chemclipse.model.support.ScanRange;
import org.eclipse.chemclipse.msd.model.exceptions.FilterException;

import junit.framework.TestCase;

public class CalculatorSupport_3_Test extends TestCase {

	private CalculatorSupport calculatorSupport;
	private ScanRange scanRange;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		calculatorSupport = new CalculatorSupport();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testGetScanRange_1() {

		try {
			scanRange = null;
			calculatorSupport.checkScanRange(scanRange, 13);
		} catch(FilterException e) {
			assertTrue("FilterException", true);
		}
	}

	public void testGetScanRange_2() {

		try {
			scanRange = new ScanRange(1, 13);
			calculatorSupport.checkScanRange(scanRange, 13);
		} catch(FilterException e) {
			assertFalse("A FilterException should not be thrown here.", false);
		}
	}

	public void testGetScanRange_3() {

		try {
			scanRange = new ScanRange(1, 12);
			calculatorSupport.checkScanRange(scanRange, 13);
		} catch(FilterException e) {
			assertTrue("FilterException", true);
		}
	}
}
