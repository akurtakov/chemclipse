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
 * This is the comparator to sort an list of ion values by its
 * abundance.
 * 
 * @author eselmeister
 */
public class IonAbundanceComparator implements Comparator<IIon>, Serializable {

	/**
	 * Renew the serialVersionUID any time you have changed some fields or
	 * methods.
	 */
	private static final long serialVersionUID = -654515618249449848L;
	private SortOrder sortOrder;

	/**
	 * The sort order is per default value ascending.
	 */
	public IonAbundanceComparator() {
		sortOrder = SortOrder.ASC;
	}

	/**
	 * You can choose whether to sort the abundance values ascending (asc) or
	 * descending (desc).
	 * 
	 * @param sortOrder
	 */
	public IonAbundanceComparator(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(IIon ion1, IIon ion2) {

		int returnValue;
		switch(sortOrder) {
			case ASC:
				returnValue = Float.compare(ion1.getAbundance(), ion2.getAbundance());
				break;
			case DESC:
				returnValue = Float.compare(ion2.getAbundance(), ion1.getAbundance());
				break;
			default:
				returnValue = Float.compare(ion1.getAbundance(), ion2.getAbundance());
				break;
		}
		return returnValue;
	}
}
