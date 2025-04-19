/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.xpass.settings;

import java.util.Arrays;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.msd.filter.settings.AbstractMassSpectrumFilterSettings;
import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.xpass.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.msd.model.core.MassSpectrumType;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class LowPassFilterSettings extends AbstractMassSpectrumFilterSettings {

	@JsonProperty(value = "Number Lowest", defaultValue = "5")
	@JsonPropertyDescription(value = "This value defines the number of n lowest ions to be preserved.")
	@IntSettingsProperty(minValue = PreferenceSupplier.MIN_NUMBER_LOWEST, maxValue = PreferenceSupplier.MAX_NUMBER_LOWEST)
	private int numberLowest = PreferenceSupplier.DEF_NUMBER_LOWEST;

	public int getNumberLowest() {

		return numberLowest;
	}

	public void setNumberLowest(int numberLowest) {

		this.numberLowest = numberLowest;
	}

	@Override
	public List<MassSpectrumType> appliesToMassSpectrumTypes() {

		return Arrays.asList(MassSpectrumType.CENTROID);
	}
}
