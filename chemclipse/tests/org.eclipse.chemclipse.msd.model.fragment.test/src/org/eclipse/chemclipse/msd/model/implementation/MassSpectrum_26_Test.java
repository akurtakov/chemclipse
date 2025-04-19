/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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

import junit.framework.TestCase;

/**
 * Tests adjustTotalSignal(float totalSignal).
 * 
 * @author eselmeister
 */
public class MassSpectrum_26_Test extends TestCase {

	private ScanMSD massSpectrum;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		massSpectrum = new ScanMSD();
	}

	@Override
	protected void tearDown() throws Exception {

		massSpectrum = null;
		super.tearDown();
	}

	public void testIdentifier_1() {

		assertEquals("Identifier", "", massSpectrum.getIdentifier());
	}

	public void testIdentifier_2() {

		massSpectrum.setIdentifier(null);
		assertEquals("Identifier", "", massSpectrum.getIdentifier());
	}

	public void testIdentifier_3() {

		massSpectrum.setIdentifier("MS-I");
		assertEquals("Identifier", "MS-I", massSpectrum.getIdentifier());
	}

	public void testIdentifier_4() {

		massSpectrum.setIdentifier("MS-I");
		massSpectrum.setIdentifier(null);
		assertEquals("Identifier", "MS-I", massSpectrum.getIdentifier());
	}
}
