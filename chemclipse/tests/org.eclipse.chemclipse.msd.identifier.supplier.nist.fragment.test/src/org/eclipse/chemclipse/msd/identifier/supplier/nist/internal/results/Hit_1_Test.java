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

public class Hit_1_Test extends TestCase {

	private Hit hit;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		hit = new Hit();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testGetName_1() {

		assertEquals("", hit.getName());
	}

	public void testGetFormula_1() {

		assertEquals("", hit.getFormula());
	}

	public void testGetMF_1() {

		assertEquals(0.0f, hit.getMatchFactor());
	}

	public void testGetRMF_1() {

		assertEquals(0.0f, hit.getReverseMatchFactor());
	}

	public void testGetProb_1() {

		assertEquals(0.0f, hit.getProbability());
	}

	public void testGetCAS_1() {

		assertEquals("", hit.getCAS());
	}

	public void testGetMw_1() {

		assertEquals(0, hit.getMolecularWeight());
	}

	public void testGetLib_1() {

		assertEquals("", hit.getLib());
	}

	public void testGetId_1() {

		assertEquals(0, hit.getId());
	}

	public void testGetRi_1() {

		assertEquals(0, hit.getRetentionIndex());
	}
}
