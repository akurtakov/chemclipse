/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.msd.converter.supplier.matlab.parafac.PathResolver;
import org.eclipse.chemclipse.msd.converter.supplier.matlab.parafac.TestPathHelper;
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
public class MatlabParafacPeakImportConverter_1_ITest {

	private IPeaksMSD peaks;
	private IPeakMSD peak;
	private IExtractedIonSignal extractedIonSignal;
	private IPeakModelMSD peakModel;

	@BeforeAll
	public void setUp() {

		MatlabParafacPeakImportConverter converter = new MatlabParafacPeakImportConverter();
		File file = new File(PathResolver.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_MATLAB_PEAKS));
		IProcessingInfo<IPeaksMSD> processingInfo = converter.convert(file, new NullProgressMonitor());
		peaks = processingInfo.getProcessingResult();
		peak = peaks.getPeaks().get(0);
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

		assertEquals("PARAFAC model, 257820 to 276016 milliseconds, Peak 1", peak.getModelDescription());
	}

	@Test
	public void testPeaks_3() {

		assertEquals(50, extractedIonSignal.getStartIon());
	}

	@Test
	public void testPeaks_4() {

		assertEquals(446, extractedIonSignal.getStopIon());
	}

	@Test
	public void testPeaks_5() {

		assertEquals(0.00222065f, extractedIonSignal.getAbundance(50), 0);
	}

	@Test
	public void testPeaks_6() {

		assertEquals(6.46808e-005f, extractedIonSignal.getAbundance(446), 0);
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
