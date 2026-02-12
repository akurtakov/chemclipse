/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.coda.calculator;

import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.coda.exceptions.CodaCalculatorException;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;

public class MassChromatographicQualityCalculator {

	/**
	 * Use only static methods.
	 */
	private MassChromatographicQualityCalculator() {

	}

	/**
	 * Returns a new {@link IMassChromatographicQualityResult} from the given
	 * values.<br/>
	 * 
	 * @param chromatogramSelection
	 * @param codaThreshold
	 * @param windowSize
	 * @return {@link IMassChromatographicQualityResult}
	 * @throws CodaCalculatorException
	 */
	public static IMassChromatographicQualityResult calculate(IChromatogramSelectionMSD chromatogramSelection, float codaThreshold, int windowSize) throws CodaCalculatorException {

		IMassChromatographicQualityResult result = new MassChromatographicQualityResult(chromatogramSelection, codaThreshold, windowSize);
		return result;
	}
}
