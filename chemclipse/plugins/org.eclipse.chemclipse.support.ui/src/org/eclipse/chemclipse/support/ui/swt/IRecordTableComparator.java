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

import org.eclipse.jface.viewers.Viewer;

public interface IRecordTableComparator {

	int ASCENDING = 0;
	int DESCENDING = -1;

	void setColumn(int column);

	int compare(Viewer viewer, Object e1, Object e2);

	int getPropertyIndex();

	int getDirection();

	void setPropertyIndex(int propertyIndex);

	void setDirection(int direction);
}