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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings;

import org.eclipse.chemclipse.model.baseline.IBaselineModel;

public class BaselineSupport implements IBaselineSupport {

	private IBaselineModel baselineModel;
	private IBaselineModel baselineModelModified;

	public BaselineSupport() {

		baselineModel = null;
		baselineModelModified = null;
	}

	/**
	 * BaselineSupport gets a deep copy from
	 */
	public BaselineSupport(IBaselineModel baselineModel) {

		if(baselineModel != null) {
			this.baselineModel = baselineModel;
			this.baselineModelModified = baselineModel.makeDeepCopy();
		}
	}

	@Override
	public IBaselineModel getBaselineModel() {

		return baselineModelModified;
	}

	@Override
	public void setBaselineModel(IBaselineModel baselineModel) {

		if(baselineModel != null) {
			this.baselineModel = baselineModel;
			this.baselineModelModified = baselineModel.makeDeepCopy();
		}
	}

	@Override
	public void reset() {

		if(baselineModel != null) {
			baselineModelModified = baselineModel.makeDeepCopy();
		}
	}

	@Override
	public void setBaselineBack(int retentionTime) {

		if(modelIsNotNull()) {
			float abundance = baselineModelModified.getBackground(retentionTime);
			baselineModelModified.addBaseline(IBaselineModel.MIN_RETENTION_TIME, retentionTime, abundance, abundance, true);
		}
	}

	@Override
	public void setBaselineHoldOn(int startRetentionTime, int stopRetentionTime) {

		if(modelIsNotNull()) {
			float abundance = baselineModelModified.getBackground(startRetentionTime);
			baselineModelModified.addBaseline(startRetentionTime, stopRetentionTime, abundance, abundance, true);
		}
	}

	@Override
	public void setBaselineNow(int retentionTime) {

		if(modelIsNotNull()) {
			float abundance = baselineModelModified.getBackground(retentionTime);
			baselineModelModified.addBaseline(retentionTime, IBaselineModel.MAX_RETENTION_TIME, abundance, abundance, true);
		}
	}

	@Override
	public float getBackgroundAbundance(int retentionTime) {

		float result = 0.0f;
		if(modelIsNotNull()) {
			result = baselineModelModified.getBackground(retentionTime);
		}
		return result;
	}

	// --------------------------------------private methods
	private boolean modelIsNotNull() {

		boolean result = true;
		if(baselineModelModified == null) {
			result = false;
		}
		return result;
	}
	// --------------------------------------private methods
}
