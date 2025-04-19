/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Dr. Janos Binder - locale dependent implementation
 * Dr. Alexander Kerner - implementation
 *******************************************************************************/
package org.eclipse.chemclipse.support.ui.provider;

import java.text.DecimalFormat;

import org.eclipse.chemclipse.support.text.ValueFormat;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;

public abstract class AbstractChemClipseLabelProvider extends ColumnLabelProvider implements ITableLabelProvider {

	private DecimalFormat decimalFormat;

	/**
	 * The pattern "0.000" is used by default.
	 */
	protected AbstractChemClipseLabelProvider() {

		getDecimalFormatInstance("0.000");
	}

	/**
	 * Add a valid decimal format pattern, e.g. "0.###" or "0.0##".
	 * 
	 * @param pattern
	 */
	protected AbstractChemClipseLabelProvider(String pattern) {

		getDecimalFormatInstance(pattern);
	}

	private void getDecimalFormatInstance(String pattern) {

		decimalFormat = ValueFormat.getDecimalFormatEnglish(pattern);
	}

	public DecimalFormat getScientificDecimalFormatInstance() {

		return ValueFormat.getDecimalFormatEnglish("0.###E0");
	}

	public DecimalFormat getIntegerDecimalFormatInstance() {

		return ValueFormat.getDecimalFormatEnglish("0");
	}

	public DecimalFormat getDecimalFormat() {

		return decimalFormat;
	}
}