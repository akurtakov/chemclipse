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
package org.eclipse.chemclipse.xxd.filter.chromatogram.settings;

import org.eclipse.chemclipse.msd.model.core.ReagentGas;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ChemIonizationTransferFilterSettings extends TransferFilterSettings {

	@JsonProperty(value = "Reagent Gas", defaultValue = "PROTONATION")
	@JsonPropertyDescription(value = "Select the used reagent gas to apply the mass shift when creating a target.")
	private ReagentGas reagentGas = ReagentGas.PROTONATION;

	public ReagentGas getReagentGas() {

		return reagentGas;
	}

	public void setReagentGas(ReagentGas reagentGas) {

		this.reagentGas = reagentGas;
	}
}