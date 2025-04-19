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
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.swt;

import java.util.Set;

public interface TableConfig {

	/**
	 * Set what columns should be visible
	 * 
	 * @param visibleColumns
	 */
	void setVisibleColumns(Set<String> visibleColumns);

	/**
	 * 
	 * @return a set of columns available for this table config
	 */
	Set<String> getColumns();

	int getColumWidth(String column);

	void setColumWidth(String column, int width);
}
