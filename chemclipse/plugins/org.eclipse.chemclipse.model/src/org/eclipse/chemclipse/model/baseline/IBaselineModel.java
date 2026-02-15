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
package org.eclipse.chemclipse.model.baseline;

import java.util.Set;

import org.eclipse.chemclipse.model.exceptions.BaselineIsNotDefinedException;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.support.traces.ITrace;

public interface IBaselineModel {

	/*
	 * Min and max retention times.
	 */
	int MIN_RETENTION_TIME = 1;
	int MAX_RETENTION_TIME = Integer.MAX_VALUE;

	boolean isBaselineSet();

	/**
	 * Adds a baseline to the corresponding chromatogram.<br/>
	 * Set the start and end retention time and respectively the start and
	 * background abundance.<br/>
	 * The method returns immediately if the start retention time is >= the stop
	 * retention time.
	 * If validate is yes, further checks and constraints are performed. If it's no,
	 * the caller must be sure that the baseline segment is in no conflict with other
	 * baseline segments.
	 * 
	 * @param startRetentionTime
	 * @param stopRetentionTime
	 * @param startBackgroundAbundance
	 * @param stopBackgroundAbundance
	 * @param validate
	 */
	void addBaseline(int startRetentionTime, int stopRetentionTime, float startBackgroundAbundance, float stopBackgroundAbundance, boolean validate);

	void addBaseline(int startRetentionTime, int stopRetentionTime, float startBackgroundAbundance, float stopBackgroundAbundance, ITrace trace, boolean validate);

	/**
	 * 
	 * @param totalIonSignals
	 */
	void addBaseline(ITotalScanSignals totalIonSignals);

	/**
	 * Remove the baseline between the given retention times.<br/>
	 * The method returns immediately if the start retention time is >= the
	 * stop retention time.
	 * 
	 * @param startRetentionTime
	 * @param stopRetentionTime
	 */
	void removeBaseline(int startRetentionTime, int stopRetentionTime);

	/**
	 * Remove the baseline totally.
	 */
	void removeBaseline();

	/**
	 * Get the background abundance at a given retention time.<br/>
	 * The retention time is given in milliseconds.<br/>
	 * If the given retention time is out of chromatogram borders, 0 will be
	 * returned.
	 * 
	 * @param retentionTime
	 * @return float
	 */
	float getBackgroundAbundance(int retentionTime);

	/**
	 * Get the background abundance at a given retention time.<br/>
	 * The retention time is given in milliseconds.<br/>
	 * If the given retention time is out of defined baseline default value will be return value will be return
	 * (Can be NaN)
	 * returned.
	 * 
	 * @param retentionTime
	 * @return float
	 */
	float getBackground(int retentionTime);

	float getBackground(int retentionTime, Set<ITrace> traces);

	/**
	 * Get the background abundance at a given retention time.<br/>
	 * The retention time is given in milliseconds.<br/>
	 * If the given retention time is out of defined baseline throws BaselineIsNotDefinedException
	 * 
	 * @param retentionTime
	 * @return float
	 * @throws BaselineIsNotDefinedException
	 */
	float getBackgroundNotNaN(int retentionTime) throws BaselineIsNotDefinedException;

	float getBackgroundNotNaN(int retentionTime, Set<ITrace> traces) throws BaselineIsNotDefinedException;

	/**
	 * Returns a deep copy of the actual baseline model.
	 * 
	 * @return {@link IBaselineModel}
	 */
	IBaselineModel makeDeepCopy();
}