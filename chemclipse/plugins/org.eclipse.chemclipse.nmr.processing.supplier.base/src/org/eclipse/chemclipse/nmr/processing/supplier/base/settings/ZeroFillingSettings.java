/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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