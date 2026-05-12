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
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class NistResultFileParser_1_Test {

	private Compounds compounds;

	@BeforeAll
	public void setUp() {

		NistResultFileParser nistResultFileParser = new NistResultFileParser();
		File results = new File("testData/files/nist/SRCRESLT-1.TXT");
		compounds = nistResultFileParser.getCompounds(results);
	}

	@Test
	public void testCompounds_1() {

		assertNotNull(compounds);
	}

	@Test
	public void testSize_1() {

		assertEquals(213, compounds.size());
	}
}
