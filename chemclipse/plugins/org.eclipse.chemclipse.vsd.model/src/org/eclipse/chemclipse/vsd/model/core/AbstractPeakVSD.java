/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.vsd.model.core;

import org.eclipse.chemclipse.model.core.AbstractPeak;

public class AbstractPeakVSD extends AbstractPeak implements IPeakVSD {

	private IPeakModelVSD peakModel;

	public AbstractPeakVSD(IPeakModelVSD peakModel) throws IllegalArgumentException {

		validatePeakModel(peakModel);
		this.peakModel = peakModel;
	}

	public AbstractPeakVSD(IPeakModelVSD peakModel, String modelDescription) throws IllegalArgumentException {

		this(peakModel);
		setModelDescription(modelDescription);
	}

	@Override
	public IPeakModelVSD getPeakModel() {

		return peakModel;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName());
		builder.append("[");
		builder.append("peakModel=" + peakModel);
		builder.append("]");
		return builder.toString();
	}
}