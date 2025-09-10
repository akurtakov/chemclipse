/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.backfolding.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BackfoldingSettings_1_Test {

	private IBackfoldingSettings settings = new BackfoldingSettings();

	@Test
	public void testGetMaximumRetentionTimeShift_1() {

		int shift = settings.getMaximumRetentionTimeShift();
		assertEquals(5000, shift, "RetentionTimeShift");
	}

	@Test
	public void testGetNumberOfBackfoldingRuns_1() {

		int runs = settings.getNumberOfBackfoldingRuns();
		assertEquals(3, runs, "Backfolding Runs");
	}

	@Test
	public void testSetMaximumRetentionTimeShift_1() {

		settings.setMaximumRetentionTimeShift(1000);
		int shift = settings.getMaximumRetentionTimeShift();
		assertEquals(1000, shift, "RetentionTimeShift");
	}

	@Test
	public void testSetMaximumRetentionTimeShift_2() {

		settings.setMaximumRetentionTimeShift(500);
		int shift = settings.getMaximumRetentionTimeShift();
		assertEquals(500, shift, "RetentionTimeShift");
	}

	@Test
	public void testSetMaximumRetentionTimeShift_3() {

		settings.setMaximumRetentionTimeShift(25000);
		int shift = settings.getMaximumRetentionTimeShift();
		assertEquals(25000, shift, "RetentionTimeShift");
	}

	@Test
	public void testSetMaximumRetentionTimeShift_4() {

		settings.setMaximumRetentionTimeShift(499);
		int shift = settings.getMaximumRetentionTimeShift();
		assertEquals(5000, shift, "RetentionTimeShift");
	}

	@Test
	public void testSetMaximumRetentionTimeShift_5() {

		settings.setMaximumRetentionTimeShift(25001);
		int shift = settings.getMaximumRetentionTimeShift();
		assertEquals(5000, shift, "RetentionTimeShift");
	}

	@Test
	public void testSetNumberOfBackfoldingRuns_1() {

		settings.setNumberOfBackfoldingRuns(5);
		int runs = settings.getNumberOfBackfoldingRuns();
		assertEquals(5, runs, "Backfolding Runs");
	}

	@Test
	public void testSetNumberOfBackfoldingRuns_2() {

		settings.setNumberOfBackfoldingRuns(1);
		int runs = settings.getNumberOfBackfoldingRuns();
		assertEquals(1, runs, "Backfolding Runs");
	}

	@Test
	public void testSetNumberOfBackfoldingRuns_3() {

		settings.setNumberOfBackfoldingRuns(10);
		int runs = settings.getNumberOfBackfoldingRuns();
		assertEquals(10, runs, "Backfolding Runs");
	}

	@Test
	public void testSetNumberOfBackfoldingRuns_4() {

		settings.setNumberOfBackfoldingRuns(0);
		int runs = settings.getNumberOfBackfoldingRuns();
		assertEquals(3, runs, "Backfolding Runs");
	}

	@Test
	public void testSetNumberOfBackfoldingRuns_5() {

		settings.setNumberOfBackfoldingRuns(11);
		int runs = settings.getNumberOfBackfoldingRuns();
		assertEquals(3, runs, "Backfolding Runs");
	}
}
