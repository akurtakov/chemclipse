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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.filter.supplier.normalizer.settings;

import java.util.Arrays;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.msd.filter.settings.AbstractMassSpectrumFilterSettings;
import org.eclipse.chemclipse.msd.model.core.MassSpectrumType;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MassSpectrumFilterSettings extends AbstractMassSpectrumFilterSettings {

	@JsonProperty(value = "Averages Type", defaultValue = "MEAN")
	private AveragesType averagesType = AveragesType.MEAN;

	public AveragesType getAveragesType() {

		return averagesType;
	}

	public void setAveragesType(AveragesType averagesType) {

		this.averagesType = averagesType;
	}

	@Override
	public List<MassSpectrumType> appliesToMassSpectrumTypes() {

		return Arrays.asList(MassSpectrumType.PROFILE);
	}
}
