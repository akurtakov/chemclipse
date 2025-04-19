/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.pdfbox.extensions.settings;

import org.apache.pdfbox.pdmodel.common.PDRectangle;

import junit.framework.TestCase;

public class PageSettings_1_Test extends TestCase {

	private PageSettings settings;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		settings = new PageSettings(PDRectangle.A4, PageBase.BOTTOM_LEFT, Unit.MM, true);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void test1() {

		assertEquals(settings.getPDRectangle(), PDRectangle.A4);
	}

	public void test2() {

		assertEquals(settings.getPageBase(), PageBase.BOTTOM_LEFT);
	}

	public void test3() {

		assertEquals(settings.getUnit(), Unit.MM);
	}

	public void test4() {

		assertTrue(settings.isLandscape());
	}

	public void test5() {

		assertFalse(new PageSettings(PDRectangle.A4, PageBase.BOTTOM_LEFT, Unit.MM, false).isLandscape());
	}
}
