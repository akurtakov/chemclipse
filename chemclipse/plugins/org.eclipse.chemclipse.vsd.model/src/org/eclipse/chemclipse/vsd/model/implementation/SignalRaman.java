/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.vsd.model.implementation;

import org.eclipse.chemclipse.vsd.model.core.ISignalRaman;

public class SignalRaman extends AbstractSignalVSD implements ISignalRaman {

	private static final long serialVersionUID = -8694972698204376845L;

	private double scattering = 0.0d;

	public SignalRaman(double wavenumber, double scattering) {

		super(wavenumber);
		this.scattering = scattering;
	}

	@Override
	public double getIntensity() {

		return getScattering();
	}

	@Override
	public void setIntensity(double intensity) {

		setScattering(intensity);
	}

	@Override
	public double getScattering() {

		return scattering;
	}

	@Override
	public void setScattering(double scattering) {

		this.scattering = scattering;
	}

	@Override
	public double getY() {

		return scattering;
	}
}
