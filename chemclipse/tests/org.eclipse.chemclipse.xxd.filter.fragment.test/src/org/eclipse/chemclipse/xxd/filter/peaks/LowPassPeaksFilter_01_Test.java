/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.filter.peaks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.csd.model.core.IChromatogramCSD;
import org.eclipse.chemclipse.csd.model.core.selection.ChromatogramSelectionCSD;
import org.eclipse.chemclipse.csd.model.core.selection.IChromatogramSelectionCSD;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.chemclipse.processing.supplier.ProcessExecutionContext;
import org.eclipse.chemclipse.xxd.filter.peaks.settings.LowPassPeaksFilterSettings;
import org.eclipse.chemclipse.xxd.filter.peaks.settings.PeakFilterOption;
import org.eclipse.chemclipse.xxd.process.support.ProcessTypeSupport;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LowPassPeaksFilter_01_Test extends PeaksFilter {

	private ProcessExecutionContext processExecutionContext = new ProcessExecutionContext(new NullProgressMonitor(), new ProcessingInfo<>(), new ProcessTypeSupport());
	private IChromatogramCSD chromatogram;
	private IChromatogramSelectionCSD chromatogramSelection;

	@BeforeEach
	public void setUp() {

		chromatogram = getChromatogramCSD();
		chromatogramSelection = new ChromatogramSelectionCSD(chromatogram);
		assertEquals(5, chromatogram.getPeaks().size());
	}

	@Test
	public void test01a() {

		LowPassPeaksFilter filter = new LowPassPeaksFilter();
		LowPassPeaksFilterSettings settings = new LowPassPeaksFilterSettings();
		settings.setPeakFilterOption(PeakFilterOption.HEIGHT);
		settings.setNumberLowest(0);
		filter.filterPeaks(chromatogramSelection, settings, processExecutionContext);
		assertEquals(0, chromatogram.getPeaks().size());
	}

	@Test
	public void test01b() {

		LowPassPeaksFilter filter = new LowPassPeaksFilter();
		LowPassPeaksFilterSettings settings = new LowPassPeaksFilterSettings();
		settings.setPeakFilterOption(PeakFilterOption.AREA);
		settings.setNumberLowest(0);
		filter.filterPeaks(chromatogramSelection, settings, processExecutionContext);
		assertEquals(0, chromatogram.getPeaks().size());
	}

	@Test
	public void test02a() {

		LowPassPeaksFilter filter = new LowPassPeaksFilter();
		LowPassPeaksFilterSettings settings = new LowPassPeaksFilterSettings();
		settings.setPeakFilterOption(PeakFilterOption.HEIGHT);
		settings.setNumberLowest(1);
		filter.filterPeaks(chromatogramSelection, settings, processExecutionContext);
		assertEquals(1, chromatogram.getPeaks().size());
		assertEquals(500, chromatogram.getPeaks().get(0).getIntegratedArea());
	}

	@Test
	public void test02b() {

		LowPassPeaksFilter filter = new LowPassPeaksFilter();
		LowPassPeaksFilterSettings settings = new LowPassPeaksFilterSettings();
		settings.setPeakFilterOption(PeakFilterOption.AREA);
		settings.setNumberLowest(1);
		filter.filterPeaks(chromatogramSelection, settings, processExecutionContext);
		assertEquals(1, chromatogram.getPeaks().size());
		assertEquals(100, chromatogram.getPeaks().get(0).getIntegratedArea());
	}

	@Test
	public void test03a() {

		LowPassPeaksFilter filter = new LowPassPeaksFilter();
		LowPassPeaksFilterSettings settings = new LowPassPeaksFilterSettings();
		settings.setPeakFilterOption(PeakFilterOption.HEIGHT);
		settings.setNumberLowest(2);
		filter.filterPeaks(chromatogramSelection, settings, processExecutionContext);
		assertEquals(2, chromatogram.getPeaks().size());
		assertEquals(100, chromatogram.getPeaks().get(0).getIntegratedArea());
		assertEquals(500, chromatogram.getPeaks().get(1).getIntegratedArea());
	}

	@Test
	public void test03b() {

		LowPassPeaksFilter filter = new LowPassPeaksFilter();
		LowPassPeaksFilterSettings settings = new LowPassPeaksFilterSettings();
		settings.setPeakFilterOption(PeakFilterOption.AREA);
		settings.setNumberLowest(2);
		filter.filterPeaks(chromatogramSelection, settings, processExecutionContext);
		assertEquals(2, chromatogram.getPeaks().size());
		assertEquals(100, chromatogram.getPeaks().get(0).getIntegratedArea());
		assertEquals(200, chromatogram.getPeaks().get(1).getIntegratedArea());
	}

	@Test
	public void test04a() {

		LowPassPeaksFilter filter = new LowPassPeaksFilter();
		LowPassPeaksFilterSettings settings = new LowPassPeaksFilterSettings();
		settings.setPeakFilterOption(PeakFilterOption.HEIGHT);
		settings.setNumberLowest(6);
		filter.filterPeaks(chromatogramSelection, settings, processExecutionContext);
		assertEquals(5, chromatogram.getPeaks().size());
	}

	@Test
	public void test04b() {

		LowPassPeaksFilter filter = new LowPassPeaksFilter();
		LowPassPeaksFilterSettings settings = new LowPassPeaksFilterSettings();
		settings.setPeakFilterOption(PeakFilterOption.AREA);
		settings.setNumberLowest(6);
		filter.filterPeaks(chromatogramSelection, settings, processExecutionContext);
		assertEquals(5, chromatogram.getPeaks().size());
	}
}