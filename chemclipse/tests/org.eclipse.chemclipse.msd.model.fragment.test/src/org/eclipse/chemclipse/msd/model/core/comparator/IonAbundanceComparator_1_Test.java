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
package org.eclipse.chemclipse.msd.model.core.comparator;

import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.implementation.Ion;

import junit.framework.TestCase;

public class IonAbundanceComparator_1_Test extends TestCase {

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testAbundanceComparator_1() {

		IIon ion1 = new Ion(25.5f, 5000.5f);
		IIon ion2 = new Ion(25.5f, 5000.5f);
		IonAbundanceComparator comparator = new IonAbundanceComparator();
		assertEquals("Comparator", 0, comparator.compare(ion1, ion2));
	}

	public void testAbundanceComparator_2() {

		try {
			IIon ion1 = null;
			IIon ion2 = new Ion(25.5f, 5000.5f);
			IonAbundanceComparator comparator = new IonAbundanceComparator();
			assertEquals("Comparator", 0, comparator.compare(ion1, ion2));
		} catch(NullPointerException e) {
			assertTrue(true);
		}
	}

	public void testAbundanceComparator_3() {

		try {
			IIon ion1 = new Ion(25.5f, 5000.5f);
			IIon ion2 = null;
			IonAbundanceComparator comparator = new IonAbundanceComparator();
			assertEquals("Comparator", 0, comparator.compare(ion1, ion2));
		} catch(NullPointerException e) {
			assertTrue(true);
		}
	}

	public void testAbundanceComparator_4() {

		IIon ion1 = new Ion(25.5f, 4000.5f);
		IIon ion2 = new Ion(25.5f, 5000.5f);
		IonAbundanceComparator comparator = new IonAbundanceComparator();
		assertTrue(-1 >= comparator.compare(ion1, ion2));
	}

	public void testAbundanceComparator_5() {

		IIon ion1 = new Ion(25.5f, 5000.5f);
		IIon ion2 = new Ion(25.5f, 4000.5f);
		IonAbundanceComparator comparator = new IonAbundanceComparator();
		assertTrue(1 <= comparator.compare(ion1, ion2));
	}
}
