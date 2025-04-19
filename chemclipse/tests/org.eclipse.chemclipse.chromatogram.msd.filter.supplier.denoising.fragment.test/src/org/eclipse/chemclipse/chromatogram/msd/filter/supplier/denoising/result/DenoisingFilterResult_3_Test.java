/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.denoising.result;

import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;

import junit.framework.TestCase;

public class DenoisingFilterResult_3_Test extends TestCase {

	private IDenoisingFilterResult result;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		result = new DenoisingFilterResult(ResultStatus.OK, "The result status is ok.", null);
	}

	@Override
	protected void tearDown() throws Exception {

		result = null;
		super.tearDown();
	}

	public void testGetNoiseMassSpectra_1() {

		assertNotNull(result.getNoiseMassSpectra());
	}

	public void testGetNoiseMassSpectra_2() {

		assertEquals("Size", 0, result.getNoiseMassSpectra().size());
	}
}
