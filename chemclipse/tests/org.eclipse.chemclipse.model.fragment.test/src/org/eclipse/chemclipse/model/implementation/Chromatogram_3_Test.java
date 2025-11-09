/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.implementation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.chemclipse.model.core.IScan;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Chromatogram_3_Test {

	private Chromatogram chromatogram;

	@BeforeAll
	public void setUp() {

		chromatogram = new Chromatogram();
		chromatogram.addScan(new Scan(1000.0f));
		chromatogram.addScan(new Scan(1000.0f));
		chromatogram.addScan(new Scan(1000.0f));
	}

	@Test
	public void testChromatogram_1() {

		assertFalse(chromatogram.containsScanCycles());
	}

	@Test
	public void testChromatogram_2() {

		IScan scan = new Scan(1000.0f);
		scan.setCycleNumber(1);
		chromatogram.addScan(scan);
		assertFalse(chromatogram.containsScanCycles());
	}

	@Test
	public void testChromatogram_3() {

		IScan scan = new Scan(1000.0f);
		scan.setCycleNumber(0);
		chromatogram.addScan(scan);
		assertTrue(chromatogram.containsScanCycles());
	}

	@Test
	public void testChromatogram_4() {

		IScan scan = new Scan(1000.0f);
		scan.setCycleNumber(2);
		chromatogram.addScan(scan);
		assertTrue(chromatogram.containsScanCycles());
	}
}
