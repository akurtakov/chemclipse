/*******************************************************************************
 * Copyright (c) 2010, 2026 Lablicate GmbH.
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.msd.model.core.ICombinedMassSpectrum;
import org.eclipse.chemclipse.msd.model.implementation.CombinedMassSpectrum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class DenoisingFilterResult_2_Test {

	private IDenoisingFilterResult result;

	@BeforeAll
	public void setUp() {

		List<ICombinedMassSpectrum> noiseMassSpectra = new ArrayList<>();
		noiseMassSpectra.add(new CombinedMassSpectrum());
		result = new DenoisingFilterResult(ResultStatus.OK, "The result status is ok.", noiseMassSpectra);
	}

	@Test
	public void testGetNoiseMassSpectra_1() {

		assertNotNull(result.getNoiseMassSpectra());
	}

	@Test
	public void testGetNoiseMassSpectra_2() {

		assertEquals(1, result.getNoiseMassSpectra().size(), "Size");
	}
}
