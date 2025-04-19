/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.msd.model.core.IRegularLibraryMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.Polarity;

import junit.framework.TestCase;

public class RegularLibraryMassSpectrum_6_Test extends TestCase {

	private IRegularLibraryMassSpectrum massSpectrum;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		massSpectrum = new RegularLibraryMassSpectrum();
		massSpectrum.putProperty(IRegularLibraryMassSpectrum.PROPERTY_PRECURSOR_TYPE, "[M-H]-");
		massSpectrum.setPrecursorIon(687.3603d);
		massSpectrum.setNeutralMass(688.3682407538258d);
		massSpectrum.putProperty(IRegularLibraryMassSpectrum.PROPERTY_COLLISION_ENERGY, "30");
		massSpectrum.putProperty(IRegularLibraryMassSpectrum.PROPERTY_INSTRUMENT_NAME, "Agilent QTOF 6530");
	}

	@Override
	protected void tearDown() throws Exception {

		massSpectrum = null;
		super.tearDown();
	}

	public void test1() {

		assertNull(massSpectrum.getPrecursorType());
	}

	public void test2() {

		assertEquals(687.3603d, massSpectrum.getPrecursorIon());
	}

	public void test3() {

		assertEquals(688.3682407538258d, massSpectrum.getNeutralMass());
	}

	public void test4() {

		assertEquals(Polarity.NEGATIVE, massSpectrum.getPolarity());
	}

	public void test5() {

		assertEquals(3, massSpectrum.getPropertyKeySet().size());
	}

	public void test6() {

		assertEquals("[M-H]-", massSpectrum.getProperty(IRegularLibraryMassSpectrum.PROPERTY_PRECURSOR_TYPE));
	}

	public void test7() {

		assertEquals("30", massSpectrum.getProperty(IRegularLibraryMassSpectrum.PROPERTY_COLLISION_ENERGY));
	}

	public void test8() {

		assertEquals("Agilent QTOF 6530", massSpectrum.getProperty(IRegularLibraryMassSpectrum.PROPERTY_INSTRUMENT_NAME));
	}
}