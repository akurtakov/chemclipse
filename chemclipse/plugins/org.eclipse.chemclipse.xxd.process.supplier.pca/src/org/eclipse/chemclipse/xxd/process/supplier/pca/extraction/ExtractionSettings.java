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
package org.eclipse.chemclipse.xxd.process.supplier.pca.extraction;

import org.eclipse.chemclipse.xxd.process.supplier.pca.core.ExtractionOption;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.ValueOption;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.DescriptionOption;

public class ExtractionSettings {

	private DescriptionOption descriptionOption = DescriptionOption.NAME;
	private ExtractionOption extractionOption = ExtractionOption.RETENTION_TIME_MS;
	private ValueOption valueOption = ValueOption.AREA;
	private int groupValueWindow = 0;

	public ExtractionSettings(DescriptionOption descriptionOption, ExtractionOption extractionOption, ValueOption valueOption, int groupValueWindow) {

		this.descriptionOption = descriptionOption;
		this.extractionOption = extractionOption;
		this.valueOption = valueOption;
		this.groupValueWindow = groupValueWindow;
	}

	public DescriptionOption getDescriptionOption() {

		return descriptionOption;
	}

	public ExtractionOption getExtractionOption() {

		return extractionOption;
	}

	public ValueOption getValueOption() {

		return valueOption;
	}

	public int getGroupValueWindow() {

		return groupValueWindow;
	}
}