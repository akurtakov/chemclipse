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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.coda.settings;

import junit.framework.TestCase;

public class CodaFilterSettings_1_Test extends TestCase {

	private FilterSettings settings;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		settings = new FilterSettings();
	}

	@Override
	protected void tearDown() throws Exception {

		settings = null;
		super.tearDown();
	}

	public void testGetCodaSettings_1() {

		assertNotNull(settings);
	}
}
