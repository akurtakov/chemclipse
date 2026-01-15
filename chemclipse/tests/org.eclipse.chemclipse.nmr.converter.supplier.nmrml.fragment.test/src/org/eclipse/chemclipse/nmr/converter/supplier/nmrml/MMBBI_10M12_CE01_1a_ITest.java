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
package org.eclipse.chemclipse.nmr.converter.supplier.nmrml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.model.core.IComplexSignalMeasurement;
import org.eclipse.chemclipse.nmr.converter.supplier.nmrml.converter.ScanImportConverter;
import org.eclipse.chemclipse.nmr.model.core.ISpectrumNMR;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MMBBI_10M12_CE01_1a_ITest {

	private ISpectrumNMR spectrumNMR;

	@BeforeAll
	public void setUp() throws IOException {

		File file = new File(TestPathHelper.MMBBI_10M12_CE01_1a);
		ScanImportConverter importConverter = new ScanImportConverter();
		IProcessingInfo<ISpectrumNMR> processingInfo = importConverter.convert(file, new NullProgressMonitor());
		spectrumNMR = processingInfo.getProcessingResult();
	}

	@Test
	public void testLoading() {

		assertNotNull(spectrumNMR);
		assertFalse(spectrumNMR.getComplexSignalMeasurements().isEmpty());
	}

	@Test
	public void testMeasuremnt() {

		IComplexSignalMeasurement<?> measurement = spectrumNMR.getComplexSignalMeasurements().iterator().next();
		assertEquals("mica", measurement.getOperator());
		assertEquals(8459, measurement.getSignals().size());
	}
}