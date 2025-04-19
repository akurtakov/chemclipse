/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.tsd.model.support;

import java.text.DecimalFormat;

import org.eclipse.chemclipse.support.text.ValueFormat;

public class TraceRangeSupport {

	public static final DecimalFormat DF_COLUMN_1_MINUTES = ValueFormat.getDecimalFormatEnglish("0.00##");
	public static final DecimalFormat DF_COLUMN_2_SECONDS = ValueFormat.getDecimalFormatEnglish("0");
}