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
package org.eclipse.chemclipse.msd.identifier.supplier.nist.internal.results;

import junit.framework.TestCase;

public class Compounds_1_Test extends TestCase {

	private Compounds compounds;
	private Compound compound;
	private Hit hit;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		compounds = new Compounds();
		compound = new Compound();
		hit = new Hit();
		hit.setName("Styrene");
		compound.add(hit);
		compounds.add(compound);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testSize_1() {

		assertEquals(1, compounds.size());
	}

	public void testSize_2() {

		compound = new Compound();
		hit = new Hit();
		hit.setName("Styrene");
		compound.add(hit);
		compounds.remove(compound);
		assertEquals(0, compounds.size());
	}

	public void testSize_3() {

		compound = new Compound();
		hit = new Hit();
		hit.setName("Styrene");
		compound.add(hit);
		compounds.add(compound);
		assertEquals(2, compounds.size());
	}
}
