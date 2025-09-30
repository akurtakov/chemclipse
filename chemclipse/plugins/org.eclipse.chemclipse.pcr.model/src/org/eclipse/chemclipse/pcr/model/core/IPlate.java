/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - add color compensation
 *******************************************************************************/
package org.eclipse.chemclipse.pcr.model.core;

import java.util.List;
import java.util.TreeSet;

import org.eclipse.chemclipse.model.core.IMeasurementInfo;

public interface IPlate extends IMeasurementInfo {

	String NAME = "name"; //$NON-NLS-1$
	String NOISEBAND = "Noiseband"; //$NON-NLS-1$
	String THRESHOLD = "Threshold"; //$NON-NLS-1$

	List<String> getActiveChannels();

	int getActiveChannel();

	void setActiveChannel(int activeChannel);

	List<String> getSampleSubsets();

	void setActiveSubset(String activeSubset);

	IDetectionFormat getDetectionFormat();

	void setDetectionFormat(IDetectionFormat detectionFormat);

	List<IDetectionFormat> getDetectionFormats();

	TreeSet<IWell> getWells();

	IWell getWell(int id);

	void setName(String name);

	String getName();

	IPlate makeDeepCopy();
}
