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
package org.eclipse.chemclipse.msd.model.xic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.model.signals.ITotalScanSignal;
import org.eclipse.chemclipse.model.signals.TotalScanSignal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Test all methods of TotalIonSignal.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class TotalIonSignal_1_Test {

	private ITotalScanSignal totalIonSignal;

	@BeforeAll
	public void setUp() {

		totalIonSignal = new TotalScanSignal(0, 0.0f, 0.0f);
	}

	@Test
	public void testGetRetentionTime_1() {

		assertEquals(0, totalIonSignal.getRetentionTime());
	}

	@Test
	public void testGetRetentionIndex_1() {

		assertEquals(0.0f, totalIonSignal.getRetentionIndex(), 0);
	}

	@Test
	public void testGetTotalSignal_1() {

		assertEquals(0.0f, totalIonSignal.getTotalSignal(), 0);
	}
}
