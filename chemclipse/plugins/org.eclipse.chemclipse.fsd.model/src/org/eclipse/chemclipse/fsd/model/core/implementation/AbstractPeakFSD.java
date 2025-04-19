/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.fsd.model.core.implementation;

import org.eclipse.chemclipse.fsd.model.core.IPeakFSD;
import org.eclipse.chemclipse.fsd.model.core.IPeakModelFSD;
import org.eclipse.chemclipse.model.core.AbstractPeak;

public abstract class AbstractPeakFSD extends AbstractPeak implements IPeakFSD {

	private IPeakModelFSD peakModel;

	protected AbstractPeakFSD(IPeakModelFSD peakModel) throws IllegalArgumentException {

		validatePeakModel(peakModel);
		this.peakModel = peakModel;
	}

	protected AbstractPeakFSD(IPeakModelFSD peakModel, String modelDescription) throws IllegalArgumentException {

		this(peakModel);
		setModelDescription(modelDescription);
	}

	@Override
	public IPeakModelFSD getPeakModel() {

		return peakModel;
	}
}
