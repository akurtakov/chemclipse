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
package org.eclipse.chemclipse.wsd.model.xwc;

import java.util.Comparator;

import org.eclipse.chemclipse.support.comparator.SortOrder;

@Deprecated
public class ExtractedWavelengthSignalComparator implements Comparator<IExtractedWavelengthSignal> {

	private SortOrder sortOrder = SortOrder.ASC;

	public ExtractedWavelengthSignalComparator(SortOrder sortOrder) {
		if(sortOrder != null) {
			this.sortOrder = sortOrder;
		}
	}

	@Override
	public int compare(IExtractedWavelengthSignal signal1, IExtractedWavelengthSignal signal2) {

		int result = 0;
		if(signal1 == null || signal2 == null) {
			return 0;
		}
		if(signal1.getRetentionTime() == signal2.getRetentionTime()) {
			result = 0;
		}
		switch(sortOrder) {
			case ASC:
				result = signal2.getRetentionTime() - signal1.getRetentionTime();
				break;
			case DESC:
				result = signal1.getRetentionTime() - signal2.getRetentionTime();
				break;
			default:
				result = signal2.getRetentionTime() - signal1.getRetentionTime();
		}
		return result;
	}
}
