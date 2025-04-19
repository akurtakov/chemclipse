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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.model.targets;

import org.eclipse.chemclipse.support.text.ILabel;

public enum DisplayOption implements ILabel {

	STANDARD("Standard"), //
	NUMBERS("Numbers"), //
	NUMBERS_STANDARD("Numbers [Display Field]"), //
	RETENTION_TIME("Retention Time"), //
	RETENTION_TIME_STANDARD("Retention Time [Display Field]"), //
	RETENTION_INDEX("Retention Index"), //
	RETENTION_INDEX_STANDARD("Retention Index [Display Field]"), //
	RETENTION_INDEX_AREA_PERCENT("Retention Index (Area%)"), //
	AREA_PERCENT("Area%"), //
	AREA_PERCENT_STANDARD("Area% [Display Field]"); //

	private String label = "";

	private DisplayOption(String label) {

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