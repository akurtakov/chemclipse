/*******************************************************************************
 * Copyright (c) 2026 Aleksandar Kurtakov and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Aleksandar Kurtakov - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.ui.support;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.xxd.process.ui.menu.IMenuIcon;

/**
 * The menu icons of the ChemClipse processors by process supplier id.
 * Other plug-ins contribute theirs via {@link IMenuIcon#EXTENSION_POINT_ID}.
 */
final class MenuIcons {

	static final Map<String, String> IMAGES = new HashMap<>();

	static {
		IMAGES.put("org.eclipse.chemclipse.chromatogram.csd.filter.supplier.savitzkygolay", IApplicationImage.IMAGE_FILTER_SAVITZKY_GOLAY);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.csd.filter.supplier.zeroset", IApplicationImage.IMAGE_CHROMATOGRAM_ZERO_SET);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.csd.identifier.supplier.unknown.peak", IApplicationImage.IMAGE_UNKNOWN);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.csd.peak.detector.supplier.firstderivative", IApplicationImage.IMAGE_PEAK_DETECTOR);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.filter.resetChromatogramSelection", IApplicationImage.IMAGE_UNZOOM);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.filter.setChromatogramSelection", IApplicationImage.IMAGE_EXECUTE_ADD);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc", IApplicationImage.IMAGE_CLASSIFIER_WNC);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.filter.supplier.backfolding", IApplicationImage.IMAGE_FILTER_BACKFOLDING);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.filter.supplier.coda", IApplicationImage.IMAGE_FILTER_CODA);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.filter.supplier.denoising", IApplicationImage.IMAGE_FILTER_DENOISING);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.filter.supplier.savitzkygolay", IApplicationImage.IMAGE_FILTER_SAVITZKY_GOLAY);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.filter.supplier.savitzkygolay.massspectrum", IApplicationImage.IMAGE_FILTER_SAVITZKY_GOLAY);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.filter.supplier.snip.peak", IApplicationImage.IMAGE_FILTER_SNIP_ALL_PEAKS);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.filter.supplier.subtract.chromatogram", IApplicationImage.IMAGE_SUBTRACT_SCAN_DEFAULT);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.filter.supplier.subtract.massspectrum", IApplicationImage.IMAGE_SUBTRACT_SCAN_DEFAULT);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.filter.supplier.subtract.peak", IApplicationImage.IMAGE_SUBTRACT_SCAN_DEFAULT);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.identifier.supplier.file.massSpectrum", IApplicationImage.IMAGE_MASS_SPECTRUM_FILE);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.identifier.supplier.file.peak", IApplicationImage.IMAGE_MASS_SPECTRUM_FILE);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.identifier.supplier.unknown.massSpectrum", IApplicationImage.IMAGE_UNKNOWN);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.identifier.supplier.unknown.peak", IApplicationImage.IMAGE_UNKNOWN);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.integrator.supplier.peakmax.peakIntegrator", IApplicationImage.IMAGE_PEAK_INTEGRATOR_MAX);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.integrator.supplier.sumarea.chromatogramIntegrator", IApplicationImage.IMAGE_INTEGRATOR_SUMAREA);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.msd.peak.detector.supplier.firstderivative", IApplicationImage.IMAGE_PEAK_DETECTOR);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.wsd.filter.supplier.savitzkygolay", IApplicationImage.IMAGE_FILTER_SAVITZKY_GOLAY);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.wsd.filter.supplier.zeroset", IApplicationImage.IMAGE_CHROMATOGRAM_ZERO_SET);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.wsd.identifier.supplier.unknown.peak", IApplicationImage.IMAGE_UNKNOWN);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.wsd.identifier.supplier.unknown.waveSpectrum", IApplicationImage.IMAGE_UNKNOWN);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.wsd.peak.detector.supplier.firstderivative", IApplicationImage.IMAGE_PEAK_DETECTOR);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.impl.delete", IApplicationImage.IMAGE_BASELINE_DELETE);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.supplier.snip", IApplicationImage.IMAGE_BASELINE_SNIP);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.calculator.column.chromatogramColumnParser", IApplicationImage.IMAGE_COLUMN);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.calculator.noise.ChromatogramClassifierSupplier", IApplicationImage.IMAGE_PREFERENCES);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.calculator.noise.noiseSegmentSetter", IApplicationImage.IMAGE_PREFERENCES);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.calculator.peak.resolution", IApplicationImage.IMAGE_PEAKS);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri", IApplicationImage.IMAGE_RETENION_INDEX);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.chromatogram.cal", IApplicationImage.IMAGE_SAMPLE_CALIBRATION);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.resetri", IApplicationImage.IMAGE_RESET);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.retentionindex", IApplicationImage.IMAGE_RETENION_INDEX);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.retentionindexassigner", IApplicationImage.IMAGE_IMPORT);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.classifier.supplier.durbinwatson", IApplicationImage.IMAGE_CLASSIFIER_DW);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.meannormalizer", IApplicationImage.IMAGE_FILTER_MEAN_NORMALIZER);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.mediannormalizer", IApplicationImage.IMAGE_FILTER_MEDIAN_NORMALIZER);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.normalizer", IApplicationImage.IMAGE_FILTER_SAVITZKY_GOLAY);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scandensity", IApplicationImage.IMAGE_FILTER_SCAN_DENSITY);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scanremover", IApplicationImage.IMAGE_FILTER_SCANREMOVER);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.unitsumnormalizer", IApplicationImage.IMAGE_FILTER_UNITSUM_NORMALIZER);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.chromatogram", IApplicationImage.IMAGE_MASS_SPECTRUM_FILE);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.integrator.supplier.trapezoid.chromatogramIntegrator", IApplicationImage.IMAGE_CHROMATOGRAM_INTEGRATOR);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.integrator.supplier.trapezoid.combinedIntegrator", IApplicationImage.IMAGE_COMBINED_INTEGRATOR);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.integrator.supplier.trapezoid.peakIntegrator", IApplicationImage.IMAGE_PEAK_INTEGRATOR);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.peak.detector.supplier.truyols", IApplicationImage.IMAGE_PEAK_DETECTOR);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.quantitation.supplier.chemclipse.peak.istd", IApplicationImage.IMAGE_INTERNAL_STANDARDS_DEFAULT);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.report.supplier.pdf", IApplicationImage.IMAGE_PDF);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.report.supplier.txt.areapercent", IApplicationImage.IMAGE_INTEGRATION_RESULTS);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.report.supplier.txt.peaksidentifications", IApplicationImage.IMAGE_TARGETS);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.report.supplier.txt.peaktable", IApplicationImage.IMAGE_PEAKS);
		IMAGES.put("org.eclipse.chemclipse.chromatogram.xxd.report.supplier.txt.quantitation", IApplicationImage.IMAGE_QUANTITATION_RESULTS);
		IMAGES.put("org.eclipse.chemclipse.msd.classifier.supplier.molpeak", IApplicationImage.IMAGE_CLASSIFIER);
		IMAGES.put("org.eclipse.chemclipse.msd.converter.supplier.amdis.chromatogram", IApplicationImage.IMAGE_NIST_PEAKS);
		IMAGES.put("org.eclipse.chemclipse.msd.converter.supplier.amdis.chromatogram.combined.msl", IApplicationImage.IMAGE_MASS_SPECTRUM_LIBRARY);
		IMAGES.put("org.eclipse.chemclipse.msd.converter.supplier.csv", IApplicationImage.IMAGE_CSV);
		IMAGES.put("org.eclipse.chemclipse.msd.converter.supplier.csv.heatmap", IApplicationImage.IMAGE_HEATMAP_DEFAULT);
		IMAGES.put("org.eclipse.chemclipse.msd.converter.supplier.excel", IApplicationImage.IMAGE_EXCEL_DOCUMENT);
		IMAGES.put("org.eclipse.chemclipse.msd.converter.supplier.mzdata", IApplicationImage.IMAGE_XML_FILE);
		IMAGES.put("org.eclipse.chemclipse.msd.converter.supplier.mzdata.ms", IApplicationImage.IMAGE_XML_FILE);
		IMAGES.put("org.eclipse.chemclipse.msd.converter.supplier.mzml", IApplicationImage.IMAGE_XML_FILE);
		IMAGES.put("org.eclipse.chemclipse.msd.converter.supplier.mzml.ms", IApplicationImage.IMAGE_XML_FILE);
		IMAGES.put("org.eclipse.chemclipse.msd.converter.supplier.mzxml", IApplicationImage.IMAGE_XML_FILE);
		IMAGES.put("org.eclipse.chemclipse.msd.converter.supplier.mzxml.ms", IApplicationImage.IMAGE_XML_FILE);
		IMAGES.put("org.eclipse.chemclipse.msd.filter.supplier.baseline.subtract", IApplicationImage.IMAGE_BASELINE);
		IMAGES.put("org.eclipse.chemclipse.msd.filter.supplier.normalizer", IApplicationImage.IMAGE_FILTER_NORMALIZER);
		IMAGES.put("org.eclipse.chemclipse.msd.filter.supplier.trim", IApplicationImage.IMAGE_FILTER_CUT);
		IMAGES.put("org.eclipse.chemclipse.msd.identifier.supplier.nist.massSpectrum", IApplicationImage.IMAGE_NIST);
		IMAGES.put("org.eclipse.chemclipse.msd.identifier.supplier.nist.massSpectrumDirect", IApplicationImage.IMAGE_NIST);
		IMAGES.put("org.eclipse.chemclipse.msd.identifier.supplier.nist.peak", IApplicationImage.IMAGE_NIST);
		IMAGES.put("org.eclipse.chemclipse.pcr.converter.supplier.rdml", IApplicationImage.IMAGE_XML_FILE);
		IMAGES.put("org.eclipse.chemclipse.pcr.report.supplier.tabular.csv", IApplicationImage.IMAGE_CSV);
		IMAGES.put("org.eclipse.chemclipse.pcr.report.supplier.tabular.excel", IApplicationImage.IMAGE_EXCEL);
		IMAGES.put("org.eclipse.chemclipse.pcr.report.supplier.txt", IApplicationImage.IMAGE_TXT);
		IMAGES.put("org.eclipse.chemclipse.xxd.filter.chromatogram.peakTargetTransfer", IApplicationImage.IMAGE_TARGETS);
		IMAGES.put("org.eclipse.chemclipse.xxd.filter.peaks.DeleteIntegrationsFilter", IApplicationImage.IMAGE_DELETE_PEAK_INTEGRATIONS);
		IMAGES.put("org.eclipse.chemclipse.xxd.filter.peaks.DeletePeaksFilter", IApplicationImage.IMAGE_DELETE_PEAKS);
		IMAGES.put("org.eclipse.chemclipse.xxd.filter.peaks.DeleteTargetsFilter", IApplicationImage.IMAGE_DELETE_PEAK_IDENTIFICATIONS);
	}

	private MenuIcons() {

	}
}
