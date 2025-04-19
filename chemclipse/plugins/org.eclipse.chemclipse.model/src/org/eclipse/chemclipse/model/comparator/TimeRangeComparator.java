/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.model.ranges.TimeRange;

public class TimeRangeComparator implements Comparator<TimeRange> {

	@Override
	public int compare(TimeRange timeRange1, TimeRange timeRange2) {

		int result = Integer.compare(timeRange1.getStart(), timeRange2.getStart());
		if(result == 0) {
			result = Integer.compare(timeRange1.getStop(), timeRange2.getStop());
			if(result == 0) {
				result = timeRange1.getIdentifier().compareTo(timeRange2.getIdentifier());
			}
		}
		return result;
	}
}
