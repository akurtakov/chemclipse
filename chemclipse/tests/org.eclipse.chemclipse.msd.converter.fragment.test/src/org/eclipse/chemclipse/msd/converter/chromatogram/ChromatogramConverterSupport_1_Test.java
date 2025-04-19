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
 * Christoph Läubrich - Adjust to new API
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.chromatogram;

import org.eclipse.chemclipse.converter.chromatogram.ChromatogramConverterSupport;
import org.eclipse.chemclipse.converter.exceptions.NoConverterAvailableException;

import junit.framework.TestCase;

/**
 * This TestCase analyzes if the class ChromatogramConverterSupport methods work
 * in a correct way. The behavior after initialization is especially analyzed in
 * this TestCase.
 * 
 * @author eselmeister
 */
public class ChromatogramConverterSupport_1_Test extends TestCase {

	private ChromatogramConverterSupport support;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		support = new ChromatogramConverterSupport(null);
	}

	@Override
	protected void tearDown() throws Exception {

		support = null;
		super.tearDown();
	}

	public void testGetConverterId_1() {

		try {
			support.getConverterId(1);
		} catch(NoConverterAvailableException e) {
			assertTrue(true);
		}
	}

	public void testGetFilterExtensions_1() {

		try {
			support.getFilterExtensions();
		} catch(NoConverterAvailableException e) {
			assertTrue(true);
		}
	}

	public void testGetFilterNames_1() {

		try {
			support.getFilterNames();
		} catch(NoConverterAvailableException e) {
			assertTrue(true);
		}
	}
}
