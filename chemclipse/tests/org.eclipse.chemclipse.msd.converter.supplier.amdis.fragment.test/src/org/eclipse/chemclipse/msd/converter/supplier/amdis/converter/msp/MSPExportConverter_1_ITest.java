/*******************************************************************************
 * Copyright (c) 2012, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.amdis.converter.msp;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.eclipse.chemclipse.msd.converter.database.IDatabaseExportConverter;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.TestPathHelper;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.MassSpectra;
import org.eclipse.chemclipse.msd.model.implementation.ScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MSPExportConverter_1_ITest {

	private IDatabaseExportConverter exportConverter;
	private File exportFile;
	private IScanMSD massSpectrum;
	private IMassSpectra massSpectra;

	@BeforeAll
	public void setUp() {

		exportConverter = new MSPDatabaseExportConverter();
		File exportFolder = new File(TestPathHelper.TESTDIR_EXPORT);
		exportFile = new File(exportFolder, File.separator + TestPathHelper.TESTFILE_EXPORT_DB_MSP);
		massSpectrum = new ScanMSD();
		massSpectrum.addIon(new Ion(56.3f, 7382.3f));
		massSpectrum.addIon(new Ion(26.3f, 73382.3f));
		massSpectrum.addIon(new Ion(89.3f, 382.3f));
		massSpectra = new MassSpectra();
		massSpectra.addMassSpectrum(massSpectrum);
	}

	@Test
	public void testExport_1() {

		IProcessingInfo<File> processingInfo = exportConverter.convert(null, massSpectrum, false, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
	}

	@Test
	public void testExport_2() {

		massSpectrum = null;
		IProcessingInfo<File> processingInfo = exportConverter.convert(exportFile, massSpectrum, false, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
	}

	@Test
	public void testExport_3() {

		massSpectra = null;
		IProcessingInfo<File> processingInfo = exportConverter.convert(exportFile, massSpectra, false, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
	}

	@Test
	public void testExport_4() {

		exportFile.setWritable(false);
		IProcessingInfo<File> processingInfo = exportConverter.convert(exportFile, massSpectra, false, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
		exportFile.setWritable(true);
	}
}
