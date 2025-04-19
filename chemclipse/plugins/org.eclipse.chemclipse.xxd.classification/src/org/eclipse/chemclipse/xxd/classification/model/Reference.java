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
package org.eclipse.chemclipse.xxd.classification.model;

import java.util.Arrays;

import org.eclipse.chemclipse.support.text.ILabel;

public enum Reference implements ILabel {

	NAME("Name"), //
	CAS("CAS"), //
	REFERENCE_ID("Reference Id"); //

	private String label;

	private Reference(String label) {

		this.label = label;
	}

	@Override
	public String label() {

		return label;
	}

	public static String[][] getOptions() {

		return ILabel.getOptions(values());
	}

	public static String[] getItems() {

		return Arrays.stream(Reference.values()).map(Enum::name).toList().toArray(new String[Reference.values().length]);
	}
}
