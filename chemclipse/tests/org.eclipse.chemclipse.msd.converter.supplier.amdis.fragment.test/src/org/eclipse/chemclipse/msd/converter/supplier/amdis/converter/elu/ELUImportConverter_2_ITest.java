/*******************************************************************************
 * Copyright (c) 2015, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Dr. Janos Binder - initial API and implementation
 * Alexander Kerner - Generics
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.amdis.converter.elu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.chemclipse.model.core.PeakType;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.TestPathHelper;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.io.ELUReader;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IPeakMSD;
import org.eclipse.chemclipse.msd.model.core.IPeakMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IPeaksMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ELUImportConverter_2_ITest {

	private ELUReader reader;
	private File file;

	@BeforeAll
	public void setUp() {

		reader = new ELUReader();
		file = new File(TestPathHelper.TESTFILE_IMPORT_PEAKS_1_ELU);
	}

	@Test
	public void testRead_1() throws IOException {

		IEclipsePreferences preferences = PreferenceSupplier.INSTANCE().getPreferences();
		preferences.putBoolean(PreferenceSupplier.P_EXCLUDE_UNCERTAIN_IONS, true);

		IProcessingInfo<IPeaksMSD> processingInfo = reader.read(file, new NullProgressMonitor());
		List<IPeakMSD> peaks = processingInfo.getProcessingResult().getPeaks();

		IPeakMSD peak1 = peaks.get(0);
		assertEquals(peak1.getPeakType(), PeakType.DD);

		IPeakMassSpectrum peakMassSpectrum1 = peak1.getPeakModel().getPeakMassSpectrum();
		List<IIon> ions1 = peakMassSpectrum1.getIons();

		IPeakMSD peak2 = peaks.get(1);
		IPeakMassSpectrum peakMassSpectrum2 = peak2.getPeakModel().getPeakMassSpectrum();
		List<IIon> ions2 = peakMassSpectrum2.getIons();

		IPeakMSD peak3 = peaks.get(2);
		IPeakMassSpectrum peakMassSpectrum3 = peak3.getPeakModel().getPeakMassSpectrum();
		List<IIon> ions3 = peakMassSpectrum3.getIons();

		IIon ion10 = ions1.get(0);
		assertEquals(28.0, ion10.getIon(), 0, "Ion 0-0");
		assertEquals(4492.783, ion10.getAbundance(), 1E-3, "Abundance 0-0");

		IIon ion11 = ions1.get(1);
		assertEquals(29.0, ion11.getIon(), 0, "Ion 0-1");
		assertEquals(76.45377, ion11.getAbundance(), 1E-5, "Abundance 0-1");

		IIon ion12 = ions1.get(2);
		assertEquals(32.0, ion12.getIon(), 0, "Ion 0-2");
		assertEquals(1218.7631, ion12.getAbundance(), 1E-4, "Abundance 0-2");

		IIon ion20 = ions2.get(0);
		assertEquals(16.0, ion20.getIon(), 0, "Ion 1-0");
		assertEquals(92493.41, ion20.getAbundance(), 1E-2, "Abundance 1-0");

		IIon ion21 = ions2.get(1);
		assertEquals(28.0, ion21.getIon(), 0, "Ion 1-5");
		assertEquals(7107762.5, ion21.getAbundance(), 1E-6, "Abundance 1-5");

		IIon ion22 = ions2.get(2);
		assertEquals(29.0, ion22.getIon(), 0, "Ion 1-2");
		assertEquals(56919.02, ion22.getAbundance(), 1E-2, "Abundance 1-2");

		IIon ion23 = ions2.get(3);
		assertEquals(32.0, ion23.getIon(), 0, "Ion 1-4");
		assertEquals(2106003.8, ion23.getAbundance(), 1E-1, "Abundance 1-4");

		IIon ion24 = ions2.get(4);
		assertEquals(34.0, ion24.getIon(), 0, "Ion 1-4");
		assertEquals(7114.8774, ion24.getAbundance(), 1E-4, "Abundance 1-4");

		IIon ion25 = ions2.get(5);
		assertEquals(40.0, ion25.getIon(), 0, "Ion 1-5");
		assertEquals(177871.94, ion25.getAbundance(), 1E-2, "Abundance 1-5");

		IIon ion30 = ions3.get(0);
		assertEquals(20.0, ion30.getIon(), 0, "Ion 2-0");
		assertEquals(4583.8853, ion30.getAbundance(), 1E-4, "Abundance 2-0");

		IIon ion31 = ions3.get(1);
		assertEquals(28.0, ion31.getIon(), 0, "Ion 2-1");
		assertEquals(4579301.5, ion31.getAbundance(), 1E-2, "Abundance 2-1");

		IIon ion32 = ions3.get(2);
		assertEquals(29.0, ion32.getIon(), 0, "Ion 2-2");
		assertEquals(45838.85, ion32.getAbundance(), 1E-2, "Abundance 2-2");
	}
}
