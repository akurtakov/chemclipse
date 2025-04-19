/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.baseline;

/**
 * Defines the values for a baseline segment, e.g. start and stop retention
 * time, start and stop background abundance.
 */
public interface IBaselineSegment {

	int getStartRetentionTime();

	/**
	 * The start retention time must be >= 0 and must be =< stopRetentionTime.
	 * 
	 * @param startRetentionTime
	 */
	void setStartRetentionTime(int startRetentionTime);

	float getStartBackgroundAbundance();

	/**
	 * The start background abundance time must be >= 0.
	 * 
	 * @param startBackgroundAbundance
	 */
	void setStartBackgroundAbundance(float startBackgroundAbundance);

	int getStopRetentionTime();

	/**
	 * The stop retention time must be >= 0 and must be >= startRetentionTime.
	 * 
	 * @param stopRetentionTime
	 */
	void setStopRetentionTime(int stopRetentionTime);

	float getStopBackgroundAbundance();

	/**
	 * The stop background abundance time must be >= 0.
	 * 
	 * @param stopBackgroundAbundance
	 */
	void setStopBackgroundAbundance(float stopBackgroundAbundance);

	float getBackgroundAbundance(int retentionTime);
}
