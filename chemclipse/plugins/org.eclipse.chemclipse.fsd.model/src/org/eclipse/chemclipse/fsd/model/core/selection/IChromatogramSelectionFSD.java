/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.fsd.model.core.selection;

import org.eclipse.chemclipse.fsd.model.core.IChromatogramFSD;
import org.eclipse.chemclipse.fsd.model.core.IScanFSD;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;

public interface IChromatogramSelectionFSD extends IChromatogramSelection {

	/**
	 * Returns the stored chromatogram.
	 * May return null.
	 *
	 * @return {@link IChromatogramFSD}
	 */
	@Override
	IChromatogramFSD getChromatogram();

	/**
	 * Returns the selected scan of the current chromatogram or null, if none is
	 * stored.
	 *
	 * @return {@link IScanFSD}
	 */
	@Override
	IScanFSD getSelectedScan();

	/**
	 * Sets the selected scan of the current chromatogram.<br/>
	 * The scan must not be null.
	 */
	void setSelectedScan(IScanFSD selectedScan);

	/**
	 * Use this convenient method, if you don't want to fire and update.
	 *
	 * @param selectedScan
	 * @param update
	 */
	void setSelectedScan(IScanFSD selectedScan, boolean update);

	/**
	 * Populate the list with wavelengths from the first scan of the given chromatogram.
	 *
	 * @param chromatogram
	 */
	void populateWavelengths(IChromatogramFSD chromatogram);
}
