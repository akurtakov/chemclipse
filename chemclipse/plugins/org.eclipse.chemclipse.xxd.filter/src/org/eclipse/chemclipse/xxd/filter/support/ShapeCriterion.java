/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Alexander Stark - initial API and implementation
 * Philip Wenig - refactoring ILabel support
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.filter.support;

import org.eclipse.chemclipse.support.text.ILabel;

public enum ShapeCriterion implements ILabel {
	LEADING_SMALLER_THAN_LIMIT("Leading < Limit"), // Select peaks whose leading values smaller than the limit
	TAILING_GREATER_THAN_LIMIT("Tailing > Limit"), // Select peaks whose tailing values are larger than the limit
	VALUES_WITHIN_RANGE("Leading >= Shape <= Tailing"); // Select peaks whose values are within the defined range, e.g. greater or equal to leading and smaller or equal to tailing

	private String label;

	private ShapeCriterion(String label) {

		this.label = label;
	}

	@Override
	public String label() {

		return label;
	}

	public static String[][] getOptions() {

		return ILabel.getOptions(values());
	}
}
