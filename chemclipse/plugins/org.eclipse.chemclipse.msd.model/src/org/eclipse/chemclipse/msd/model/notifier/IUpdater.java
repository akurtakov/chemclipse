/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.notifier;

import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;

/**
 * Returns the actual chromatogram selection. It useful if a e.g. filter is
 * loaded when one of its classes is loaded.<br/>
 * The static updatee still holds the fired chromatogram selection reference.<br/>
 * If the filter handler is dynamically created, it can directly hold the
 * chromatogram selection object from its static inner class.<br/>
 * See org.eclipse.chemclipse.chromatogram.msd.filter.supplier.normalizer.ui ->
 * FilterHandler
 */
public interface IUpdater {

	/**
	 * Returns the actual chromatogram selection.
	 * 
	 * @return {@link IChromatogramSelectionMSD}
	 */
	IChromatogramSelectionMSD getChromatogramSelection();
}
