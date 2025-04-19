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
package org.eclipse.chemclipse.msd.model.implementation;

import java.io.File;

import junit.framework.TestCase;

import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;

/**
 * @author eselmeister
 */
public class Chromatogram_23_Test extends TestCase {

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

	public void testGetName_1() {

		assertEquals("Chromatogram", chromatogram.getName());
	}

	public void testGetName_2() {

		chromatogram.setFile(null);
		assertEquals("Chromatogram", chromatogram.getName());
	}

	public void testGetName_3() {

		File file = new File("TestChromatogram.chrom");
		chromatogram.setFile(file);
		assertEquals("TestChromatogram.chrom", chromatogram.getName());
	}
}
