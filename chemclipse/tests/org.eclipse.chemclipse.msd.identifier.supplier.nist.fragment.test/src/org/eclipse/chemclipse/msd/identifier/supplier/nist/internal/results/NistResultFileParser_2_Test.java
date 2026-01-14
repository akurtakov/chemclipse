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

import org.eclipse.chemclipse.converter.PathResolver;
import org.eclipse.chemclipse.msd.identifier.supplier.nist.TestPathHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.osgi.framework.FrameworkUtil;

@TestInstance(Lifecycle.PER_CLASS)
public class NistResultFileParser_2_Test {

	private Compounds compounds;
	private Compound compound;
	private Hit hit;

	@BeforeAll
	public void setUp() throws IOException {

		NistResultFileParser nistResultFileParser = new NistResultFileParser();
		File results = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.TESTFILE_NIST_SRCRESLT_2);
		compounds = nistResultFileParser.getCompounds(results);
	}

	@Test
	public void testSize_1() {

		assertEquals(4, compounds.size());
	}

	@Test
	public void testGetCompound_1() {

		compound = compounds.getCompound(1);
		assertEquals(2, compound.size());
	}

	@Test
	public void testGetCompound_2() {

		compound = compounds.getCompound(2);
		assertEquals(1, compound.size());
	}

	@Test
	public void testGetCompound_3() {

		compound = compounds.getCompound(3);
		assertEquals(4, compound.size());
	}

	@Test
	public void testGetCompound_4() {

		compound = compounds.getCompound(4);
		assertEquals(3, compound.size());
	}

	@Test
	public void testGetHit_1() {

		compound = compounds.getCompound(1);
		hit = compound.getHit(1);
		assertEquals("9-Tetradecen-1-ol, (E)-", hit.getName());
	}

	@Test
	public void testGetHit_2() {

		compound = compounds.getCompound(1);
		hit = compound.getHit(2);
		assertEquals("1,2-Benzenediol, 4-(2-amino-1-hydroxypropyl)-", hit.getName());
	}

	@Test
	public void testGetHit_3() {

		compound = compounds.getCompound(2);
		hit = compound.getHit(1);
		assertEquals("9-Tetradecen-1-ol, (E)-", hit.getName());
	}

	@Test
	public void testGetHit_4() {

		compound = compounds.getCompound(3);
		hit = compound.getHit(1);
		assertEquals("6-Methyl-6-hepten-4-yn-2-ol", hit.getName());
	}

	@Test
	public void testGetHit_5() {

		compound = compounds.getCompound(3);
		hit = compound.getHit(4);
		assertEquals("Ethylbenzene", hit.getName());
	}

	@Test
	public void testGetHit_6() {

		compound = compounds.getCompound(4);
		hit = compound.getHit(1);
		assertEquals("9-Tetradecen-1-ol, (E)-", hit.getName());
	}

	@Test
	public void testGetHit_7() {

		compound = compounds.getCompound(4);
		hit = compound.getHit(3);
		assertEquals("9-Tetradecen-1-ol, (E)-", hit.getName());
	}
}
