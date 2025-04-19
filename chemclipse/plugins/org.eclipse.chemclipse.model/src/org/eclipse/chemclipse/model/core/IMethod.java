/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.core;

public interface IMethod {

	String getInstrumentName();

	void setInstrumentName(String instrumentName);

	String getIonSource();

	void setIonSource(String ionSource);

	String getStopMode();

	void setStopMode(String stopMode);

	int getStopTime();

	void setStopTime(int stopTime);

	int getSolventDelay();

	void setSolventDelay(int solventDelay);

	boolean isCollisionGasOn();

	void setCollisionGasOn(boolean collisionGasOn);

	int getTimeFilterPeakWidth();

	void setTimeFilterPeakWidth(int timeFilterPeakWidth);

	double getSourceHeater();

	void setSourceHeater(double sourceHeater);

	double getSamplingRate();

	void setSamplingRate(double samplingRate);
}