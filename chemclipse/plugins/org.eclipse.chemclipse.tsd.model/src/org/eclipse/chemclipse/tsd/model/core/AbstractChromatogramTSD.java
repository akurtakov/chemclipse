/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.tsd.model.core;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.core.noise.NoiseCalculator;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.model.core.AbstractChromatogram;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.INoiseCalculator;

public abstract class AbstractChromatogramTSD extends AbstractChromatogram implements IChromatogramTSD {

	private static final long serialVersionUID = 7761066909104550509L;
	private IChromatogram chromatogram = null;

	protected AbstractChromatogramTSD() {

		this(null);
	}

	public AbstractChromatogramTSD(IChromatogram chromatogram) {

		this.chromatogram = chromatogram;
	}

	@Override
	public IChromatogram getChromatogram() {

		return chromatogram;
	}

	@Override
	protected String getNoiseCalculatorId() {

		return PreferenceSupplier.getSelectedNoiseCalculatorId();
	}

	@Override
	protected INoiseCalculator createNoiseCalculator(String id) {

		return NoiseCalculator.getNoiseCalculator(id);
	}
}