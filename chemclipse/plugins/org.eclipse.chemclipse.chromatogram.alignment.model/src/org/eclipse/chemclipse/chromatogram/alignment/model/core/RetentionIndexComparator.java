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
package org.eclipse.chemclipse.chromatogram.alignment.model.core;

import java.util.Comparator;

import org.eclipse.chemclipse.support.comparator.SortOrder;

public class RetentionIndexComparator implements Comparator<IRetentionIndex> {

	private SortOrder sortOrder;

	public RetentionIndexComparator() {
		sortOrder = SortOrder.ASC;
	}

	public RetentionIndexComparator(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(IRetentionIndex retentionIndex1, IRetentionIndex retentionIndex2) {

		int returnValue;
		switch(sortOrder) {
			case ASC:
				returnValue = Float.compare(retentionIndex1.getIndex(), retentionIndex2.getIndex());
				break;
			case DESC:
				returnValue = Float.compare(retentionIndex2.getIndex(), retentionIndex1.getIndex());
				break;
			default:
				returnValue = Float.compare(retentionIndex1.getIndex(), retentionIndex2.getIndex());
				break;
		}
		return returnValue;
	}
}
