/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.pcr.report.supplier.tabular.model;

public enum LogicalOperator {

	AND, //
	OR, //
	IDENTITY;

	public static LogicalOperator parse(String input) {

		if(input.contains("&")) {
			return LogicalOperator.AND;
		} else if(input.contains("/")) {
			return LogicalOperator.OR;
		} else if(input.contains("$")) {
			return LogicalOperator.IDENTITY;
		}
		return null;
	}
}