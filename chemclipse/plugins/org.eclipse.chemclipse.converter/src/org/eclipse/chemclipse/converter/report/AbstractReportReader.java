/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.converter.report;

public abstract class AbstractReportReader implements IReportReader {

	public String parseInteger(String cell) {

		int value = Integer.parseInt(cell.trim());
		return Integer.toString(value);
	}

	public String parseDouble(String cell) {

		double value = Double.parseDouble(cell.trim());
		return Double.toString(value);
	}
}
