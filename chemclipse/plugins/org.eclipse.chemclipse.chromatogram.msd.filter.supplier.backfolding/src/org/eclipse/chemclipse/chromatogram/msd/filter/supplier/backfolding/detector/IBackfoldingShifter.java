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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.backfolding.detector;

import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.backfolding.settings.ChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.backfolding.settings.IBackfoldingSettings;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.xic.IExtractedIonSignals;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IBackfoldingShifter {

	/**
	 * Runs the backfolding algorithm on the given chromatogram selection and
	 * returns an {@link IExtractedIonSignals} instance containing the shifted
	 * ions.<br/>
	 * The retention times and scan will be preserved but the distribution of
	 * ions could be different.<br/>
	 * All backfolding settings are stored in {@link IBackfoldingSettings}.<br/>
	 * <br/>
	 * See: "Backfolding applied to differential gas chromatography mass
	 * spectrometry as a mathematical enhancement of chromatographic
	 * resolution", Pool, W. G. and deLeeuw, J. W. and vandeGraaf, B., 1996
	 */
	IExtractedIonSignals shiftIons(IChromatogramSelectionMSD chromatogramSelection, ChromatogramFilterSettings filterSettings, IProgressMonitor monitor);
}
