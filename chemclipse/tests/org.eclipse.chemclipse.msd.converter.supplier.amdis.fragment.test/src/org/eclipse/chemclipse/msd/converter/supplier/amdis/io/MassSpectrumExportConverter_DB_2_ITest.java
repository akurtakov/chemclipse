/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Alexander Kerner - Generics
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.amdis.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.MassSpectra;
import org.eclipse.chemclipse.msd.model.implementation.ScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MassSpectrumExportConverter_DB_2_ITest extends MassSpectrumExportConverterTestCase {

	@Override
	@BeforeAll
	public void setUp() {

		File exportFolder = new File("testData/files/export");
		exportFile = new File(exportFolder, File.separator + "DB1.msl");
		importFile = new File(exportFolder, File.separator + "DB1.msl");
		super.setUp();
	}

	@Override
	@AfterAll
	public void tearDown() {

		super.tearDown();
	}

	@Test
	public void testExport_1() {

		IIon ion;
		IScanMSD ms;
		massSpectra = new MassSpectra();
		for(int i = 1; i <= 3; i++) {
			ms = new ScanMSD();
			for(int j = 1; j <= 6; j++) {
				ion = new Ion(j * i, j * i * 10);
				ms.addIon(ion);
			}
			massSpectra.addMassSpectrum(ms);
		}
		assertEquals(3, massSpectra.size(), "Size before");
		exportConverter.convert(exportFile, massSpectra, false, new NullProgressMonitor());
		IProcessingInfo<?> processingInfo = importConverter.convert(importFile, new NullProgressMonitor());
		massSpectra = (IMassSpectra)processingInfo.getProcessingResult();
		assertEquals(3, massSpectra.size(), "Size after");
	}
}
