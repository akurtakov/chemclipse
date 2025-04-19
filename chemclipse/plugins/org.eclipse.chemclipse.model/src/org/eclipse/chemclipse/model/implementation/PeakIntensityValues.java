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
package org.eclipse.chemclipse.model.implementation;

import org.eclipse.chemclipse.model.core.AbstractPeakIntensityValues;
import org.eclipse.chemclipse.model.core.IPeakIntensityValues;

public class PeakIntensityValues extends AbstractPeakIntensityValues implements IPeakIntensityValues {

	private static final long serialVersionUID = 8596503209176077779L;

	public PeakIntensityValues() {

		super();
	}

	public PeakIntensityValues(float maxIntensity) {

		super(maxIntensity);
	}
}