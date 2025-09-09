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
package org.eclipse.chemclipse.chromatogram.msd.peak.detector.supplier.firstderivative.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.chemclipse.chromatogram.msd.peak.detector.core.IPeakDetectorMSD;
import org.eclipse.chemclipse.chromatogram.xxd.peak.detector.supplier.firstderivative.core.BasePeakDetector;
import org.eclipse.chemclipse.chromatogram.xxd.peak.detector.supplier.firstderivative.support.IFirstDerivativeDetectorSlopes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * peakDetectorSettings.getThreshold() is MEDIUM > threshold = 0.05d;
 * WindowSize.SCANS_5
 */
@TestInstance(Lifecycle.PER_CLASS)
public class FirstDerivativePeakDetector_2_Test extends FirstDerivativeSlopesTestCase {

	private IFirstDerivativeDetectorSlopes slopes;
	private IPeakDetectorMSD firstDerivativePeakDetector;
	private Class<?> firstDerivativePeakDetectorClass;
	private Method method;

	@Override
	@BeforeAll
	public void setUp() {

		super.setUp();
		firstDerivativePeakDetector = new PeakDetectorMSD();
		firstDerivativePeakDetectorClass = BasePeakDetector.class;
		slopes = getFirstDerivativeSlopes();
		slopes.calculateMovingAverage(5);
	}

	@Test
	public void testSize_1() {

		assertEquals(39, slopes.size(), "Size");
	}

	@Test
	public void testDetectPeakStart_1() throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		Integer result;
		method = firstDerivativePeakDetectorClass.getDeclaredMethod("detectPeakStart", new Class[]{IFirstDerivativeDetectorSlopes.class, Integer.TYPE, Integer.TYPE, Double.TYPE});
		method.setAccessible(true);
		result = (Integer)method.invoke(firstDerivativePeakDetector, new Object[]{slopes, 1, 0, 0.05d});
		/*
		 * The peak starts at scan 4 and has a scan offset of 0 (means starts at
		 * scan 1).
		 */
		assertEquals(Integer.valueOf(4), result, "detectPeakStart");
	}

	@Test
	public void testDetectPeakMaximum_1() throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		Integer result;
		method = firstDerivativePeakDetectorClass.getDeclaredMethod("detectPeakMaximum", new Class[]{IFirstDerivativeDetectorSlopes.class, Integer.TYPE, Integer.TYPE});
		method.setAccessible(true);
		/*
		 * Start the search at the peak beginning at scan 4 and has a scan
		 * offset of 0 (means starts at scan 1).
		 */
		result = (Integer)method.invoke(firstDerivativePeakDetector, new Object[]{slopes, 4, 0});
		/*
		 * The peak maximum is at scan 12.
		 */
		assertEquals(Integer.valueOf(12), result, "detectPeakMaximum");
	}

	@Test
	public void testDetectPeakStop_1() throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		Integer result;
		method = firstDerivativePeakDetectorClass.getDeclaredMethod("detectPeakStop", new Class[]{IFirstDerivativeDetectorSlopes.class, Integer.TYPE, Integer.TYPE});
		method.setAccessible(true);
		/*
		 * Start the search at the peak maximum at scan 12 and has a scan offset
		 * of 0 (means starts at scan 1).
		 */
		result = (Integer)method.invoke(firstDerivativePeakDetector, new Object[]{slopes, 12, 0});
		/*
		 * The peak stop is at scan 26.
		 */
		assertEquals( Integer.valueOf(26), result,"detectPeakStop");
	}
}
