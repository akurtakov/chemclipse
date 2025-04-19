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
package org.eclipse.chemclipse.support.ui.swt;

import org.eclipse.jface.viewers.ViewerComparator;

public abstract class AbstractRecordTableComparator extends ViewerComparator implements IRecordTableComparator {

	private int propertyIndex = 0;
	private int direction = ASCENDING;

	@Override
	public void setColumn(int column) {

		/*
		 * Toggle the direction if the current
		 * column has been selected.
		 */
		if(column == propertyIndex) {
			direction = 1 - direction;
		} else {
			direction = ASCENDING;
		}
		/*
		 * Set the current property index.
		 */
		propertyIndex = column;
	}

	@Override
	public int getPropertyIndex() {

		return propertyIndex;
	}

	@Override
	public void setPropertyIndex(int propertyIndex) {

		this.propertyIndex = propertyIndex;
	}

	@Override
	public int getDirection() {

		return direction;
	}

	@Override
	public void setDirection(int direction) {

		this.direction = direction;
	}
}
