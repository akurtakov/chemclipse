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
package org.eclipse.chemclipse.chromatogram.msd.peak.detector.core;

import junit.framework.TestCase;

/**
 * @author eselmeister
 */
public class PeakDetectorSupplier_1_Test extends TestCase {

	private PeakDetectorMSDSupplier supplier;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		supplier = new PeakDetectorMSDSupplier("org.eclipse.chemclipse.test", "This is a description.", "Peak Detector Name");
	}

	@Override
	protected void tearDown() throws Exception {

		supplier = null;
		super.tearDown();
	}

	public void testGetId_1() {

		assertEquals("Id", "org.eclipse.chemclipse.test", supplier.getId());
	}

	public void testGetDescription_1() {

		assertEquals("Description", "This is a description.", supplier.getDescription());
	}

	public void testGetFilterName_1() {

		assertEquals("Name", "Peak Detector Name", supplier.getPeakDetectorName());
	}
}
