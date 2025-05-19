/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.vsd.model.core;

import org.eclipse.chemclipse.model.core.IChromatogramPeak;
import org.eclipse.chemclipse.model.exceptions.PeakException;

public class AbstractChromatogramPeakVSD extends AbstractPeakVSD implements IChromatogramPeakVSD {

	private float signalToNoiseRatio = IChromatogramPeak.INITIAL_SN_VALUE;
	private IChromatogramVSD chromatogram;

	public AbstractChromatogramPeakVSD(IPeakModelVSD peakModel, IChromatogramVSD chromatogram) throws IllegalArgumentException, PeakException {

		super(peakModel);
		validateChromatogram(chromatogram);
		validateRetentionTimes(chromatogram, peakModel);
		/*
		 * Assign the references, because all tests has been passed
		 * successfully.
		 */
		this.chromatogram = chromatogram;
		this.signalToNoiseRatio = checkSignalToNoiseRatio(chromatogram);
	}

	public AbstractChromatogramPeakVSD(IPeakModelVSD peakModel, IChromatogramVSD chromatogram, String modelDescription) throws IllegalArgumentException, PeakException {

		this(peakModel, chromatogram);
		setModelDescription(modelDescription);
	}

	@Override
	public IChromatogramVSD getChromatogram() {

		return chromatogram;
	}

	@Override
	public void resetSignalToNoiseRatio() {

		signalToNoiseRatio = INITIAL_SN_VALUE;
	}

	@Override
	public float getSignalToNoiseRatio() {

		return getSignalToNoiseRatio(chromatogram, signalToNoiseRatio);
	}

	@Override
	public int getScanMax() {

		int retentionTime = getPeakModel().getRetentionTimeAtPeakMaximum();
		return chromatogram.getScanNumber(retentionTime);
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