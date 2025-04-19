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
package org.eclipse.chemclipse.csd.converter.supplier.xy.io;

import org.eclipse.chemclipse.support.text.ILabel;

public enum DelimiterFormat implements ILabel {

	TAB("Tab", "\t"), //
	COMMA("Comma", ","), //
	SEMICOLON("Semicolon", ";"), //
	WHITESPACE("Whitespace", " "); //

	private String label;
	private String value;

	private DelimiterFormat(String label, String value) {

		this.label = label;
		this.value = value;
	}

	@Override
	public String label() {

		return label;
	}

	public String value() {

		return value;
	}

	public static String[][] getOptions() {

		return ILabel.getOptions(values());
	}
}