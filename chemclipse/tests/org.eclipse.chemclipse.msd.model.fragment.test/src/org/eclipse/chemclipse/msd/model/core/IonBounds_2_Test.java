/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class IonBounds_2_Test {

	private IIonBounds ionBounds;
	private Ion ion;

	@BeforeAll
	public void setUp() {

		ion = new Ion(25.5f, 3452.4f);
		ionBounds = new IonBounds(ion, ion);
	}

	@Test
	public void testGetLowestIon_1() {

		assertEquals(25.5d, ionBounds.getLowestIon().getIon(), 0);
	}

	@Test
	public void testGetLowestIon_2() {

		assertEquals(3452.4f, ionBounds.getLowestIon().getAbundance(), 0);
	}

	@Test
	public void testGetHighestIon_1() {

		assertEquals(25.5d, ionBounds.getHighestIon().getIon(), 0);
	}

	@Test
	public void testGetHighestIon_2() {

		assertEquals(3452.4f, ionBounds.getHighestIon().getAbundance(), 0);
	}
}
