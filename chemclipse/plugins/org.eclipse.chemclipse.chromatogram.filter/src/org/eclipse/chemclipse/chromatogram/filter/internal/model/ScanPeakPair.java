/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.filter.internal.model;

import org.eclipse.chemclipse.model.core.IPeak;

/**
 * Used when transferring scan targets to peaks.
 */
public class ScanPeakPair {

	private IdentifiedScan identifiedScan = null;
	private IPeak peak = null;
	private int retentionTimeDelta = 0;

	public ScanPeakPair(IdentifiedScan identifiedScan, IPeak peak) {

		this.identifiedScan = identifiedScan;
		this.peak = peak;
		this.retentionTimeDelta = Math.abs(identifiedScan.getScan().getRetentionTime() - peak.getPeakModel().getPeakMaximum().getRetentionTime());
	}

	public IdentifiedScan getIdentifiedScan() {

		return identifiedScan;
	}

	public IPeak getPeak() {

		return peak;
	}

	public int getRetentionTimeDelta() {

		return retentionTimeDelta;
	}
}