/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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

public class Chromatogram_7_Test extends TestCase {

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

	public void test1() {

		assertNotNull(chromatogram.getBaselineModel());
	}

	public void test2() {

		assertEquals("Default", chromatogram.getActiveBaseline());
	}

	public void test3() {

		assertEquals(1, chromatogram.getBaselineIds().size());
	}

	public void test4() {

		assertTrue(chromatogram.getBaselineIds().contains("Default"));
	}

	public void test5() {

		chromatogram.setActiveBaseline(null);
		assertEquals("Default", chromatogram.getActiveBaseline());
	}

	public void test6() {

		chromatogram.setActiveBaseline("");
		assertEquals("Default", chromatogram.getActiveBaseline());
	}

	public void test7() {

		chromatogram.removeBaseline("");
		assertEquals("Default", chromatogram.getActiveBaseline());
	}

	public void test8() {

		chromatogram.removeBaseline(null);
		assertEquals("Default", chromatogram.getActiveBaseline());
	}
}
