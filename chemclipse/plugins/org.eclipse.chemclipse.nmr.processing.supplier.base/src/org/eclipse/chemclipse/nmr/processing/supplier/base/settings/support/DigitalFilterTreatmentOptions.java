/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Alexander Stark - initial API and implementation
 * Matthias Mailänder - adapt to new ILabel interface
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.processing.supplier.base.settings.support;

import org.eclipse.chemclipse.support.text.ILabel;

public enum DigitalFilterTreatmentOptions implements ILabel {
	SHIFT_ONLY("Left shift group delay only"), //
	SUBSTITUTE_WITH_ZERO("Left shift group delay and overwrite with zeros"), //
	SUBSTITUTE_WITH_NOISE("Left shift group delay and overwrite with noise");

	private String label;

	private DigitalFilterTreatmentOptions(String label) {

		this.label = label;
	}

	@Override
	public String label() {

		return label;
	}
}
