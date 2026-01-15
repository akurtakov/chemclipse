/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.msd.identifier.supplier.nist.TestPathHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class NistResultFileParser_3_Test {

	private Compound compound;
	private Hit hit;

	@BeforeAll
	public void setUp() throws IOException {

		NistResultFileParser nistResultFileParser = new NistResultFileParser();
		File results = new File(TestPathHelper.TESTFILE_NIST_SRCRESLT_2);
		Compounds compounds = nistResultFileParser.getCompounds(results);
		compound = compounds.getCompound(3);
		hit = compound.getHit(3);
	}

	@Test
	public void testGetCompoundInLibraryFactor_1() {

		assertEquals("-1558", compound.getCompoundInLibraryFactor());
	}

	@Test
	public void testGetName_1() {

		assertEquals("Hydrazinecarboxylic acid, phenylmethyl ester", hit.getName());
	}

	@Test
	public void testGetFormula_1() {

		assertEquals("C8H10N2O2", hit.getFormula());
	}

	@Test
	public void testGetMF_1() {

		assertEquals(67.1f, hit.getMatchFactor(), 0);
	}

	@Test
	public void testGetRMF_1() {

		assertEquals(68.6f, hit.getReverseMatchFactor(), 0);
	}

	@Test
	public void testGetProb_1() {

		assertEquals(45.98f, hit.getProbability(), 0);
	}

	@Test
	public void testGetCAS_1() {

		assertEquals("5331-43-1", hit.getCAS());
	}

	@Test
	public void testGetMw_1() {

		assertEquals(166, hit.getMolecularWeight());
	}

	@Test
	public void testGetLib_1() {

		assertEquals("mainlib", hit.getLib());
	}

	@Test
	public void testGetId_1() {

		assertEquals(2140, hit.getId());
	}
}
