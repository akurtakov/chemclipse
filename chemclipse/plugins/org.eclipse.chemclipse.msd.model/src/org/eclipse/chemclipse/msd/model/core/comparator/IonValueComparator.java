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
package org.eclipse.chemclipse.msd.model.core.comparator;

import java.io.Serializable;
import java.util.Comparator;

import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.support.comparator.SortOrder;

/**
 * This is the comparator to sort an list of ion values by its ion
 * value.
 */
public class IonValueComparator implements Comparator<IIon>, Serializable {

	/**
	 * Renew the serialVersionUID any time you have changed some fields or
	 * methods.
	 */
	private static final long serialVersionUID = 1727218244178920202L;
	private SortOrder sortOrder;

	public IonValueComparator() {
		sortOrder = SortOrder.ASC;
	}

	public IonValueComparator(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(IIon ion1, IIon ion2) {

		int returnValue;
		switch(sortOrder) {
			case ASC:
				returnValue = Double.compare(ion1.getIon(), ion2.getIon());
				break;
			case DESC:
				returnValue = Double.compare(ion2.getIon(), ion1.getIon());
				break;
			default:
				returnValue = Double.compare(ion1.getIon(), ion2.getIon());
				break;
		}
		return returnValue;
	}
}
