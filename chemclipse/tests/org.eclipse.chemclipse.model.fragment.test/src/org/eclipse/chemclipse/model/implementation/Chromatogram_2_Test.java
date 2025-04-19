/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.implementation;

import junit.framework.TestCase;

public class Chromatogram_2_Test extends TestCase {

	private Chromatogram chromatogram;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		chromatogram = new Chromatogram();
	}

	@Override
	protected void tearDown() throws Exception {

		chromatogram = null;
		super.tearDown();
	}

	public void testChromatogram_1() {

		assertFalse(chromatogram.isUnloaded());
	}

	public void testChromatogram_2() {

		chromatogram.setUnloaded();
		assertTrue(chromatogram.isUnloaded());
	}
}
