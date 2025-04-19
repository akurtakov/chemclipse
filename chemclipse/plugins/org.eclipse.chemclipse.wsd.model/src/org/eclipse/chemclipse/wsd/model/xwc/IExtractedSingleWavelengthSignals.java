/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Jan Holy - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.wsd.model.xwc;

import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.wsd.model.core.IChromatogramWSD;

public interface IExtractedSingleWavelengthSignals extends ITotalScanSignals {

	@Override
	IChromatogramWSD getChromatogram();

	/**
	 * Adds an {@link IExtractedSingleWavelengthSignal} instance at the end of the stored
	 * 
	 * @param extractedWavelengthSignal
	 */
	void add(IExtractedSingleWavelengthSignal extractedWavelengthSignal);

	@Override
	IExtractedSingleWavelengthSignal getTotalScanSignal(int scan);

	@Override
	IExtractedSingleWavelengthSignals makeDeepCopy();

	float getWavelength();
}
