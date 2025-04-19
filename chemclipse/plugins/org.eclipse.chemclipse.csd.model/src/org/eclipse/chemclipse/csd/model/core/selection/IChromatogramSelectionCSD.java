/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Alexander Kerner - Generics
 *******************************************************************************/
package org.eclipse.chemclipse.csd.model.core.selection;

import org.eclipse.chemclipse.csd.model.core.IChromatogramCSD;
import org.eclipse.chemclipse.csd.model.core.IScanCSD;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;

public interface IChromatogramSelectionCSD extends IChromatogramSelection {

	/**
	 * Returns the stored chromatogram.
	 * May return null.
	 *
	 * @return {@link IChromatogramCSD}
	 */
	@Override
	IChromatogramCSD getChromatogram();

	/**
	 * Returns the selected scan of the current chromatogram or null, if none is
	 * stored.
	 *
	 * @return {@link IScanCSD}
	 */
	@Override
	IScanCSD getSelectedScan();

	/**
	 * Sets the selected scan of the current chromatogram.<br/>
	 * The scan must not be null.
	 */
	void setSelectedScan(IScanCSD selectedScan);

	/**
	 * Use this convenient method, if you don't want to fire and update.
	 *
	 * @param selectedScan
	 * @param update
	 */
	void setSelectedScan(IScanCSD selectedScan, boolean update);
}
