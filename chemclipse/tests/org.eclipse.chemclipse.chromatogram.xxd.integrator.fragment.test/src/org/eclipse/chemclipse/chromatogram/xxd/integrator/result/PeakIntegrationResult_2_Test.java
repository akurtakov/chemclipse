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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.result;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PeakIntegrationResult_2_Test {

	private IPeakIntegrationResult result1;
	private IPeakIntegrationResult result2;

	@BeforeAll
	public void setUp() {

		result1 = new PeakIntegrationResult();
		result1.setStartRetentionTime(1500);
		result1.setStopRetentionTime(1700);

		result2 = new PeakIntegrationResult();
		result2.setStartRetentionTime(1500);
		result2.setStopRetentionTime(1600);
	}

	@Test
	public void testEquals_1() {

		assertNotEquals(result1, result2);
	}

	@Test
	public void testEquals_2() {

		assertNotEquals(result2, result1);
	}

	@Test
	public void testEquals_3() {

		assertEquals(result1, result1);
	}

	@Test
	public void testEquals_4() {

		assertNotNull(result1);
	}

	@Test
	public void testEquals_5() {

		assertNotEquals(result2, new Object());
	}
}
