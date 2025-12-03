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
package org.eclipse.chemclipse.msd.model.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Equals, hashCode
 */
@TestInstance(Lifecycle.PER_CLASS)
public class MassSpectrum_1_Test {

	private ScanMSD massSpectrum1;
	private ScanMSD massSpectrum2;

	@BeforeAll
	public void setUp() {

		massSpectrum1 = new ScanMSD();
		massSpectrum2 = new ScanMSD();
	}

	@Test
	public void testEquals_1() {

		assertEquals(true, massSpectrum1.equals(massSpectrum2));
	}

	@Test
	public void testEquals_2() {

		assertEquals(true, massSpectrum2.equals(massSpectrum1));
	}

	@Test
	public void testHashCode_1() {

		assertEquals(massSpectrum1.hashCode(), massSpectrum2.hashCode());
	}

	@Test
	public void testHashCode_2() {

		assertEquals(massSpectrum2.hashCode(), massSpectrum1.hashCode());
	}
}
