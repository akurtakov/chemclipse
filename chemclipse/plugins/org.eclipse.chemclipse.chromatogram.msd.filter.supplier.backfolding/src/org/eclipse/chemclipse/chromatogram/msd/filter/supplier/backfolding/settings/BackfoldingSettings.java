/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.backfolding.settings;

import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.backfolding.preferences.PreferenceSupplier;

public class BackfoldingSettings implements IBackfoldingSettings {

	private int numberOfBackfoldingRuns = PreferenceSupplier.DEF_BACKFOLDING_RUNS;
	private int maximumRetentionTimeShift = PreferenceSupplier.DEF_RETENTION_TIME_SHIFT;

	@Override
	public int getNumberOfBackfoldingRuns() {

		return numberOfBackfoldingRuns;
	}

	@Override
	public void setNumberOfBackfoldingRuns(int numberOfBackfoldingRuns) {

		if(numberOfBackfoldingRuns >= PreferenceSupplier.MIN_BACKFOLDING_RUNS && numberOfBackfoldingRuns <= PreferenceSupplier.MAX_BACKFOLDING_RUNS) {
			this.numberOfBackfoldingRuns = numberOfBackfoldingRuns;
		}
	}

	@Override
	public int getMaximumRetentionTimeShift() {

		return maximumRetentionTimeShift;
	}

	@Override
	public void setMaximumRetentionTimeShift(int maximumRetentionTimeShift) {

		if(maximumRetentionTimeShift >= PreferenceSupplier.MIN_RETENTION_TIME_SHIFT && maximumRetentionTimeShift <= PreferenceSupplier.MAX_RETENTION_TIME_SHIFT) {
			this.maximumRetentionTimeShift = maximumRetentionTimeShift;
		}
	}
}
