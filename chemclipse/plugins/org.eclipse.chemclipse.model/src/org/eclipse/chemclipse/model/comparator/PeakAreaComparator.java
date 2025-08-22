/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.comparator;

import java.util.Comparator;

import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.support.comparator.SortOrder;

public class PeakAreaComparator implements Comparator<IPeak> {

	private SortOrder sortOrder;

	public PeakAreaComparator() {
		sortOrder = SortOrder.ASC;
	}

	public PeakAreaComparator(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(IPeak peak1, IPeak peak2) {

		double integratedArea1 = peak1.getIntegratedArea();
		double integratedArea2 = peak2.getIntegratedArea();

		int returnValue;
		switch(sortOrder) {
			case ASC:
				returnValue = Double.compare(integratedArea1, integratedArea2);
				break;
			case DESC:
				returnValue = Double.compare(integratedArea2, integratedArea1);
				break;
			default:
				returnValue = Double.compare(integratedArea1, integratedArea2);
				break;
		}
		return returnValue;
	}
}
