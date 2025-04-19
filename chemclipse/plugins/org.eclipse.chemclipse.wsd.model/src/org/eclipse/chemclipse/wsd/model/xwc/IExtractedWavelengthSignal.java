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
package org.eclipse.chemclipse.wsd.model.xwc;

import org.eclipse.chemclipse.wsd.model.core.IScanSignalWSD;

public interface IExtractedWavelengthSignal {

	void setAbundance(IScanSignalWSD scanSignal, boolean removePreviousAbundance);

	void setAbundance(IScanSignalWSD scanSignal);

	void setAbundance(int wavelength, float abundance);

	void setAbundance(int wavelength, float abundance, boolean removePreviousAbundance);

	float getAbundance(int wavelength);

	int getNumberOfWavelengthValues();

	float getTotalSignal();

	int getWavelengthMaxIntensity();

	float getMaxIntensity();

	float getMinIntensity();

	float getNthHighestIntensity(int n);

	float getMeanIntensity();

	float getMedianIntensity();

	int getRetentionTime();

	void setRetentionTime(int retentionTime);

	float getRetentionIndex();

	void setRetentionIndex(float retentionIndex);

	int getStartWavelength();

	int getStopWavelength();

	IWavelengthRange getWavelengthRange();

	void normalize();

	void normalize(float normalizationBase);
}
