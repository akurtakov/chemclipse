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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.model.splash;

import org.eclipse.chemclipse.msd.model.core.IRegularMassSpectrum;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.VendorMassSpectrum;

import junit.framework.TestCase;

public class Splash_Test extends TestCase {

	IRegularMassSpectrum massSpectrum;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		massSpectrum = new VendorMassSpectrum();
		massSpectrum.addIon(new Ion(100, 1));
		massSpectrum.addIon(new Ion(101, 2));
		massSpectrum.addIon(new Ion(102, 3));
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testSplash() {

		assertEquals("splash10-0udi-0900000000-f5bf6f6a4a1520a35d4f", new SplashFactory(massSpectrum).getSplash());
	}
}
