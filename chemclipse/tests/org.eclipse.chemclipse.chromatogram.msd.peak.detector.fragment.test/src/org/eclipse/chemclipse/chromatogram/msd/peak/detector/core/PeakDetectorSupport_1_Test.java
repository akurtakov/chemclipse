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
package org.eclipse.chemclipse.chromatogram.msd.peak.detector.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.peak.detector.core.IPeakDetectorSupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PeakDetectorSupport_1_Test {

	private PeakDetectorMSDSupport support = new PeakDetectorMSDSupport();

	@BeforeAll
	public void setUp() throws Exception {

		PeakDetectorMSDSupplier supplier = new PeakDetectorMSDSupplier("net.first.supplier", "Integrator Description", "Peak Detector Name");
		support.add(supplier);
	}

	@Test
	public void testGetAvailableIntegratorIds_1() {

		assertDoesNotThrow(() -> {
			List<String> ids = support.getAvailablePeakDetectorIds();
			assertEquals("net.first.supplier", ids.get(0));
		});
	}

	@Test
	public void testGetIntegratorId_1() {

		assertDoesNotThrow(() -> {
			String name = support.getPeakDetectorId(0);
			assertEquals("net.first.supplier", name);
		});
	}

	@Test
	public void testGetIntegratorSupplier_1() {

		assertDoesNotThrow(() -> {
			IPeakDetectorSupplier supplier = support.getPeakDetectorSupplier("net.first.supplier");
			assertNotNull(supplier);
			assertEquals("Peak Detector Name", supplier.getPeakDetectorName());
		});
	}

	@Test
	public void testGetIntegratorNames_1() {

		assertDoesNotThrow(() -> {
			String[] names = support.getPeakDetectorNames();
			assertEquals(1, names.length);
			assertEquals("Peak Detector Name", names[0]);
		});
	}
}
