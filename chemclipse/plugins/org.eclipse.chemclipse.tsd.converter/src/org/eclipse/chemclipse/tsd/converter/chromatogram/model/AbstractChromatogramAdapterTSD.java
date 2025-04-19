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
package org.eclipse.chemclipse.tsd.converter.chromatogram.model;

import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.tsd.model.core.AbstractChromatogramTSD;

public abstract class AbstractChromatogramAdapterTSD extends AbstractChromatogramTSD {

	private static final long serialVersionUID = 7181095941633328215L;

	protected AbstractChromatogramAdapterTSD(IChromatogram chromatogram) {

		super(chromatogram);
	}

	@Override
	public double getPeakIntegratedArea() {

		double integratedArea = 0.0d;
		IChromatogram chromatogram = getChromatogram();
		if(chromatogram != null) {
			integratedArea = chromatogram.getPeakIntegratedArea();
		}

		return integratedArea;
	}

	@Override
	public void fireUpdate(IChromatogramSelection chromatogramSelection) {

	}
}
