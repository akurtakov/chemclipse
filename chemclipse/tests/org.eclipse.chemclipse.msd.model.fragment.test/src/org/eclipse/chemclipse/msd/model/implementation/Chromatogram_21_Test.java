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

import junit.framework.TestCase;

import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;

/**
 * @author eselmeister
 */
public class Chromatogram_21_Test extends TestCase {

	private IChromatogramMSD chromatogram;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		chromatogram = new ChromatogramMSD();
	}

	@Override
	protected void tearDown() throws Exception {

		chromatogram = null;
		super.tearDown();
	}

	public void testGetStartIon_1() {

		double startIon = chromatogram.getStartIon();
		assertEquals("startIon", 0.0d, startIon);
	}

	public void testGetStopIon_1() {

		double stopIon = chromatogram.getStopIon();
		assertEquals("stopIon", 0.0d, stopIon);
	}
}
