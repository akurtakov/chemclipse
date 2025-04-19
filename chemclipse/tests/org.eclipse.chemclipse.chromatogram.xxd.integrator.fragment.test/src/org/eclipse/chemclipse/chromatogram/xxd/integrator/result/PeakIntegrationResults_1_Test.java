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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.result;

import java.util.List;

import junit.framework.TestCase;

public class PeakIntegrationResults_1_Test extends TestCase {

	private IPeakIntegrationResults results;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		results = new PeakIntegrationResults();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testGetPeakIntegrationResult_1() {

		assertNull(results.getPeakIntegrationResult(0));
	}

	public void testGetPeakIntegrationResultList_1() {

		List<IPeakIntegrationResult> presults = results.getPeakIntegrationResultList(55);
		assertEquals("size", 0, presults.size());
	}

	public void testGetPeakIntegrationResultThatContains_1() {

		List<IPeakIntegrationResult> presults = results.getPeakIntegrationResultThatContains(55);
		assertEquals("size", 0, presults.size());
	}

	public void testGetSize_1() {

		assertEquals("size", 0, results.size());
	}
}
