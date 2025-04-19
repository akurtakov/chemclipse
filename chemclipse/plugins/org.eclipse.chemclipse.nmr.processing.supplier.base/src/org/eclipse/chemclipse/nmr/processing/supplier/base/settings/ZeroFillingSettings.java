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
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.processing.supplier.base.settings;

import org.eclipse.chemclipse.nmr.processing.supplier.base.settings.support.ZeroFillingFactor;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZeroFillingSettings {

	@JsonProperty(value = "Zero Filling", defaultValue = "AUTO")
	private ZeroFillingFactor zeroFillingFactor = ZeroFillingFactor.AUTO;

	public ZeroFillingFactor getZeroFillingFactor() {

		return zeroFillingFactor;
	}

	public void setZeroFillingFactor(ZeroFillingFactor zeroFillingFactor) {

		this.zeroFillingFactor = zeroFillingFactor;
	}

	@Override
	public String toString() {

		return "ZeroFillingSettings [zeroFillingFactor=" + zeroFillingFactor + "]";
	}
}