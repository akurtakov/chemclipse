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
package org.eclipse.chemclipse.converter.comparators;

import java.util.Comparator;

import org.eclipse.chemclipse.converter.model.reports.IReport;

public class ReportComparator implements Comparator<IReport<?>> {

	@Override
	public int compare(IReport<?> report1, IReport<?> report2) {

		return Integer.compare(report1.getReportNumber(), report2.getReportNumber());
	}
}
