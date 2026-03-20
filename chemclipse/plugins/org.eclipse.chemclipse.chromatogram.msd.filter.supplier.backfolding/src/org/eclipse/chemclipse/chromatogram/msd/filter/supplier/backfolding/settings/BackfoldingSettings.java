/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
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

public class BackfoldingSettings implements IBackfoldingSettings {

	private int numberOfBackfoldingRuns = 3;
	private int maximumRetentionTimeShift = 5000;

	@Override
	public int getNumberOfBackfoldingRuns() {

		return numberOfBackfoldingRuns;
	}

	@Override
	public void setNumberOfBackfoldingRuns(int numberOfBackfoldingRuns) {

		if(numberOfBackfoldingRuns >= 1 && numberOfBackfoldingRuns <= 10) {
			this.numberOfBackfoldingRuns = numberOfBackfoldingRuns;
		}
	}

	@Override
	public int getMaximumRetentionTimeShift() {

		return maximumRetentionTimeShift;
	}

	@Override
	public void setMaximumRetentionTimeShift(int maximumRetentionTimeShift) {

		if(maximumRetentionTimeShift >= 500 && maximumRetentionTimeShift <= 25000) {
			this.maximumRetentionTimeShift = maximumRetentionTimeShift;
		}
	}
}
