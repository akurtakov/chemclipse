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
package org.eclipse.chemclipse.model.instruments;

import junit.framework.TestCase;

public class Instrument_5_Test extends TestCase {

	private Instrument instrument;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		instrument = new Instrument("", "", "");
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void test1() {

		assertEquals("", instrument.getIdentifier());
	}

	public void test2() {

		assertEquals("", instrument.getName());
	}

	public void test3() {

		assertEquals("", instrument.getDescription());
	}
}
