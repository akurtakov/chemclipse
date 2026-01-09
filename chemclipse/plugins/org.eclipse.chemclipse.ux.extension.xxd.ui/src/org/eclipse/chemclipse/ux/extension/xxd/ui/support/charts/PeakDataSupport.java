/*******************************************************************************
 * Copyright (c) 2017, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.support.charts;

import java.text.DecimalFormat;

import org.eclipse.chemclipse.csd.model.core.IPeakCSD;
import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.core.IPeakModel;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.msd.model.core.IPeakMSD;
import org.eclipse.chemclipse.support.text.ValueFormat;
import org.eclipse.chemclipse.wsd.model.core.IPeakWSD;

public class PeakDataSupport {

	private DecimalFormat decimalFormat = ValueFormat.getDecimalFormatEnglish("0.0##");

	public String getPeakLabel(IPeak peak) {

		StringBuilder builder = new StringBuilder();
		if(peak != null) {

			IPeakModel peakModel = peak.getPeakModel();
			IScan scan = peakModel.getPeakMaximum();

			builder.append("Peak");
			builder.append(" | ");
			builder.append("Center RT: ");
			builder.append(decimalFormat.format(scan.getRetentionTime() / IChromatogramOverview.MINUTE_CORRELATION_FACTOR));
			builder.append(" | ");
			builder.append("Center RI: ");
			if(org.eclipse.chemclipse.model.preferences.PreferenceSupplier.showRetentionIndexWithoutDecimals()) {
				builder.append(Integer.toString((int)scan.getRetentionIndex()));
			} else {
				builder.append(decimalFormat.format(scan.getRetentionIndex()));
			}

			builder.append(" | ");
			builder.append("Signal: ");
			builder.append((int)peak.getIntegratedArea());
		} else {
			builder.append("No peak has been selected yet.");
		}
		return builder.toString();
	}

	public String getType(IPeak peak) {

		if(peak instanceof IPeakCSD) {
			return "[CSD]";
		} else if(peak instanceof IPeakMSD) {
			return "[MSD]";
		} else if(peak instanceof IPeakWSD) {
			return "[WSD]";
		} else {
			return "";
		}
	}
}
