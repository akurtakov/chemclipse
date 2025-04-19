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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.wsd.model.xwc;

import org.eclipse.chemclipse.wsd.model.core.selection.IChromatogramSelectionWSD;

public interface IExtractedWavelengthSignalExtractor {

	IExtractedWavelengthSignals getExtractedWavelengthSignals(float startWavelength, float stopWavelength);

	IExtractedWavelengthSignals getExtractedWavelengthSignals();

	IExtractedWavelengthSignals getExtractedWavelengthSignals(IChromatogramSelectionWSD chromatogramSelection);

	IExtractedWavelengthSignals getExtractedWavelengthSignals(int startScan, int stopScan);
}
