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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.msd.model.core.ICombinedMassSpectrum;
import org.eclipse.chemclipse.msd.model.implementation.CombinedMassSpectrum;

import junit.framework.TestCase;

public class DenoisingFilterResult_2_Test extends TestCase {

	private IDenoisingFilterResult result;
	private List<ICombinedMassSpectrum> noiseMassSpectra;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		noiseMassSpectra = new ArrayList<ICombinedMassSpectrum>();
		noiseMassSpectra.add(new CombinedMassSpectrum());
		result = new DenoisingFilterResult(ResultStatus.OK, "The result status is ok.", noiseMassSpectra);
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

		assertEquals("Size", 1, result.getNoiseMassSpectra().size());
	}
}
