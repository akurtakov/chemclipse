/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.core;

/**
 * This class stores two ions.<br/>
 * The lowest ion is the one with the lowest ion of a mass spectrum,
 * the highest with the highest ion of a mass spectrum.
 * 
 * @author eselmeister
 */
public class IonBounds implements IIonBounds {

	private IIon lowestIon = null;
	private IIon highestIon = null;

	/**
	 * The lowestIon is the ion with the lowest ion value of
	 * the scan you have received this object from.<br/>
	 * The highestIon is the ion with the highest ion value
	 * from the scan.<br/>
	 * 
	 * @param lowestIon
	 * @param highestIon
	 */
	public IonBounds(IIon lowestIon, IIon highestIon) {
		if(lowestIon != null && highestIon != null) {
			/*
			 * Change the order if necessary.
			 */
			if(lowestIon.getIon() > highestIon.getIon()) {
				this.highestIon = lowestIon;
				this.lowestIon = highestIon;
			} else {
				this.lowestIon = lowestIon;
				this.highestIon = highestIon;
			}
		}
	}

	@Override
	public IIon getLowestIon() {

		return lowestIon;
	}

	@Override
	public IIon getHighestIon() {

		return highestIon;
	}
}
