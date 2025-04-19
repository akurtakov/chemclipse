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

public interface IChannel {

	String CHANNEL = "Channel";

	int getId();

	void setId(int id);

	String getName();

	void setName(String name);

	int getTime();

	void setTime(int time);

	double getTemperature();

	void setTemperature(double temperature);

	boolean isValid();

	void setValid(boolean valid);

	List<Double> getFluorescence();

	void setFluorescence(List<Double> fluorescence);

	List<Double> getColorCompensatedFluorescence();

	void setColorCompensatedFluorescence(List<Double> colorCompensatedFluorescence);

	double getCrossingPoint();

	void setCrossingPoint(double crossingPoint);

	String getDetectionName();

	void setDetectionName(String detectionName);

	IChannel makeDeepCopy();
}
