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

import org.eclipse.chemclipse.chromatogram.xxd.calculator.core.noise.NoiseCalculator;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.model.core.AbstractChromatogram;
import org.eclipse.chemclipse.model.core.INoiseCalculator;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.vsd.model.core.selection.ChromatogramSelectionVSD;

public abstract class AbstractChromatogramVSD extends AbstractChromatogram implements IChromatogramVSD {

	private static final long serialVersionUID = -2463054178850833466L;

	@Override
	public void fireUpdate(IChromatogramSelection chromatogramSelection) {

		/*
		 * Fire an update to inform all listeners.
		 */
		if(chromatogramSelection instanceof ChromatogramSelectionVSD chromatogramSelectionISD) {
			chromatogramSelectionISD.update(true);
		}
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
