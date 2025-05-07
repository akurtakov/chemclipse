/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.calculator;

import junit.framework.TestCase;

public class DensityCalculator_5_Test extends TestCase {

	private static final int SCAN_INTERVAL = 978;
	private DensityCalculator densityCalculator = new DensityCalculator();

	public void test01() {

		assertEquals(0, densityCalculator.adjustScanInterval(SCAN_INTERVAL, 0));
	}

	public void test02() {

		assertEquals(1000, densityCalculator.adjustScanInterval(SCAN_INTERVAL, 250));
	}

	public void test03() {

		assertEquals(1000, densityCalculator.adjustScanInterval(SCAN_INTERVAL, 500));
	}

	public void test04() {

		assertEquals(1000, densityCalculator.adjustScanInterval(SCAN_INTERVAL, 1000));
	}

	public void test05() {

		assertEquals(1500, densityCalculator.adjustScanInterval(SCAN_INTERVAL, 1500));
	}
}