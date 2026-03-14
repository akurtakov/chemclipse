/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.core;

import org.eclipse.chemclipse.support.text.ILabel;

public enum ReagentGas implements ILabel {

	PROTONATION("[M+H]+", 1), //
	AMMONIUM_ADDUCT("[M+NH4]+", 18), //
	SODIUM_ADDUCT("[M+Na]+", 23), //
	POTASSIUM_ADDUCT("[M+K]+", 39), //
	HYDRIDE_ABSTRACTION("[M-H]+", -1), //
	DEPROTONATION("[M-H]-", -1), //
	ELECTRON_CAPTURE("[M-]", 0); //

	private String label;
	private int massShift;

	private ReagentGas(String label, int massShift) {

		this.label = label;
		this.massShift = massShift;
	}

	@Override
	public String label() {

		return label;
	}

	public int massShift() {

		return massShift;
	}

	public static String[][] getOptions() {

		return ILabel.getOptions(values());
	}
}