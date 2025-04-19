/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.identifier.supplier.nist.settings;

import junit.framework.TestCase;

public class NistPeakIdentifierSettings_1_Test extends TestCase {

	private PeakIdentifierSettings settings;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		settings = new PeakIdentifierSettings();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testGetNumberOfTargets_1() {

		assertEquals(15, settings.getNumberOfTargets());
	}

	public void testGetNumberOfTargets_2() {

		settings.setNumberOfTargets((byte)1);
		assertEquals(1, settings.getNumberOfTargets());
	}

	public void testGetNumberOfTargets_3() {

		settings.setNumberOfTargets((byte)100);
		assertEquals(100, settings.getNumberOfTargets());
	}

	public void testGetNumberOfTargets_4() {

		settings.setNumberOfTargets((byte)0);
		assertEquals(15, settings.getNumberOfTargets());
	}

	public void testGetNumberOfTargets_5() {

		settings.setNumberOfTargets((byte)101);
		assertEquals(15, settings.getNumberOfTargets());
	}
}
