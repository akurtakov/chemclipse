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
package org.eclipse.chemclipse.converter.model.reports;

import java.util.List;

public interface IReports<T> extends List<T>, IFileAttributes {

	/**
	 * May return null.
	 * 
	 * @param number
	 * @return Report
	 */
	T getReport(int number);

	/**
	 * Returns the report with the highest number.
	 * May return null.
	 * 
	 * @param number
	 * @return Report
	 */
	T getReportFinal();
}