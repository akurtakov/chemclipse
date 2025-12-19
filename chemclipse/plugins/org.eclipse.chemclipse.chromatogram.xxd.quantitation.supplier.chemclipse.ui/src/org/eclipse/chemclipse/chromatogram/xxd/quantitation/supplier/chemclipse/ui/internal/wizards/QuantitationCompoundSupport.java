/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.quantitation.supplier.chemclipse.ui.internal.wizards;

import org.eclipse.chemclipse.chromatogram.xxd.quantitation.supplier.chemclipse.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.core.IPeakModel;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.quantitation.IQuantitationCompound;
import org.eclipse.chemclipse.model.quantitation.IQuantitationDatabase;
import org.eclipse.chemclipse.model.quantitation.IQuantitationPeak;
import org.eclipse.chemclipse.model.quantitation.IRetentionIndexWindow;
import org.eclipse.chemclipse.model.quantitation.IRetentionTimeWindow;
import org.eclipse.chemclipse.msd.model.core.IPeakMSD;
import org.eclipse.chemclipse.msd.model.implementation.QuantitationPeakMSD;
import org.eclipse.chemclipse.xxd.model.quantitation.QuantitationCompound;

public class QuantitationCompoundSupport {

	public IQuantitationCompound create(IPeak peak, String name, double concentration, String concentrationUnit, String chemicalClass) {

		IPeakModel peakModel = peak.getPeakModel();
		IScan scan = peakModel.getPeakMaximum();
		int retentionTime = scan.getRetentionTime();
		float retentionIndex = scan.getRetentionIndex();

		IQuantitationCompound quantitationCompound = new QuantitationCompound(name, concentrationUnit, retentionTime);
		quantitationCompound.setChemicalClass(chemicalClass);

		IRetentionTimeWindow retentionTimeWindow = quantitationCompound.getRetentionTimeWindow();
		if(retentionTime > 0) {
			retentionTimeWindow.setAllowedNegativeDeviation((int)(PreferenceSupplier.getRetentionTimeNegativeDeviation() * IChromatogramOverview.MINUTE_CORRELATION_FACTOR));
			retentionTimeWindow.setAllowedPositiveDeviation((int)(PreferenceSupplier.getRetentionTimePositiveDeviation() * IChromatogramOverview.MINUTE_CORRELATION_FACTOR));
		}

		IRetentionIndexWindow retentionIndexWindow = quantitationCompound.getRetentionIndexWindow();
		retentionIndexWindow.setRetentionIndex(retentionIndex);
		if(retentionIndex > 0) {
			retentionIndexWindow.setAllowedNegativeDeviation(PreferenceSupplier.getRetentionIndexNegativeDeviation());
			retentionIndexWindow.setAllowedPositiveDeviation(PreferenceSupplier.getRetentionIndexPositiveDeviation());
		}

		IQuantitationPeak quantitationPeakMSD = new QuantitationPeakMSD((IPeakMSD)peak, concentration, concentrationUnit);
		quantitationCompound.getQuantitationPeaks().add(quantitationPeakMSD);

		quantitationCompound.setQuantitationSignalTIC();

		return quantitationCompound;
	}

	public void merge(IQuantitationDatabase quantitationDatabase, IPeak peak, String name, double concentration) {

		IQuantitationCompound quantitationCompound = quantitationDatabase.getQuantitationCompound(name);
		if(quantitationCompound != null) {
			IQuantitationPeak quantitationPeakMSD = new QuantitationPeakMSD((IPeakMSD)peak, concentration, quantitationCompound.getConcentrationUnit());
			quantitationCompound.getQuantitationPeaks().add(quantitationPeakMSD);
		}
	}
}
