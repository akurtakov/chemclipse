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

import org.eclipse.chemclipse.csd.model.core.IChromatogramCSD;
import org.eclipse.chemclipse.csd.model.core.IPeakModelCSD;
import org.eclipse.chemclipse.csd.model.implementation.ChromatogramCSD;
import org.eclipse.chemclipse.csd.model.implementation.ChromatogramPeakCSD;
import org.eclipse.chemclipse.csd.model.implementation.PeakModelCSD;
import org.eclipse.chemclipse.csd.model.implementation.ScanCSD;
import org.eclipse.chemclipse.model.core.IIntegrationEntry;
import org.eclipse.chemclipse.model.core.IPeakIntensityValues;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.core.IntegrationType;
import org.eclipse.chemclipse.model.implementation.PeakIntensityValues;
import org.eclipse.chemclipse.model.implementation.Scan;

public class PeaksFilter {

	protected IChromatogramCSD getChromatogramCSD() {

		IChromatogramCSD chromatogramCSD = new ChromatogramCSD();
		for(int i = 0; i < 2500; i++) {
			ScanCSD scanCSD = new ScanCSD(500);
			scanCSD.setRetentionTime(i * 10);
			chromatogramCSD.addScan(scanCSD);
		}
		chromatogramCSD.getPeaks().add(createPeak(chromatogramCSD, 1000, 900, 100));
		chromatogramCSD.getPeaks().add(createPeak(chromatogramCSD, 5000, 1800, 200)); // Height
		chromatogramCSD.getPeaks().add(createPeak(chromatogramCSD, 10000, 1700, 300));
		chromatogramCSD.getPeaks().add(createPeak(chromatogramCSD, 15000, 1200, 400));
		chromatogramCSD.getPeaks().add(createPeak(chromatogramCSD, 20000, 600, 500)); // Area

		return chromatogramCSD;
	}

	protected ChromatogramPeakCSD createPeak(IChromatogramCSD chromatogramCSD, int retentionTime, float totalSignal, double area) {

		IScan peakMaximum = new Scan(totalSignal);
		peakMaximum.setRetentionTime(retentionTime);
		IPeakIntensityValues peakIntensityValues = new PeakIntensityValues();
		peakIntensityValues.addIntensityValue(retentionTime - 20, 30.f);
		peakIntensityValues.addIntensityValue(retentionTime - 10, 80.f);
		peakIntensityValues.addIntensityValue(retentionTime, 100.f);
		peakIntensityValues.addIntensityValue(retentionTime + 10, 70.f);
		peakIntensityValues.addIntensityValue(retentionTime + 20, 40.f);
		IPeakModelCSD peakModelCSD = new PeakModelCSD(peakMaximum, peakIntensityValues, 0.0f, 0.0f);
		peakModelCSD.setStrictModel(true);
		ChromatogramPeakCSD peakCSD = new ChromatogramPeakCSD(peakModelCSD, chromatogramCSD);
		peakCSD.addAllIntegrationEntries(new IIntegrationEntry() {

			@Override
			public double getSignal() {

				return 0;
			}

			@Override
			public double getIntegratedArea() {

				return area;
			}

			@Override
			public IntegrationType getIntegrationType() {

				return IntegrationType.PEAK;
			}

			@Override
			public void setIntegrationType(IntegrationType integrationType) {

			}
		});

		return peakCSD;
	}
}