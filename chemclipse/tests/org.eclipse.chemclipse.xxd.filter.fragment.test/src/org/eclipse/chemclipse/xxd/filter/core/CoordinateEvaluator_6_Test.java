/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.filter.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.xxd.filter.model.CoordinateOption;
import org.eclipse.chemclipse.xxd.filter.model.RangeOption;
import org.junit.jupiter.api.Test;

public class CoordinateEvaluator_6_Test extends CoordinateEvaluatorTestCase {

	@Test
	public void test1() {

		IScan scan = createScan(0, 0);
		assertTrue(CoordinateEvaluator.isMatchScan(scan, CoordinateOption.RETENTION_TIME_MS, RangeOption.LOWER, 1000));
	}

	@Test
	public void test2() {

		IScan scan = createScan(0, 0);
		assertTrue(CoordinateEvaluator.isMatchScan(scan, CoordinateOption.RETENTION_TIME_MIN, RangeOption.LOWER, 1));
	}

	@Test
	public void test3() {

		IScan scan = createScan(0, 0);
		assertFalse(CoordinateEvaluator.isMatchScan(scan, CoordinateOption.RETENTION_INDEX, RangeOption.LOWER, 1));
	}

	@Test
	public void test4() {

		IScan scan = createScan(0, 1);
		assertFalse(CoordinateEvaluator.isMatchScan(scan, CoordinateOption.RETENTION_INDEX, RangeOption.LOWER, 1));
	}

	@Test
	public void test5() {

		IScan scan = createScan(0, 1);
		assertTrue(CoordinateEvaluator.isMatchScan(scan, CoordinateOption.RETENTION_INDEX, RangeOption.LOWER, 2));
	}
}