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
package org.eclipse.chemclipse.support.ui.menu;

import java.util.Comparator;

public class TableMenuEntryComparator implements Comparator<ITableMenuEntry> {

	@Override
	public int compare(ITableMenuEntry tableMenuEntry0, ITableMenuEntry tableMenuEntry1) {

		return tableMenuEntry0.getName().compareTo(tableMenuEntry1.getName());
	}
}
