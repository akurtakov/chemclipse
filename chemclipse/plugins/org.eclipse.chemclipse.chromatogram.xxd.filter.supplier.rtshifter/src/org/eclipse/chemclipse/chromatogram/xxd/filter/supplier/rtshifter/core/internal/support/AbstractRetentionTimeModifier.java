/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.rtshifter.core.internal.support;

import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.rtshifter.exceptions.FilterException;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;

public abstract class AbstractRetentionTimeModifier {

	protected static void adjustScanDelayAndRetentionTimeRange(IChromatogramSelection chromatogramSelection) throws FilterException {

		IChromatogram chromatogram = chromatogramSelection.getChromatogram();
		if(chromatogram.getNumberOfScans() <= 0) {
			throw new FilterException("There is no scan available.");
		}
		IScan firstScan = chromatogram.getScan(1);
		int scanDelay = firstScan.getRetentionTime();
		chromatogram.setScanDelay(scanDelay);

		int startRetentionTime = firstScan.getRetentionTime();
		if(chromatogramSelection.getStartRetentionTime() < startRetentionTime) {
			chromatogramSelection.setStartRetentionTime(startRetentionTime);
		}

		int stopRetentionTime = chromatogram.getStopRetentionTime();
		if(chromatogramSelection.getStopRetentionTime() > stopRetentionTime) {
			chromatogramSelection.setStopRetentionTime(stopRetentionTime);
		}
	}
}
