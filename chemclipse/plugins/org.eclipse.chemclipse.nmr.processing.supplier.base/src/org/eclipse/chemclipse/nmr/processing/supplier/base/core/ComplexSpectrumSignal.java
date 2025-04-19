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
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.processing.supplier.base.core;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.math3.complex.Complex;
import org.eclipse.chemclipse.nmr.model.core.ISpectrumSignal;

public final class ComplexSpectrumSignal implements ISpectrumSignal, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3361359307799587392L;
	private Complex complex;
	private BigDecimal frequency;

	public ComplexSpectrumSignal(BigDecimal frequency, Complex complex) {
		this.frequency = frequency;
		this.complex = complex;
	}

	@Override
	public BigDecimal getFrequency() {

		return frequency;
	}

	@Override
	public Number getAbsorptiveIntensity() {

		return complex.getReal();
	}

	@Override
	public Number getDispersiveIntensity() {

		return complex.getImaginary();
	}
}
