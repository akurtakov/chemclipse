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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.savitzkygolay.settings;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.msd.filter.settings.AbstractMassSpectrumFilterSettings;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.savitzkygolay.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.msd.model.core.MassSpectrumType;
import org.eclipse.chemclipse.support.literature.LiteratureReference;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MassSpectrumFilterSettings extends AbstractMassSpectrumFilterSettings {

	private static final Logger logger = Logger.getLogger(MassSpectrumFilterSettings.class);

	@JsonProperty(value = "Order", defaultValue = "2")
	@IntSettingsProperty(minValue = PreferenceSupplier.MIN_ORDER, maxValue = PreferenceSupplier.MAX_ORDER)
	private int order = 2;

	@JsonProperty(value = "Width", defaultValue = "5")
	@IntSettingsProperty(minValue = PreferenceSupplier.MIN_WIDTH, maxValue = PreferenceSupplier.MAX_WIDTH)
	private int width = 5;

	public int getDerivative() {

		return 0;
	}

	public void setDerivative(int derivative) {

		if(derivative != 0) {
			logger.warn("Derivative is not supported");
		}
	}

	public int getOrder() {

		return order;
	}

	public void setOrder(int order) {

		this.order = order;
	}

	public int getWidth() {

		return width;
	}

	public void setWidth(int width) {

		this.width = width;
	}

	@Override
	public List<LiteratureReference> getLiteratureReferences() {

		return Collections.singletonList(createLiteratureReference("achs_ancham36_1627.ris", "10.1021/ac60214a047"));
	}

	private static LiteratureReference createLiteratureReference(String file, String doi) {

		String content;
		try {
			content = new String(ChromatogramFilterSettings.class.getResourceAsStream(file).readAllBytes());
		} catch(IOException | NullPointerException e) {
			content = doi;
			logger.warn(e);
		}
		return new LiteratureReference(content);
	}

	@Override
	public List<MassSpectrumType> appliesToMassSpectrumTypes() {

		return Arrays.asList(MassSpectrumType.PROFILE);
	}
}
