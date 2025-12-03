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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * HashCode test.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class Ion_10_Test {

	private Ion ion1;
	private Ion ion2;

	@BeforeAll
	public void setUp() {

		ion1 = new Ion(5.2f, 4746.3f);
	}

	@Test
	public void testConstructor_1() {

		ion2 = new Ion(ion1);
		assertTrue(ion1.equals(ion2));
	}

	@Test
	public void testConstructor_2() {

		assertThrows(IllegalArgumentException.class, () -> ion2 = new Ion(null));
	}
}
