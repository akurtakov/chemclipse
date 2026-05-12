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
package org.eclipse.chemclipse.wsd.converter.supplier.cml.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.time.ZoneId;

import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.wsd.converter.supplier.spectroml.converter.ScanImportConverter;
import org.eclipse.chemclipse.wsd.converter.supplier.spectroml.model.IVendorSpectrumWSD;
import org.eclipse.chemclipse.wsd.model.core.ISpectrumWSD;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class SpectroML_ITest {

	private ISpectrumWSD spectrumWSD;

	@BeforeAll
	public void setUp() throws IOException {

		File file = new File("testData/SpectroML.xml");
		ScanImportConverter importConverter = new ScanImportConverter();
		IProcessingInfo<ISpectrumWSD> processingInfo = importConverter.convert(file, new NullProgressMonitor());
		spectrumWSD = processingInfo.getProcessingResult();
	}

	@Test
	public void testLoading() {

		assertNotNull(spectrumWSD);
	}

	@Test
	public void testMetadata() {

		assertEquals("sample experiment", spectrumWSD.getDataName());
		assertEquals("simple measurement of drinking water", spectrumWSD.getDetailedInfo());
		assertEquals("HP 8453", spectrumWSD.getInstrument());
		assertEquals(2000, spectrumWSD.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().getYear());
		assertEquals("Paul DeRose", spectrumWSD.getOperator());
		assertEquals("1063546374", spectrumWSD.getBarcode());
		assertEquals("water", spectrumWSD.getSampleName());
		if(spectrumWSD instanceof IVendorSpectrumWSD vendorSpectrumWSD) {
			assertEquals("7732-18-5", vendorSpectrumWSD.getCasNumber());
			assertEquals("H2O", vendorSpectrumWSD.getFormula());
		}
	}

	@Test
	public void testSignals() {

		assertEquals(3, spectrumWSD.getSignals().size());
	}
}