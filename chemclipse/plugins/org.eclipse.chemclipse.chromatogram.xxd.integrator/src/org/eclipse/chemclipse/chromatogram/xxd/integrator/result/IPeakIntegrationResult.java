/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.result;

import java.util.Set;

public interface IPeakIntegrationResult {

	double getIntegratedArea();

	void setIntegratedArea(double integratedArea);

	float getTailing();

	void setTailing(float tailing);

	int getWidth();

	void setWidth(int width);

	String getIntegratorType();

	void setIntegratorType(String integratorType);

	String getPeakType();

	void setPeakType(String peakType);

	String getModelDescription();

	void setModelDescription(String modelDescription);

	float getSN();

	void setSN(float sn);

	int getStartRetentionTime();

	void setStartRetentionTime(int startRetentionTime);

	int getStopRetentionTime();

	void setStopRetentionTime(int stopRetentionTime);

	float getPurity();

	void setPurity(float purity);

	/**
	 * Returns the ions which has been integrated as a set.<br/>
	 * If it was TIC (total ion chromatogram), the IIon.TIC_Ion will be
	 * returned.
	 */
	Set<Integer> getIntegratedTraces();

	/**
	 * Sets the ion which has been integrated.
	 */
	void addIntegratedTrace(int ion);

	/**
	 * Removes the ion from the actual integrated ion list.
	 */
	void removeIntegratedTrace(int ion);

	/**
	 * Sets the ions which has been integrated.
	 */
	void addIntegratedTraces(Set<Integer> ions);
}
