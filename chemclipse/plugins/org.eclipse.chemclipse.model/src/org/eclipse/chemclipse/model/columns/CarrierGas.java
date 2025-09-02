/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.columns;

import org.eclipse.chemclipse.support.text.ILabel;

public enum CarrierGas implements ILabel {

	HELIUM("Helium", "He"), //
	HYDROGEN("Hydrogen", "H2"), //
	NITROGEN("Nitrogen", "N2");

	private String label = "";
	private String formula = "";

	private CarrierGas(String label, String formula) {

		this.label = label;
		this.formula = formula;
	}

	@Override
	public String label() {

		return label;
	}

	public String formula() {

		return formula;
	}
}