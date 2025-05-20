/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.csd.model.core;

import org.eclipse.chemclipse.model.exceptions.PeakException;

public abstract class AbstractChromatogramPeakCSD extends AbstractPeakCSD implements IChromatogramPeakCSD {

	private IChromatogramCSD chromatogram;

	/**
	 * Construct a peak.
	 * 
	 * @param peakModel
	 * @param chromatogram
	 * @throws IllegalArgumentException
	 * @throws PeakException
	 */
	public AbstractChromatogramPeakCSD(IPeakModelCSD peakModel, IChromatogramCSD chromatogram) throws IllegalArgumentException, PeakException {

		super(peakModel);
		validateChromatogram(chromatogram);
		validateRetentionTimes(chromatogram, peakModel);
		/*
		 * Assign the references, because all tests has been passed
		 * successfully.
		 */
		this.chromatogram = chromatogram;
	}

	public AbstractChromatogramPeakCSD(IPeakModelCSD peakModel, IChromatogramCSD chromatogram, String modelDescription) throws IllegalArgumentException, PeakException {

		this(peakModel, chromatogram);
		setModelDescription(modelDescription);
	}

	@Override
	public int getScanMax() {

		int retentionTime = getPeakModel().getRetentionTimeAtPeakMaximum();
		return chromatogram.getScanNumber(retentionTime);
	}

	@Override
	public float getSignalToNoiseRatio() {

		return getSignalToNoiseRatio(chromatogram);

	}

	@Override
	public int getWidthBaselineTotalInScans() {

		int start = chromatogram.getScanNumber(getPeakModel().getStartRetentionTime());
		if(start == 0) {
			return 0;
		}
		int stop = chromatogram.getScanNumber(getPeakModel().getStopRetentionTime());
		if(stop == 0) {
			return 0;
		}
		return stop - start + 1;
	}

	@Override
	public IChromatogramCSD getChromatogram() {

		return chromatogram;
	}

	@Override
	public int hashCode() {

		return 7 * getPeakModel().hashCode() + 11 * chromatogram.hashCode();
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName());
		builder.append("[");
		builder.append("peakModel=" + getPeakModel());
		builder.append(",");
		builder.append("chromatogram=" + chromatogram);
		builder.append("]");
		return builder.toString();
	}
}