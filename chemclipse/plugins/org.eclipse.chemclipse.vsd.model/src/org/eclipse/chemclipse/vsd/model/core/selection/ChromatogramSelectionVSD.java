/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.vsd.model.core.selection;

import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.exceptions.ChromatogramIsNullException;
import org.eclipse.chemclipse.model.notifier.UpdateNotifier;
import org.eclipse.chemclipse.model.selection.AbstractChromatogramSelection;
import org.eclipse.chemclipse.vsd.model.core.IChromatogramVSD;
import org.eclipse.chemclipse.vsd.model.core.IScanVSD;

public class ChromatogramSelectionVSD extends AbstractChromatogramSelection implements IChromatogramSelectionVSD {

	public ChromatogramSelectionVSD(IChromatogramVSD chromatogram) throws ChromatogramIsNullException {

		this(chromatogram, true);
	}

	public ChromatogramSelectionVSD(IChromatogramVSD chromatogram, boolean fireUpdate) throws ChromatogramIsNullException {

		super(chromatogram);
		reset(fireUpdate);
	}

	@Override
	public IScanVSD getSelectedScan() {

		if(super.getSelectedScan() instanceof IScanVSD scanVSD) {
			return scanVSD;
		}

		return null;
	}

	@Override
	public void reset() {

		reset(true);
	}

	@Override
	public void reset(boolean fireUpdate) {

		super.reset(fireUpdate);
		IChromatogram chromatogram = getChromatogram();
		/*
		 * Scan
		 */
		if(chromatogram.getNumberOfScans() >= 1) {
			if(chromatogram instanceof IChromatogramVSD chromatogramISD) {
				setSelectedScan(chromatogramISD.getScan(1), fireUpdate);
			}
		} else {
			setSelectedScan(null, fireUpdate);
		}
		/*
		 * Fire an update.
		 */
		if(fireUpdate) {
			UpdateNotifier.update(this);
		}
	}

	@Override
	public void fireUpdateChange(boolean forceReload) {

		UpdateNotifier.update(this);
	}

	@Override
	public void update(boolean forceReload) {

		super.update(forceReload);
		fireUpdateChange(forceReload);
	}

	@Override
	public IChromatogramVSD getChromatogram() {

		IChromatogram chromatogram = super.getChromatogram();
		if(chromatogram instanceof IChromatogramVSD chromatogramVSD) {
			return chromatogramVSD;
		}
		return null;
	}
}
