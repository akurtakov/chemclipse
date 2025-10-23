/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.splitter.core;

import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.msd.filter.core.chromatogram.AbstractChromatogramFilterMSD;
import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.splitter.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.splitter.settings.FilterSettingsHighResMS;
import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.splitter.settings.FilterSettingsNominalMS;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.support.ChromatogramSupport;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.RegularMassSpectrum;
import org.eclipse.chemclipse.msd.model.xic.IExtractedIonSignal;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramFilterNominalMS extends AbstractChromatogramFilterMSD {

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelectionMSD chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> validation = validate(chromatogramSelection, chromatogramFilterSettings);
		IProcessingInfo<IChromatogramFilterResult> processingInfo = new ProcessingInfo<>();
		processingInfo.addMessages(validation);

		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramFilterSettings instanceof FilterSettingsNominalMS filterSettings) {
				IChromatogram chromatogram = chromatogramSelection.getChromatogram();
				if(chromatogram instanceof IChromatogramMSD chromatogramMSD) {
					int startRetentionTime = chromatogramSelection.getStartRetentionTime();
					int stopRetentionTime = chromatogramSelection.getStopRetentionTime();
					boolean enforceFullTimeRange = filterSettings.isEnforceFullTimeRange();

					/*
					 * All Traces / Nominalize
					 */
					IChromatogramMSD chromatogramReferenceMSD = new ChromatogramMSD();
					for(IScan scan : chromatogramMSD.getScans()) {
						if(useScan(scan, enforceFullTimeRange, startRetentionTime, stopRetentionTime)) {
							if(scan instanceof IScanMSD scanMSD) {
								RegularMassSpectrum scanReferenceMSD = new RegularMassSpectrum();
								scanReferenceMSD.setRetentionTime(scanMSD.getRetentionTime());
								IExtractedIonSignal extractedIonSignal = scanMSD.getExtractedIonSignal();
								int start = extractedIonSignal.getStartIon();
								int stop = extractedIonSignal.getStopIon();
								for(int mz = start; mz <= stop; mz++) {
									float intensity = extractedIonSignal.getAbundance(mz);
									if(intensity > 0) {
										scanReferenceMSD.addIon(new Ion(mz, intensity));
									}
								}
								chromatogramReferenceMSD.addScan(scanReferenceMSD);
							}
						}
					}
					/*
					 * 
					 */
					ChromatogramSupport.calculateScanIntervalAndDelay(chromatogramReferenceMSD);
					chromatogramMSD.addReferencedChromatogram(chromatogramReferenceMSD);
				}

				chromatogramSelection.getChromatogram().setDirty(true);
				processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, "The chromatogram was splitted into nominal reference chromatograms."));
			} else {
				processingInfo.addWarnMessage("Splitter (Nominal MS)", "The filter settings are not of type: " + FilterSettingsHighResMS.class);
			}
		}

		return processingInfo;
	}

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelectionMSD chromatogramSelection, IProgressMonitor monitor) {

		FilterSettingsNominalMS splitterSettings = PreferenceSupplier.getFilterSettingsNominalMS();
		return applyFilter(chromatogramSelection, splitterSettings, monitor);
	}

	private boolean useScan(IScan scan, boolean enforceFullTimeRange, int startRetentionTime, int stopRetentionTime) {

		if(enforceFullTimeRange) {
			return true;
		} else {
			int retentionTime = scan.getRetentionTime();
			if(retentionTime >= startRetentionTime && retentionTime <= stopRetentionTime) {
				return true;
			}
		}

		return false;
	}
}