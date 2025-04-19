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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.converter.model;

import java.util.List;

public interface IReportRowModel extends List<List<String>> {

	/**
	 * Returns -1 of the column identified by the name can't be found.
	 * It is assumed that the first row contains the column header.
	 * 
	 * @param columnName
	 * @return int
	 */
	int getColumnIndex(String columnName);
}
