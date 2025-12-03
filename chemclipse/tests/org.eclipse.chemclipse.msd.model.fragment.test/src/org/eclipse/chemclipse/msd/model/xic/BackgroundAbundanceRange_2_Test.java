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

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.chemclipse.model.support.BackgroundAbundanceRange;
import org.eclipse.chemclipse.model.support.IBackgroundAbundanceRange;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Tests the class BackgroundAbundanceRange concerning equals, hashCode and
 * toString.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class BackgroundAbundanceRange_2_Test {

	private IBackgroundAbundanceRange backgroundAbundanceRange1;
	private IBackgroundAbundanceRange backgroundAbundanceRange2;

	@BeforeAll
	public void setUp() {

		backgroundAbundanceRange1 = new BackgroundAbundanceRange(0, 5);
		backgroundAbundanceRange2 = new BackgroundAbundanceRange(0, 5);
	}

	@Test
	public void testEquals_1() {

		assertTrue(backgroundAbundanceRange1.equals(backgroundAbundanceRange2));
	}

	@Test
	public void testEquals_2() {

		assertTrue(backgroundAbundanceRange2.equals(backgroundAbundanceRange1));
	}

	@Test
	public void testHashCode_1() {

		assertTrue(backgroundAbundanceRange1.hashCode() == backgroundAbundanceRange2.hashCode());
	}

	@Test
	public void testHashCode_2() {

		assertTrue(backgroundAbundanceRange2.hashCode() == backgroundAbundanceRange1.hashCode());
	}

	@Test
	public void testToString_1() {

		assertTrue(backgroundAbundanceRange1.toString().equals(backgroundAbundanceRange2.toString()));
	}

	@Test
	public void testToString_2() {

		assertTrue(backgroundAbundanceRange2.toString().equals(backgroundAbundanceRange1.toString()));
	}
}
