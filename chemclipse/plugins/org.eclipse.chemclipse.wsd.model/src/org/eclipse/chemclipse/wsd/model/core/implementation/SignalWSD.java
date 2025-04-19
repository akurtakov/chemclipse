/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.wsd.model.core.implementation;

import org.eclipse.chemclipse.wsd.model.core.ISignalWSD;

public class SignalWSD extends AbstractSignalWSD implements ISignalWSD, Comparable<ISignalWSD> {

	private static final long serialVersionUID = -6878875442146282898L;

	public SignalWSD(double wavelength, double absorbance, double transmittance) {

		super(wavelength, absorbance, transmittance);
	}
}
