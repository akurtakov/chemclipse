/*******************************************************************************
 * Copyright (c) 2025, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.jcampdx;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import org.eclipse.chemclipse.model.core.IComplexSignalMeasurement;
import org.eclipse.chemclipse.nmr.converter.supplier.jcampdx.converter.ScanImportConverterNMR;
import org.eclipse.chemclipse.nmr.model.core.ISpectrumNMR;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class BrukerAFFN_ITest {

	private IComplexSignalMeasurement<?> complexSignalMeasurement;

	@BeforeAll
	public void setUp() {

		File file = new File("testData/BRUKAFFN.DX");
		ScanImportConverterNMR importConverter = new ScanImportConverterNMR();
		IProcessingInfo<ISpectrumNMR> processingInfo = importConverter.convert(file, new NullProgressMonitor());
		complexSignalMeasurement = processingInfo.getProcessingResult().getComplexSignalMeasurements().iterator().next();
	}

	@Test
	public void testLoading() {

		assertNotNull(complexSignalMeasurement);
	}

	@Test
	public void testSignals() {

		assertEquals(16754, complexSignalMeasurement.getSignals().size());
	}
}
