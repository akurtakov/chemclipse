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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.filter.support;

import org.eclipse.chemclipse.support.text.ILabel;

public enum TargetsDeleteOption implements ILabel {

	ALL_TARGETS("All Targets"), //
	UNVERIFIED_TARGETS("Unverified Targets"), //
	EMPTY_SMILES("Targets without SMILES"), //
	PROPERTY_IDENTIFIER("By Property (Identifier)");

	private String label = "";

	private TargetsDeleteOption(String label) {

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