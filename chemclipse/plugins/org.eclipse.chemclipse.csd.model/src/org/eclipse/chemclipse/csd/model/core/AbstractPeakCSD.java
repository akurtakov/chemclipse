/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.csd.model.core;

import org.eclipse.chemclipse.model.core.AbstractPeak;

public abstract class AbstractPeakCSD extends AbstractPeak implements IPeakCSD {

	private IPeakModelCSD peakModel;

	public AbstractPeakCSD(IPeakModelCSD peakModel) throws IllegalArgumentException {

		validatePeakModel(peakModel);
		this.peakModel = peakModel;
	}

	public AbstractPeakCSD(IPeakModelCSD peakModel, String modelDescription) throws IllegalArgumentException {

		this(peakModel);
		setModelDescription(modelDescription);
	}

	@Override
	public IPeakModelCSD getPeakModel() {

		return peakModel;
	}
}