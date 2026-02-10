/*******************************************************************************
 * Copyright (c) 2019, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.identifier;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.csd.identifier.support.TargetBuilderCSD;
import org.eclipse.chemclipse.chromatogram.wsd.identifier.support.TargetBuilderWSD;
import org.eclipse.chemclipse.csd.model.core.IPeakCSD;
import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.identifier.IIdentificationResult;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.identifier.IPeakIdentificationResults;
import org.eclipse.chemclipse.model.identifier.PeakIdentificationResults;
import org.eclipse.chemclipse.model.implementation.IdentificationResult;
import org.eclipse.chemclipse.model.support.LimitSupport;
import org.eclipse.chemclipse.model.targets.TargetUnknownSettings;
import org.eclipse.chemclipse.msd.identifier.support.TargetBuilderMSD;
import org.eclipse.chemclipse.msd.model.core.IPeakMSD;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.wsd.model.core.IPeakWSD;
import org.eclipse.chemclipse.wsd.model.core.IScanWSD;

public class UnknownIdentifier {

	public static final String IDENTIFIER = "Unknown Identifier";

	private static final TargetBuilderMSD TARGETBUILDER_MSD = new TargetBuilderMSD();
	private static final TargetBuilderCSD TARGETBUILDER_CSD = new TargetBuilderCSD();
	private static final TargetBuilderWSD TARGETBUILDER_WSD = new TargetBuilderWSD();

	public IPeakIdentificationResults runIdentificationPeak(List<? extends IPeak> peaks, float limitMatchFactor, TargetUnknownSettings targetUnknownSettings) {

		IPeakIdentificationResults peakIdentificationResults = new PeakIdentificationResults();

		for(IPeak peak : peaks) {
			IIdentificationResult identificationResult = new IdentificationResult();
			if(LimitSupport.doIdentify(peak.getTargets(), limitMatchFactor)) {
				IIdentificationTarget identificationTarget = null;
				if(peak instanceof IPeakMSD peakMSD) {
					identificationTarget = TARGETBUILDER_MSD.setPeakTargetUnknown(peakMSD, IDENTIFIER, targetUnknownSettings);
				} else if(peak instanceof IPeakCSD peakCSD) {
					identificationTarget = TARGETBUILDER_CSD.setPeakTargetUnknown(peakCSD, IDENTIFIER, targetUnknownSettings);
				} else if(peak instanceof IPeakWSD peakWSD) {
					identificationTarget = TARGETBUILDER_WSD.setPeakTargetUnknown(peakWSD, IDENTIFIER, targetUnknownSettings);
				}
				if(identificationTarget != null) {
					identificationResult.add(identificationTarget);
				}
			}
			peakIdentificationResults.add(identificationResult);
		}

		return peakIdentificationResults;
	}

	public void runIdentificationScan(List<? extends IScan> spectraList, float limitMatchFactor, TargetUnknownSettings targetUnknownSettings) {

		for(IScan scan : spectraList) {
			if(LimitSupport.doIdentify(scan.getTargets(), limitMatchFactor)) {
				if(scan instanceof IScanMSD scanMSD) {
					TARGETBUILDER_MSD.setMassSpectrumTargetUnknown(scanMSD, IDENTIFIER, targetUnknownSettings);
				} else if(scan instanceof IScanWSD scanWSD) {
					TARGETBUILDER_WSD.setWaveSpectrumTargetUnknown(scanWSD, IDENTIFIER, targetUnknownSettings);
				}
			}
		}
	}
}
