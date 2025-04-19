/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.wsd.model.core;

public class WavelengthBounds implements IWavelengthBounds {

	private IScanSignalWSD lowestWavelength = null;
	private IScanSignalWSD highestWavelength = null;

	public WavelengthBounds(IScanSignalWSD lowestWavelength, IScanSignalWSD highestWavelength) {
		if(lowestWavelength != null && highestWavelength != null) {
			/*
			 * Change the order if necessary.
			 */
			if(lowestWavelength.getWavelength() > highestWavelength.getWavelength()) {
				this.highestWavelength = lowestWavelength;
				this.lowestWavelength = highestWavelength;
			} else {
				this.lowestWavelength = lowestWavelength;
				this.highestWavelength = highestWavelength;
			}
		}
	}

	@Override
	public IScanSignalWSD getLowestWavelength() {

		return lowestWavelength;
	}

	@Override
	public IScanSignalWSD getHighestWavelength() {

		return highestWavelength;
	}
}
