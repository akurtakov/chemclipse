/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.ocx.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.eclipse.chemclipse.csd.converter.chromatogram.ChromatogramConverterCSD;
import org.eclipse.chemclipse.csd.model.core.IChromatogramCSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.xxd.converter.supplier.ocx.PathResolver;
import org.eclipse.chemclipse.xxd.converter.supplier.ocx.TestPathHelper;
import org.eclipse.chemclipse.xxd.converter.supplier.ocx.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.xxd.converter.supplier.ocx.versions.VersionConstants;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramReader_1_FID_1301_ITest {

	private IChromatogramCSD chromatogram;

	@BeforeAll
	public void setUp() {

		PreferenceSupplier.setForceLoadAlternateDetector(true);
		String pathImport = PathResolver.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_CHROMATOGRAM_1_MSD_1301);
		File fileImport = new File(pathImport);
		IProcessingInfo<IChromatogramCSD> processingInfo = ChromatogramConverterCSD.getInstance().convert(fileImport, VersionConstants.CONVERTER_ID_CHROMATOGRAM, new NullProgressMonitor());
		chromatogram = processingInfo.getProcessingResult();
	}

	@AfterAll
	public void tearDown() {

		PreferenceSupplier.setForceLoadAlternateDetector(false);
	}

	@Test
	public void testReader_1() {

		assertEquals(110, chromatogram.getNumberOfScans());
	}

	@Test
	public void testReader_2() {

		assertEquals("Chromatogram1-1301-fromMSD", chromatogram.getName());
	}

	@Test
	public void testReader_3() {

		assertEquals(841111, chromatogram.getStartRetentionTime());
	}

	@Test
	public void testReader_4() {

		assertEquals(918652, chromatogram.getStopRetentionTime());
	}

	@Test
	public void testReader_5() {

		assertEquals(442733.0f, chromatogram.getMaxSignal(), 0);
	}

	@Test
	public void testReader_6() {

		assertEquals(21543.0f, chromatogram.getMinSignal(), 0);
	}

	@Test
	public void testReader_7() {

		assertEquals(841111, chromatogram.getScanDelay());
	}

	@Test
	public void testReader_8() {

		assertEquals(710, chromatogram.getScanInterval());
	}
}
