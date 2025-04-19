/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Dr. Janos Binder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.model.core.comparator;

import java.io.Serializable;
import java.util.Comparator;

import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.support.comparator.SortOrder;

public class IonCombinedComparator implements Comparator<IIon>, Serializable {

	private static final long serialVersionUID = -109573471700765379L;
	private final Comparator<IIon> firstComparator;
	private final Comparator<IIon> secondComparator;

	/**
	 * The sort order is per default value ascending.
	 */
	public IonCombinedComparator(IonComparatorMode ionComparatorMode) {
		this(ionComparatorMode, SortOrder.ASC);
	}

	public IonCombinedComparator(IonComparatorMode ionComparatorMode, SortOrder sortOrder) {
		switch(ionComparatorMode) {
			case ABUNDANCE_FIRST:
				firstComparator = new IonAbundanceComparator(sortOrder);
				secondComparator = new IonValueComparator(sortOrder);
				break;
			case MZ_FIRST:
				firstComparator = new IonValueComparator(sortOrder);
				secondComparator = new IonAbundanceComparator(sortOrder);
				break;
			default:
				firstComparator = new IonAbundanceComparator(sortOrder);
				secondComparator = new IonValueComparator(sortOrder);
				break;
		}
	}

	@Override
	public int compare(IIon ion1, IIon ion2) {

		int result = firstComparator.compare(ion1, ion2);
		if(result != 0) {
			return result;
		}
		result = secondComparator.compare(ion1, ion2);
		return result;
	}
}
