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

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.eclipse.chemclipse.msd.model.core.IIon;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Equals and hashCode test.
 * 
 * @author Philip Wenig
 */
@TestInstance(Lifecycle.PER_CLASS)
public class SupplierIon_4_Test {

	private IIon ion1;
	private IIon ion2;

	@BeforeAll
	public void setUp() {

		ion1 = new Ion(1.0f, 5726.4f);
		ion2 = new Ion(1.0f, 5716.4f);
	}

	@Test
	public void testEquals_1() {

		assertNotEquals(ion1, ion2);
	}

	@Test
	public void testEquals_2() {

		assertNotEquals(ion2, ion1);
	}

	@Test
	public void testHashCode_1() {

		assertNotEquals(ion1.hashCode(), ion2.hashCode());
	}

	@Test
	public void testHashCode_2() {

		assertNotEquals(ion2.hashCode(), ion1.hashCode());
	}
}
