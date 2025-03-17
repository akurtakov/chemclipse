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
package org.eclipse.chemclipse.fsd.model.core.implementation;

import org.eclipse.chemclipse.fsd.model.core.IScanSignalFSD;

public class ScanSignalFSD extends AbstractScanSignalFSD implements IScanSignalFSD {

	private static final long serialVersionUID = -3273447342785680772L;

	public ScanSignalFSD(float wavelength, float fluorescence) {

		super();
		setWavelength(wavelength);
		setFluorescence(fluorescence);
	}
}
