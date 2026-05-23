/*******************************************************************************
 * Copyright (c) 2020, 2026 Lablicate GmbH.
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

/**
 * Describes the criterion to select the peak area:
 * <ul>
 * <li>{@link #AREA_LESS_THAN_MINIMUM}</li>
 * <li>{@link #AREA_GREATER_THAN_MAXIMUM}</li>
 * <li>{@link #AREA_NOT_WITHIN_RANGE}</li>
 * </ul>
 */
public enum AreaCriterion implements ILabel {
	AREA_LESS_THAN_MINIMUM("Area < Minimum"), // Select peak areas smaller than the defined minimum
	AREA_GREATER_THAN_MAXIMUM("Area > Maximum"), // Select peak areas greater than the defined maximum
	AREA_NOT_WITHIN_RANGE("Minimum < Area or Area > Maximum"); // Select peak areas within a specified range, e.g. greater than the defined minimum and smaller than the defined maximum

	private String label;

	private AreaCriterion(String label) {

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
