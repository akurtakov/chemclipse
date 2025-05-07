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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.model;

import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.preferences.PreferenceSupplier;

import junit.framework.TestCase;

public class ScanRemoverPattern_1_Test extends TestCase {

	private ScanRemoverPattern scanRemoverPattern;
	private String PRESERVE = PreferenceSupplier.PRESERVE_SIGN.toString();
	private String REMOVE = PreferenceSupplier.REMOVE_SIGN.toString();
	private String pattern;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testConstruct_1() {

		scanRemoverPattern = new ScanRemoverPattern("");
		assertEquals(false, scanRemoverPattern.remove());
		assertEquals(false, scanRemoverPattern.remove());
	}

	public void testConstruct_2() {

		scanRemoverPattern = new ScanRemoverPattern(null);
		assertEquals(false, scanRemoverPattern.remove());
		assertEquals(false, scanRemoverPattern.remove());
	}

	public void testConstruct_3() {

		scanRemoverPattern = new ScanRemoverPattern("aldpp" + PRESERVE + "asfw" + REMOVE);
		assertEquals(false, scanRemoverPattern.remove());
		assertEquals(true, scanRemoverPattern.remove());
		assertEquals(false, scanRemoverPattern.remove());
		assertEquals(true, scanRemoverPattern.remove());
	}

	public void testConstruct_4() {

		scanRemoverPattern = new ScanRemoverPattern("aldpp" + REMOVE + "asfw" + PRESERVE);
		assertEquals(true, scanRemoverPattern.remove());
		assertEquals(false, scanRemoverPattern.remove());
		assertEquals(true, scanRemoverPattern.remove());
		assertEquals(false, scanRemoverPattern.remove());
	}

	public void testConstruct_5() {

		pattern = PRESERVE + REMOVE;
		scanRemoverPattern = new ScanRemoverPattern(pattern);
		assertEquals(false, scanRemoverPattern.remove());
		assertEquals(true, scanRemoverPattern.remove());
		assertEquals(false, scanRemoverPattern.remove());
		assertEquals(true, scanRemoverPattern.remove());
	}

	public void testConstruct_6() {

		pattern = REMOVE + PRESERVE;
		scanRemoverPattern = new ScanRemoverPattern(pattern);
		assertEquals(true, scanRemoverPattern.remove());
		assertEquals(false, scanRemoverPattern.remove());
		assertEquals(true, scanRemoverPattern.remove());
		assertEquals(false, scanRemoverPattern.remove());
	}

	public void testConstruct_7() {

		StringBuilder builder = new StringBuilder();
		builder.append(PRESERVE);
		builder.append(PRESERVE);
		builder.append(PRESERVE);
		builder.append(REMOVE);
		builder.append(PRESERVE);
		builder.append(PRESERVE);
		builder.append(REMOVE);
		pattern = builder.toString();
		scanRemoverPattern = new ScanRemoverPattern(pattern);
		assertEquals(false, scanRemoverPattern.remove());
		assertEquals(false, scanRemoverPattern.remove());
		assertEquals(false, scanRemoverPattern.remove());
		assertEquals(true, scanRemoverPattern.remove());
		assertEquals(false, scanRemoverPattern.remove());
		assertEquals(false, scanRemoverPattern.remove());
		assertEquals(true, scanRemoverPattern.remove());
	}
}