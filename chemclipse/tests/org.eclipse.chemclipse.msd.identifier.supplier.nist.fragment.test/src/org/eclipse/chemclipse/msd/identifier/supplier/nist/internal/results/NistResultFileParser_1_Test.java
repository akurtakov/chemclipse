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

import java.io.File;

import org.eclipse.chemclipse.msd.identifier.supplier.nist.TestPathHelper;

import junit.framework.TestCase;

public class NistResultFileParser_1_Test extends TestCase {

	private NistResultFileParser nistResultFileParser;
	private File results;
	private Compounds compounds;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		nistResultFileParser = new NistResultFileParser();
		results = new File(TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_NIST_SRCRESLT_1));
		compounds = nistResultFileParser.getCompounds(results);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testCompounds_1() {

		assertNotNull(compounds);
	}

	public void testSize_1() {

		assertEquals("Size", 213, compounds.size());
	}
}
