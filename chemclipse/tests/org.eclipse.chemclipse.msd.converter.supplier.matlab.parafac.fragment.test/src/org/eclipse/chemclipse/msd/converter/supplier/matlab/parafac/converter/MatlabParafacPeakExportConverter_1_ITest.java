/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.matlab.parafac.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.eclipse.chemclipse.msd.model.core.IPeakMSD;
import org.eclipse.chemclipse.msd.model.core.IPeakMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IPeakModelMSD;
import org.eclipse.chemclipse.msd.model.core.IPeaksMSD;
import org.eclipse.chemclipse.msd.model.xic.IExtractedIonSignal;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MatlabParafacPeakExportConverter_1_ITest {

	private IPeaksMSD peaks;
	private IPeakMSD peak;
	private IExtractedIonSignal extractedIonSignal;
	private IPeakModelMSD peakModel;

	@BeforeAll
	public void setUp() {

		/*
		 * Import
		 */
		MatlabParafacPeakImportConverter importConverter = new MatlabParafacPeakImportConverter();
		File importFile = new File("testData/files/import/matlab-peaks.mpl");
		IProcessingInfo<IPeaksMSD> importProcessingInfo = importConverter.convert(importFile, new NullProgressMonitor());
		peaks = importProcessingInfo.getProcessingResult();
		/*
		 * Export
		 */
		MatlabParafacPeakExportConverter exportConverter = new MatlabParafacPeakExportConverter();
		File exportFile = new File(new File("testData/files/export"), File.separator + "matlab-peaks.mpl");
		IProcessingInfo<File> exportProcessingInfo = exportConverter.convert(exportFile, peaks, false, new NullProgressMonitor());
		exportProcessingInfo.getProcessingResult();
		/*
		 * Re-Import
		 */
		importConverter = new MatlabParafacPeakImportConverter();
		File reimportFile = new File(new File("testData/files/export"), File.separator + "matlab-peaks.mpl");
		importProcessingInfo = importConverter.convert(reimportFile, new NullProgressMonitor());
		peaks = importProcessingInfo.getProcessingResult();
		peak = peaks.getPeaks().get(1);
		IPeakMassSpectrum peakMassSpectrum = peak.getExtractedMassSpectrum();
		extractedIonSignal = peakMassSpectrum.getExtractedIonSignal();
		peakModel = peak.getPeakModel();
	}

	@Test
	public void testPeaks_1() {

		assertEquals(3, peaks.getPeaks().size());
	}

	@Test
	public void testPeaks_2() {

		assertEquals("PARAFAC model, 257820 to 276016 milliseconds, Peak 2", peak.getModelDescription());
	}

	@Test
	public void testPeaks_3() {

		assertEquals(50, extractedIonSignal.getStartIon());
	}

	@Test
	public void testPeaks_4() {

		assertEquals(302, extractedIonSignal.getStopIon());
	}

	@Test
	public void testPeaks_5() {

		assertEquals(0.00225118f, extractedIonSignal.getAbundance(50), 0);
	}

	@Test
	public void testPeaks_6() {

		assertEquals(0.000246839f, extractedIonSignal.getAbundance(302), 0);
	}

	@Test
	public void testPeaks_7() {

		assertEquals(257820, peakModel.getStartRetentionTime());
	}

	@Test
	public void testPeaks_8() {

		assertEquals(276016, peakModel.getStopRetentionTime());
	}
}
