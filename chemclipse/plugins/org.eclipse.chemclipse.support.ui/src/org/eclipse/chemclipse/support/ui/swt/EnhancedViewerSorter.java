/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.swt;

import org.eclipse.jface.viewers.ViewerComparator;

public class EnhancedViewerSorter extends ViewerComparator {

	public static final int ASCENDING = 0;
	private int propertyIndex = -1;
	private int direction = ASCENDING;

	public EnhancedViewerSorter() {

		propertyIndex = 0;
		direction = ASCENDING;
	}

	public void setColumn(int column) {

		/*
		 * Toggle the direction
		 */
		if(column == propertyIndex) {
			direction = 1 - direction;
		} else {
			direction = ASCENDING;
		}
		propertyIndex = column;
	}

	public int getPropertyIndex() {

		return propertyIndex;
	}

	public int getDirection() {

		return direction;
	}
}
