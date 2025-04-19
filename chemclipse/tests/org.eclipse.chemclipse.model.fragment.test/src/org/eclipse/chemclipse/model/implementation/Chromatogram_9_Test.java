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
package org.eclipse.chemclipse.model.implementation;

import junit.framework.TestCase;

public class Chromatogram_9_Test extends TestCase {

	private Chromatogram chromatogram;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		chromatogram = new Chromatogram();
		chromatogram.setConverterId("hello.world.converter");
	}

	@Override
	protected void tearDown() throws Exception {

		chromatogram = null;
		super.tearDown();
	}

	public void test1() {

		assertEquals("hello.world.converter", chromatogram.getConverterId());
	}

	public void test2() {

		chromatogram.setFinalized(true);
		assertEquals("", chromatogram.getConverterId());
	}

	public void test3() {

		chromatogram.setFinalized(true);
		chromatogram.setFinalized(false);
		assertEquals("hello.world.converter", chromatogram.getConverterId());
	}
}