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
package org.eclipse.chemclipse.model.signals;

public interface ITotalScanSignal {

	/**
	 * Returns the retention time.<br/>
	 * The retention time is stored in milliseconds.
	 * 
	 * @return int
	 */
	int getRetentionTime();

	/**
	 * Sets the retention time.
	 * 
	 * @param retentionTime
	 */
	void setRetentionTime(int retentionTime);

	/**
	 * Returns the retention index.
	 * 
	 * @return float
	 */
	float getRetentionIndex();

	/**
	 * Sets the retention index.
	 * 
	 * @param retentionIndex
	 */
	void setRetentionIndex(float retentionIndex);

	/**
	 * Returns the total ion signal
	 * 
	 * @return float
	 */
	float getTotalSignal();

	/**
	 * Sets a total signal.
	 * Validates automatically that only positive values are added.
	 * 
	 * @param totalSignal
	 */
	void setTotalSignal(float totalSignal);

	/**
	 * Sets a total signal.
	 * Set if only positive values shall be added.
	 * 
	 * @param totalSignal
	 * @param validatePositive
	 */
	void setTotalSignal(float totalSignal, boolean validatePositive);

	/**
	 * Returns a deep copy of the actual total ion signal.
	 * 
	 * @return {@link ITotalScanSignal}
	 */
	ITotalScanSignal makeDeepCopy();
}
