/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - add default implementations, adjust API
 *******************************************************************************/
package org.eclipse.chemclipse.msd.model.core;

import java.util.List;

/**
 * This class stores a list of peaks.
 * 
 * @author eselmeister
 * 
 */
public interface IPeaksMSD {

	/**
	 * 
	 * @return the name of this peak list or <code>null</code> if none is available
	 */
	default String getName() {

		return null;
	}

	/**
	 * Adds the peak to the end of the list.
	 * 
	 * @param peak
	 */
	void addPeak(IPeakMSD peak) throws UnsupportedOperationException;

	/**
	 * Removes the peak from the list.
	 * 
	 * @param peak
	 * @return <code>true</code> if peak was removed, <code>false</code> otherwise
	 */
	void removePeak(IPeakMSD peak) throws UnsupportedOperationException;

	/**
	 * Returns the peak with the given number.<br/>
	 * Be aware, the index is 1 based and not 0 based like in a normal list.<br/>
	 * If no peak is available, null will be returned.
	 * 
	 * @param i
	 * @return IPeak
	 */
	default IPeakMSD getPeak(int i) {

		List<IPeakMSD> peaks = getPeaks();
		if(i > 0 && i <= peaks.size()) {
			return peaks.get(--i);
		}
		return null;
	}

	/**
	 * Returns the list of peaks.
	 * 
	 * @return List<IPeak>
	 */
	List<IPeakMSD> getPeaks();

	/**
	 * Returns the number of stored peaks.
	 * 
	 * @return int
	 */
	default int size() {

		return getPeaks().size();
	}

	default boolean isEmpty() {

		return getPeaks().isEmpty();
	}
}
