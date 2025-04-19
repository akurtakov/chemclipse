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
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.charts;

import java.util.Comparator;

public class BarSeriesYComparator implements Comparator<BarSeriesValue> {

	@Override
	public int compare(BarSeriesValue barSeriesIon1, BarSeriesValue barSeriesIon2) {

		return Double.compare(barSeriesIon2.getY(), barSeriesIon1.getY());
	}
}
