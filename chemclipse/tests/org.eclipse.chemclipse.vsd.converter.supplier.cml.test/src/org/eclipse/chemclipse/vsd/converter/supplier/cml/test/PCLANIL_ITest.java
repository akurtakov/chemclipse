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
 * Philip Wenig - refactoring vibrational spectroscopy
 *******************************************************************************/
package org.eclipse.chemclipse.vsd.converter.supplier.cml.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.vsd.converter.supplier.cml.converter.ScanImportConverter;
import org.eclipse.chemclipse.vsd.converter.supplier.cml.model.IVendorSpectrumVSD;
import org.eclipse.chemclipse.vsd.model.core.ISpectrumVSD;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PCLANIL_ITest {

	private ISpectrumVSD spectrumVSD;

	@BeforeAll
	public void setUp() throws IOException {

		File file = new File(TestPathHelper.PCLANIL);
		ScanImportConverter importConverter = new ScanImportConverter();
		IProcessingInfo<ISpectrumVSD> processingInfo = importConverter.convert(file, new NullProgressMonitor());
		spectrumVSD = processingInfo.getProcessingResult();
	}

	@Test
	public void testLoading() {

		assertNotNull(spectrumVSD);
		assertEquals("para-chloroaniline", spectrumVSD.getSampleName());
		assertEquals("IR_para-chlor", spectrumVSD.getDataName());
		assertEquals("PERKIN-ELMER 1000 FT-IR", spectrumVSD.getInstrument());
		if(spectrumVSD instanceof IVendorSpectrumVSD vendorSpectrumVSD) {
			assertEquals("C6H6ClN", vendorSpectrumVSD.getFormula());
			assertEquals("106-47-8", vendorSpectrumVSD.getCasNumber());
		}
	}

	@Test
	public void testSignals() {

		assertEquals(1801, spectrumVSD.getScanVSD().getProcessedSignals().size());
	}
}
