/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.vsd.model.implementation;

import org.eclipse.chemclipse.model.core.AbstractMeasurementInfo;
import org.eclipse.chemclipse.vsd.model.core.IScanVSD;
import org.eclipse.chemclipse.vsd.model.core.ISpectrumVSD;

public class SpectrumVSD extends AbstractMeasurementInfo implements ISpectrumVSD {

	private static final long serialVersionUID = 118019458936673272L;
	private IScanVSD scanVSD = new ScanVSD();

	@Override
	public IScanVSD getScanVSD() {

		return scanVSD;
	}

	@Override
	public int hashCode() {

		return scanVSD.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return scanVSD.equals(obj);
	}

	@Override
	public String toString() {

		return "SpectrumVSD [rotationAngle=" + scanVSD.getRotationAngle() + "]";
	}
}