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
package org.eclipse.chemclipse.wsd.model.comparator;

import java.io.Serializable;
import java.util.Comparator;

import org.eclipse.chemclipse.support.comparator.SortOrder;
import org.eclipse.chemclipse.wsd.model.core.IScanSignalWSD;

/**
 * This is the comparator to sort an list of ion values by its ion
 * value.
 */
public class WavelengthValueComparator implements Comparator<IScanSignalWSD>, Serializable {

	/**
	 * Renew the serialVersionUID any time you have changed some fields or
	 * methods.
	 */
	private static final long serialVersionUID = 8463067630896954737L;
	private SortOrder sortOrder;

	public WavelengthValueComparator() {
		sortOrder = SortOrder.ASC;
	}

	public WavelengthValueComparator(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(IScanSignalWSD scanSignal1, IScanSignalWSD scanSignal2) {

		int returnValue;
		switch(sortOrder) {
			case ASC:
				returnValue = Double.compare(scanSignal1.getWavelength(), scanSignal2.getWavelength());
				break;
			case DESC:
				returnValue = Double.compare(scanSignal2.getWavelength(), scanSignal1.getWavelength());
				break;
			default:
				returnValue = Double.compare(scanSignal1.getWavelength(), scanSignal2.getWavelength());
				break;
		}
		return returnValue;
	}
}
