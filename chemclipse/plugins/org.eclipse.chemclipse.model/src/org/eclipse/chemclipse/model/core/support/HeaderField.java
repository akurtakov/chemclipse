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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.model.core.support;

import java.util.Arrays;

import org.eclipse.chemclipse.support.text.ILabel;

public enum HeaderField implements ILabel {

	DEFAULT("Default"), //
	NAME("Name"), //
	DATA_NAME("Data Name"), //
	SAMPLE_NAME("Sample Name"), //
	SAMPLE_GROUP("Sample Group"), //
	SHORT_INFO("Short Info"), //
	MISC_INFO("Misc Info"), //
	TAGS("Tags"), //
	INSTRUMENT("Instrument"); //

	private String label = "";

	private HeaderField(String label) {

		this.label = label;
	}

	@Override
	public String label() {

		return label;
	}

	public static String[] getItems() {

		return Arrays.stream(HeaderField.values()).map(Enum::name).toArray(String[]::new);
	}

	public static String[][] getOptions() {

		return ILabel.getOptions(values());
	}
}