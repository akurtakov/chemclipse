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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.savitzkygolay.settings;

import junit.framework.TestCase;

public class SupplierFilterSettings_1_Test extends TestCase {

	private ChromatogramFilterSettings settings;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		settings = new ChromatogramFilterSettings();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void test1() {

		assertEquals(0, settings.getDerivative());
	}

	public void test2() {

		assertEquals(2, settings.getOrder());
	}

	public void test3() {

		assertEquals(5, settings.getWidth());
	}
}
