/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.numeric.core;

import java.util.Comparator;

/**
 * This comparator compares the x values of an {@link IPoint} instance.
 */
public class PointXComparator implements Comparator<IPoint> {

	@Override
	public int compare(IPoint point1, IPoint point2) {

		if(point1 == null || point2 == null) {
			return 0;
		}

		return Double.compare(point1.getX(), point2.getX());
	}
}
