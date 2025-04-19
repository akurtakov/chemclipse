/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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

public class PeakRetentionTimeComparator implements Comparator<IPeak> {

	private SortOrder sortOrder;

	public PeakRetentionTimeComparator() {

		sortOrder = SortOrder.ASC;
	}

	public PeakRetentionTimeComparator(SortOrder sortOrder) {

		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(IPeak peak1, IPeak peak2) {

		int retentionTime1 = peak1.getPeakModel().getRetentionTimeAtPeakMaximum();
		int retentionTime2 = peak2.getPeakModel().getRetentionTimeAtPeakMaximum();

		int returnValue;
		switch(sortOrder) {
			case ASC:
				returnValue = Integer.compare(retentionTime1, retentionTime2);
				break;
			case DESC:
				returnValue = Integer.compare(retentionTime2, retentionTime1);
				break;
			default:
				returnValue = Integer.compare(retentionTime1, retentionTime2);
				break;
		}
		return returnValue;
	}
}
