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

public class WavelengthAbundanceComparator implements Comparator<IScanSignalWSD>, Serializable {

	/**
	 * Renew the serialVersionUID any time you have changed some fields or
	 * methods.
	 */
	private static final long serialVersionUID = 2053994137218915007L;
	private SortOrder sortOrder;

	/**
	 * The sort order is per default value ascending.
	 */
	public WavelengthAbundanceComparator() {
		sortOrder = SortOrder.ASC;
	}

	/**
	 * You can choose whether to sort the abundance values ascending (asc) or
	 * descending (desc).
	 * 
	 * @param sortOrder
	 */
	public WavelengthAbundanceComparator(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(IScanSignalWSD scanSignal1, IScanSignalWSD scanSignal2) {

		int returnValue;
		switch(sortOrder) {
			case ASC:
				returnValue = Float.compare(scanSignal1.getAbsorbance(), scanSignal2.getAbsorbance());
				break;
			case DESC:
				returnValue = Float.compare(scanSignal2.getAbsorbance(), scanSignal1.getAbsorbance());
				break;
			default:
				returnValue = Float.compare(scanSignal1.getAbsorbance(), scanSignal2.getAbsorbance());
				break;
		}
		return returnValue;
	}
}
