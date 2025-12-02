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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.internal.core.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.model.support.RetentionTimeRange;
import org.junit.jupiter.api.Test;

public class RetentionTimeRange_1_Test {

	@Test
	public void testGetRetentionTime_1() {

		RetentionTimeRange retentionTimeRange = new RetentionTimeRange(0, 0);
		assertEquals(0, retentionTimeRange.getStartRetentionTime());
		assertEquals(0, retentionTimeRange.getStopRetentionTime());
	}

	@Test
	public void testGetRetentionTime_2() {

		RetentionTimeRange retentionTimeRange = new RetentionTimeRange(1500, 2500);
		assertEquals(1500, retentionTimeRange.getStartRetentionTime());
		assertEquals(2500, retentionTimeRange.getStopRetentionTime());
	}

	@Test
	public void testGetRetentionTime_3() {

		RetentionTimeRange retentionTimeRange = new RetentionTimeRange(-1, 2500);
		assertEquals(0, retentionTimeRange.getStartRetentionTime());
		assertEquals(2500, retentionTimeRange.getStopRetentionTime());
	}

	@Test
	public void testGetRetentionTime_4() {

		RetentionTimeRange retentionTimeRange = new RetentionTimeRange(1500, -1);
		assertEquals(0, retentionTimeRange.getStartRetentionTime());
		assertEquals(1500, retentionTimeRange.getStopRetentionTime());
	}

	@Test
	public void testGetRetentionTime_5() {

		RetentionTimeRange retentionTimeRange = new RetentionTimeRange(2500, 1500);
		assertEquals(1500, retentionTimeRange.getStartRetentionTime());
		assertEquals(2500, retentionTimeRange.getStopRetentionTime());
	}
}
