/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.jcampdx.io;

public enum DataTypeXY {

	X_INCREMENTAL_Y_RANGE("(X++(Y..Y))"), //
	XY_RANGE("(XY..XY)"), //
	X_COMMA_Y("(X,Y)"), //
	UNKNOWN("");

	private final String dataType;

	DataTypeXY(String dataType) {

		this.dataType = dataType;
	}

	public static DataTypeXY fromHeaderLine(String headerLine) {

		if(headerLine == null) {
			return UNKNOWN;
		}

		if(headerLine.contains("(X++(Y..Y))")) {
			return X_INCREMENTAL_Y_RANGE;
		}
		if(headerLine.contains("(XY..XY)")) {
			return XY_RANGE;
		}
		if(headerLine.contains("(X,Y)")) {
			return X_COMMA_Y;
		}

		return UNKNOWN;
	}

	public String getDataType() {

		return dataType;
	}
}
