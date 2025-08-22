/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.model.core;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.chemclipse.model.support.IAnalysisSegment;
import org.eclipse.chemclipse.model.support.IScanRange;

public class ChromatogramAnalysisSegment implements IAnalysisSegment {

	private final IScanRange scanRange;
	private final IChromatogram chromatogram;
	private final Collection<? extends IAnalysisSegment> children;

	public ChromatogramAnalysisSegment(IScanRange scanRange, IChromatogram chromatogram, Collection<? extends IAnalysisSegment> children) {

		this.scanRange = scanRange;
		this.chromatogram = chromatogram;
		this.children = children;
	}

	@Override
	public Collection<? extends IAnalysisSegment> getChildSegments() {

		if(children == null) {
			return Collections.emptyList();
		}

		return children;
	}

	public IChromatogram getChromatogram() {

		return chromatogram;
	}

	@Override
	public int getStartScan() {

		int startScan = scanRange.getStartScan();
		if(startScan < 1) {
			return 1;
		}

		return startScan;
	}

	@Override
	public int getStopScan() {

		int stopScan = scanRange.getStopScan();
		if(stopScan < getStartScan()) {
			return chromatogram.getNumberOfScans();
		}

		return stopScan;
	}

	@Override
	public int getStartRetentionTime() {

		return chromatogram.getScan(getStartScan()).getRetentionTime();
	}

	@Override
	public int getStopRetentionTime() {

		return chromatogram.getScan(getStopScan()).getRetentionTime();
	}
}
