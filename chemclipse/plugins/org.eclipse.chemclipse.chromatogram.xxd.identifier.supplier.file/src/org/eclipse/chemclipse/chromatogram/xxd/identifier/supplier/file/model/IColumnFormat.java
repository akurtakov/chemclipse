/*******************************************************************************
 * Copyright (c) 2018, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.model;

// TODO: move this elsewhere: AMDIS specific format
public interface IColumnFormat {

	String HEADER_VALUE_DELIMITER = "=";
	String RI_VALUE_DELIMITER = " ";

	String COLUMN_MARKER = "#";

	String COLUMN_NAME = "#COLUMN_NAME";
	String COLUMN_LENGTH = "#COLUMN_LENGTH";
	String COLUMN_DIAMETER = "#COLUMN_DIAMETER";
	String COLUMN_PHASE = "#COLUMN_PHASE";
}
