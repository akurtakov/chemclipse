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

import org.eclipse.chemclipse.support.ui.swt.ExtendedTableViewer;

public interface ITableMenuEntry {

	String getCategory();

	String getName();

	default boolean isEnabled(ExtendedTableViewer extendedTableViewer) {

		return true;
	}

	void execute(ExtendedTableViewer extendedTableViewer);
}
