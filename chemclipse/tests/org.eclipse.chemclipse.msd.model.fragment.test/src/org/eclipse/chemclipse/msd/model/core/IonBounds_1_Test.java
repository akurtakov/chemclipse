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
package org.eclipse.chemclipse.msd.model.core;

import junit.framework.TestCase;

/**
 * ionBounds = new IonBounds(null, null);
 * 
 * @author eselmeister
 */
public class IonBounds_1_Test extends TestCase {

	private IIonBounds ionBounds;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		ionBounds = new IonBounds(null, null);
	}

	@Override
	protected void tearDown() throws Exception {

		ionBounds = null;
		super.tearDown();
	}

	public void testGetLowestIon_1() {

		assertEquals("GetLowestIon", null, ionBounds.getLowestIon());
	}

	public void testGetHighestIon_1() {

		assertEquals("GetHighestIon", null, ionBounds.getHighestIon());
	}
}
