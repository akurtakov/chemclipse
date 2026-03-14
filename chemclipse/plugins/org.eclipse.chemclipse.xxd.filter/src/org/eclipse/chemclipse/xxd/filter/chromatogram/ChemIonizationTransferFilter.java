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
package org.eclipse.chemclipse.xxd.filter.chromatogram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.core.support.PeakSupport;
import org.eclipse.chemclipse.model.identifier.ComparisonResult;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.model.identifier.LibraryInformation;
import org.eclipse.chemclipse.model.implementation.IdentificationTarget;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.model.supplier.IChromatogramSelectionProcessSupplier;
import org.eclipse.chemclipse.model.support.LimitSupport;
import org.eclipse.chemclipse.model.support.RetentionIndexMap;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IPeakMSD;
import org.eclipse.chemclipse.msd.model.core.IPeakMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IPeakModelMSD;
import org.eclipse.chemclipse.msd.model.core.ReagentGas;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.xic.IExtractedIonSignal;
import org.eclipse.chemclipse.processing.DataCategory;
import org.eclipse.chemclipse.processing.core.ICategories;
import org.eclipse.chemclipse.processing.supplier.AbstractProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessTypeSupplier;
import org.eclipse.chemclipse.processing.supplier.ProcessExecutionContext;
import org.eclipse.chemclipse.xxd.filter.chromatogram.settings.ChemIonizationTransferFilterSettings;
import org.eclipse.chemclipse.xxd.filter.core.PeakTransferCalculator;
import org.eclipse.chemclipse.xxd.filter.model.CoordinateOption;
import org.osgi.service.component.annotations.Component;

@Component(service = {IProcessTypeSupplier.class})
public class ChemIonizationTransferFilter implements IProcessTypeSupplier {

	private static final String ID = "org.eclipse.chemclipse.xxd.filter.chromatogram.chemIonizationTargetTransfer";
	private static final String NAME = "Chemical Ionization Transfer";
	private static final String DESCRIPTION = "Transfers the chemical ionization (CI) molecular peak to the references.";

	@Override
	public String getCategory() {

		return ICategories.PEAK_IDENTIFIER;
	}

	@Override
	public Collection<IProcessSupplier<?>> getProcessorSuppliers() {

		return Collections.singleton(new ProcessSupplier(this));
	}

	private static final class ProcessSupplier extends AbstractProcessSupplier<ChemIonizationTransferFilterSettings> implements IChromatogramSelectionProcessSupplier<ChemIonizationTransferFilterSettings> {

		public ProcessSupplier(IProcessTypeSupplier parent) {

			super(ID, NAME, DESCRIPTION, ChemIonizationTransferFilterSettings.class, parent, DataCategory.MSD);
		}

		@Override
		public IChromatogramSelection apply(IChromatogramSelection chromatogramSelection, ChemIonizationTransferFilterSettings processSettings, ProcessExecutionContext context) throws InterruptedException {

			IChromatogram chromatogram = chromatogramSelection.getChromatogram();
			if(chromatogram instanceof IChromatogramMSD) {
				/*
				 * Settings
				 */
				PeakTransferCalculator peakTransferCalculator = new PeakTransferCalculator();
				CoordinateOption coordinateOption = processSettings.getCoordinateOption();
				boolean useRetentionIndex = CoordinateOption.RETENTION_INDEX.equals(coordinateOption);
				RetentionIndexMap retentionIndexMap = useRetentionIndex ? new RetentionIndexMap(chromatogram) : null;
				int coordinateOffset = CoordinateOption.RETENTION_TIME_MIN.equals(coordinateOption) ? (int)Math.round(processSettings.getCoordinateOffset() * IChromatogramOverview.MINUTE_CORRELATION_FACTOR) : (int)Math.round(processSettings.getCoordinateOffset());
				ReagentGas reagentGas = processSettings.getReagentGas();
				/*
				 * Select the relevant source peaks.
				 */
				List<? extends IPeak> sourcePeaks = peakTransferCalculator.getSourcePeaks(chromatogramSelection);
				for(IChromatogram referenceChromatogram : chromatogram.getReferencedChromatograms()) {
					if(referenceChromatogram instanceof IChromatogramMSD) {
						for(IPeak sourcePeak : sourcePeaks) {
							if(sourcePeak instanceof IPeakMSD sourcePeakMSD) {
								List<IPeak> sinkPeaks = peakTransferCalculator.getSinkPeaks(sourcePeak, coordinateOffset, retentionIndexMap, referenceChromatogram);
								if(!sinkPeaks.isEmpty()) {
									IPeak sinkPeak = PeakSupport.selectNearestPeak(sinkPeaks, sourcePeak, useRetentionIndex);
									if(sinkPeak != null) {
										if(LimitSupport.doIdentify(sinkPeak.getTargets(), processSettings.getLimitMatchFactor())) {
											/*
											 * Get m/z and apply reagent gas mass shift.
											 */
											IPeakModelMSD peakModelMSD = sourcePeakMSD.getPeakModel();
											IPeakMassSpectrum peakMassSpectrum = peakModelMSD.getPeakMassSpectrum();
											IExtractedIonSignal extractedIonSignal = peakMassSpectrum.getExtractedIonSignal();
											int start = extractedIonSignal.getStartIon();
											int stop = extractedIonSignal.getStopIon();
											List<IIon> ions = new ArrayList<>();
											for(int ion = start; ion <= stop; ion++) {
												float intensity = extractedIonSignal.getAbundance(ion);
												if(intensity > 0) {
													ions.add(new Ion(ion, intensity));
												}
											}
											/*
											 * Transfer highest to lowest intensity
											 */
											int matchQuality = processSettings.getMatchQuality() == 0 ? 100 : (int)processSettings.getMatchQuality();
											Collections.sort(ions, (i1, i2) -> Float.compare(i2.getAbundance(), i1.getAbundance()));
											for(IIon ion : ions) {
												if(matchQuality >= 1) {
													int mz = (int)ion.getIon();
													int molecularWeight = mz - reagentGas.massShift();
													ILibraryInformation libraryInformation = new LibraryInformation();
													libraryInformation.setName("Chemical Ionization (" + mz + ") " + reagentGas.label());
													libraryInformation.setMolWeight(molecularWeight);
													ComparisonResult comparisonResult = new ComparisonResult(matchQuality);
													IIdentificationTarget identificationTarget = new IdentificationTarget(libraryInformation, comparisonResult);
													sinkPeak.getTargets().add(identificationTarget);
													matchQuality--;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}

			return chromatogramSelection;
		}
	}
}