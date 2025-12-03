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
 * Abundance and ion test.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class Ion_2_Test {

	private Ion ion;

	@BeforeAll
	public void setUp() {

		ion = new Ion(2.2f, 4527.3f);
	}

	@Test
	public void testGetAbundance() {

		assertEquals(4527.3f, ion.getAbundance(), 0);
	}

	@Test
	public void testGetIon() {

		assertEquals(2.200000047683716d, ion.getIon(), 0);
	}
}
