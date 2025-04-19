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
 * Alexander Kerner - type hierarchy
 *******************************************************************************/
package org.eclipse.chemclipse.wsd.model.core;

import org.eclipse.chemclipse.model.core.IChromatogramPeak;

public interface IChromatogramPeakWSD extends IPeakWSD, IChromatogramPeak {

	/**
	 * Returns the chromatogram to which this peak belongs to.
	 *
	 * @return {@link IChromatogramWSD}
	 */
	@Override
	IChromatogramWSD getChromatogram();

	/**
	 * Returns the width of the actual peak at its absolute baseline.<br/>
	 * The width is given in scan units.<br/>
	 * The width is not measured at the points of inflection.<br/>
	 * If the peak is out of limits or something has gone wrong, 0 will be
	 * returned.
	 *
	 * @return int
	 */
	int getWidthBaselineTotalInScans();
}
