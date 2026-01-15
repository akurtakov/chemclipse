/*******************************************************************************
 * Copyright (c) 2024, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.mmass.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.converter.PathResolver;
import org.eclipse.chemclipse.msd.converter.supplier.mmass.TestPathHelper;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IStandaloneMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.MassSpectrumType;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.osgi.framework.FrameworkUtil;

@TestInstance(Lifecycle.PER_CLASS)
public class Tiny22_ITest {

	private IStandaloneMassSpectrum massSpectrum;

	@BeforeAll
	public void setUp() throws IOException {

		File importFile = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.TESTFILE_MMASS_TINY_22);
		MassSpectrumImportConverter converter = new MassSpectrumImportConverter();
		IProcessingInfo<IMassSpectra> processingInfo = converter.convert(importFile, new NullProgressMonitor());
		massSpectrum = (IStandaloneMassSpectrum)processingInfo.getProcessingResult().getMassSpectrum(1);
	}

	@Test
	public void testDescription() {

		assertEquals("tiny", massSpectrum.getSampleName());
		assertEquals("MALDI", massSpectrum.getInstrument());
		assertEquals("root root@mq.de Laboraty Medicine", massSpectrum.getOperator());
	}

	@Test
	public void testSpectrum() {

		assertEquals(MassSpectrumType.PROFILE, massSpectrum.getMassSpectrumType());
		assertEquals(5, massSpectrum.getNumberOfIons());
		assertEquals(1, massSpectrum.getLowestAbundance().getIon());
		assertEquals(6, massSpectrum.getLowestAbundance().getAbundance());
		assertEquals(5, massSpectrum.getHighestAbundance().getIon());
		assertEquals(10, massSpectrum.getHighestAbundance().getAbundance());
	}
}
