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
package org.eclipse.chemclipse.nmr.converter.supplier.jcampdx.model;

import java.math.BigDecimal;

import org.eclipse.chemclipse.nmr.model.core.ISpectrumSignal;

public class VendorSpectrumSignal implements ISpectrumSignal {

	private double frequency;
	private double real;

	public VendorSpectrumSignal(double frequency, double real) {

		this.frequency = frequency;
		this.real = real;
	}

	@Override
	public BigDecimal getFrequency() {

		return BigDecimal.valueOf(frequency);
	}

	@Override
	public Number getAbsorptiveIntensity() {

		return real;
	}

	@Override
	public Number getDispersiveIntensity() {

		return BigDecimal.ZERO;
	}
}
