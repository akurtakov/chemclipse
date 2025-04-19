/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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

import junit.framework.TestCase;

/**
 * Abundance and ion test.
 * 
 * @author eselmeister
 */
public class Ion_1_Test extends TestCase {

	private Ion ion;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		ion = new Ion(0.0f, 0.0f);
	}

	@Override
	protected void tearDown() throws Exception {

		ion = null;
		super.tearDown();
	}

	public void testGetAbundance() {

		assertEquals("getAbundance", 0.0f, ion.getAbundance());
	}

	public void testGetIon() {

		assertEquals("getIon", 0.0d, ion.getIon());
	}
}
