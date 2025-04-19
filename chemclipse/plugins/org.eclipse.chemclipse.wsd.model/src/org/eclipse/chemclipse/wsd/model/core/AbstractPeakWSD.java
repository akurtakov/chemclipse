/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.wsd.model.core;

import org.eclipse.chemclipse.model.core.AbstractPeak;

public abstract class AbstractPeakWSD extends AbstractPeak implements IPeakWSD {

	private IPeakModelWSD peakModel;

	public AbstractPeakWSD(IPeakModelWSD peakModel) throws IllegalArgumentException {
		validatePeakModel(peakModel);
		this.peakModel = peakModel;
	}

	public AbstractPeakWSD(IPeakModelWSD peakModel, String modelDescription) throws IllegalArgumentException {
		this(peakModel);
		setModelDescription(modelDescription);
	}

	@Override
	public IPeakModelWSD getPeakModel() {

		return peakModel;
	}
}
