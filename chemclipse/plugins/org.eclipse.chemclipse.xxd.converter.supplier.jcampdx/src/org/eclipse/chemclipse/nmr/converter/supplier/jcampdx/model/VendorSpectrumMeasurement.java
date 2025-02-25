/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.converter.supplier.jcampdx.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.core.AbstractMeasurement;
import org.eclipse.chemclipse.nmr.model.core.AcquisitionParameter;
import org.eclipse.chemclipse.nmr.model.core.ISpectrumMeasurement;
import org.eclipse.chemclipse.nmr.model.core.ISpectrumSignal;

public final class VendorSpectrumMeasurement extends AbstractMeasurement implements ISpectrumMeasurement {

	private static final long serialVersionUID = 1060090077551662226L;

	private final List<ISpectrumSignal> signals = new ArrayList<>();

	@Override
	public AcquisitionParameter getAcquisitionParameter() {

		return null;
	}

	@Override
	public List<? extends ISpectrumSignal> getSignals() {

		return signals;
	}

	public void addSignal(ISpectrumSignal signal) {

		signals.add(signal);
	}
}