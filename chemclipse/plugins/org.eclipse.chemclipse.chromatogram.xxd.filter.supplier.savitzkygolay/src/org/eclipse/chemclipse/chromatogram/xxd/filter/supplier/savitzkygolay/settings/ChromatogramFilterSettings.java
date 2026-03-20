/*******************************************************************************
 * Copyright (c) 2015, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Lorenz Gerber - Ion-wise savitzky-golay on msd data
 * Matthias Mailänder - validate the width
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.savitzkygolay.settings;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.support.literature.LiteratureReference;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty.Validation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ChromatogramFilterSettings extends AbstractChromatogramFilterSettings {

	private static final Logger logger = Logger.getLogger(ChromatogramFilterSettings.class);

	@JsonProperty(value = "Order", defaultValue = "2")
	@JsonPropertyDescription(value = "Order p of the polynomial to be fitted: Integer in the range from 2 to 5")
	@IntSettingsProperty(minValue = 2, maxValue = 5)
	private int order = 2;

	@JsonProperty(value = "Width", defaultValue = "5")
	@JsonPropertyDescription(value = "Filter width, uneven integer in the range from 5 to 51")
	@IntSettingsProperty(minValue = 5, maxValue = 51, validation = Validation.ODD_NUMBER)
	private int width = 5;

	@JsonIgnore
	private int derivative = 0;

	public int getDerivative() {

		return derivative;
	}

	public void setDerivative(int derivative) {

		this.derivative = derivative;
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
}
