/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - added labels
 *******************************************************************************/
package org.eclipse.chemclipse.support.model;

import org.eclipse.chemclipse.support.text.ILabel;

public enum SeparationColumnType implements ILabel {

	/*
	 * These are the basic 3 column types and the default
	 * to supply a generic option. Specific columns share
	 * be mapped to either one of these 4 types.
	 */
	DEFAULT("Default"), //
	POLAR("polar"), //
	NON_POLAR("non-polar (apolar)"), // Replacement for RetentionIndexType.APOLAR and APOLAR("non-polar")
	SEMI_POLAR("semi-polar"); // Replacement for RetentionIndexType.SEMIPOLAR

	private String label = "";

	private SeparationColumnType(String label) {

		this.label = label;
	}

	@Override
	public String label() {

		return label;
	}

	public static String[] getItems() {

		return ILabel.getItems(values());
	}

	public static String[][] getOptions() {

		return ILabel.getOptions(values());
	}
}