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
package org.eclipse.chemclipse.chromatogram.msd.comparison.massspectrum;

import junit.framework.TestCase;

public class MassSpectrumComparisonSupplier_1_Test extends TestCase {

	private MassSpectrumComparisonSupplier supplier;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		supplier = new MassSpectrumComparisonSupplier();
	}

	@Override
	protected void tearDown() throws Exception {

		supplier = null;
		super.tearDown();
	}

	public void testGetId_1() {

		assertEquals("id", "", supplier.getId());
	}

	public void testGetDescription_1() {

		assertEquals("description", "", supplier.getDescription());
	}

	public void testGetComparatorName_1() {

		assertEquals("detectorName", "", supplier.getComparatorName());
	}
}
