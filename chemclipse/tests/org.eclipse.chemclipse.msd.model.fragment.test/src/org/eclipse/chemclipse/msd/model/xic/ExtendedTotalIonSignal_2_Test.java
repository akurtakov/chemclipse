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
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.eclipse.chemclipse.model.signals.ITotalScanSignal;
import org.eclipse.chemclipse.model.signals.TotalScanSignal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Test methods of ExtendedTotalIonSignal.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class ExtendedTotalIonSignal_2_Test {

	private ITotalScanSignal totalIonSignal;

	@BeforeAll
	public void setUp() {

		totalIonSignal = new TotalScanSignal(1524, 0.0f, -346.0f);
	}

	@Test
	public void testMakeDeepCopy_1() {

		ITotalScanSignal totalIonSignal2 = totalIonSignal.makeDeepCopy();
		assertNotSame(totalIonSignal2, totalIonSignal);
		assertEquals(totalIonSignal.getRetentionTime(), totalIonSignal2.getRetentionTime());
		assertEquals(totalIonSignal.getRetentionIndex(), totalIonSignal2.getRetentionIndex(), 0);
		assertEquals(totalIonSignal.getTotalSignal(), totalIonSignal2.getTotalSignal(), 0);
	}
}
