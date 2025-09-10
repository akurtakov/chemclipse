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
package org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.exceptions.NoBaselineDetectorAvailableException;
import org.junit.jupiter.api.Test;

/**
 * Test the IBaselineDetectorSupport.
 * 
 * @author Philip Wenig
 */
public class BaselineDetector_1_Test {

	IBaselineDetectorSupport support = BaselineDetector.getBaselineDetectorSupport();

	@Test
	public void testGetMassSpectrumComparatorSupport_1() throws NoBaselineDetectorAvailableException {

		int count = 0;
		String[] names = support.getDetectorNames();
		String[] rcs = new String[1];
		rcs[0] = "Threshold (TIC) Baseline Detector"; // Was removed
		for(String name : names) {
			for(String rc : rcs) {
				if(name.equals(rc)) {
					count++;
				}
			}
		}
		assertEquals(0, count, "Registered Detector Names");
	}

	@Test
	public void testGetMassSpectrumComparatorSupport_2() throws NoBaselineDetectorAvailableException {

		int count = 0;
		List<String> ids = support.getAvailableDetectorIds();
		String[] rcs = new String[1];
		rcs[0] = "org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.supplier.tic"; // Was removed
		for(String id : ids) {
			for(String rc : rcs) {
				if(id.equals(rc)) {
					count++;
				}
			}
		}
		assertEquals(0, count, "Registered Detector Ids");
	}

	@Test
	public void testGetMassSpectrumComparatorSupport_3() throws NoBaselineDetectorAvailableException {

		List<String> ids = support.getAvailableDetectorIds();
		List<String> rcs = new ArrayList<>();
		for(String id : ids) {
			rcs.add(id);
		}
		String id;
		for(int i = 0; i < rcs.size(); i++) {
			id = support.getDetectorId(i);
			assertEquals(id, rcs.get(i), "getDetectorId");
		}
	}

	@Test
	public void testGetMassSpectrumComparisonSupplier_1() {

		assertThrows(NoBaselineDetectorAvailableException.class, () -> {
			support.getBaselineDetectorSupplier("");
		});
	}

	@Test
	public void testGetMassSpectrumComparisonSupplier_2() {

		assertThrows(NoBaselineDetectorAvailableException.class, () -> {
			support.getBaselineDetectorSupplier(null);
		});
	}

	@Test
	public void testGetMassSpectrumComparisonSupplier_3() {

		assertThrows(NoBaselineDetectorAvailableException.class, () -> { // The detector was removed
			String id = "org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.supplier.tic";
			IBaselineDetectorSupplier supplier = support.getBaselineDetectorSupplier(id);
			assertNull(supplier);
		});
	}
}
