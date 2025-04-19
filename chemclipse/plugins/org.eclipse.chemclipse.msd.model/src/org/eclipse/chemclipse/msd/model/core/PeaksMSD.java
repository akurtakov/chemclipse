/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.model.core;

import java.util.ArrayList;
import java.util.List;

public class PeaksMSD implements IPeaksMSD {

	List<IPeakMSD> peaks = new ArrayList<>();

	@Override
	public void addPeak(IPeakMSD peak) {

		peaks.add(peak);
	}

	@Override
	public void removePeak(IPeakMSD peak) {

		if(peak != null) {
			peaks.remove(peak);
		}
	}

	@Override
	public List<IPeakMSD> getPeaks() {

		return peaks;
	}
}
