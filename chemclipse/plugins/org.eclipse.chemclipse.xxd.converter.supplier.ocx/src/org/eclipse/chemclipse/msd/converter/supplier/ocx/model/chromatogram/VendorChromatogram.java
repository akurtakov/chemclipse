/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.ocx.model.chromatogram;

import org.eclipse.chemclipse.msd.model.core.AbstractChromatogramMSD;

public class VendorChromatogram extends AbstractChromatogramMSD implements IVendorChromatogram {

	private static final long serialVersionUID = -1437009331484533414L;

	public VendorChromatogram() {

		super();
	}

	@Override
	public String getName() {

		return extractNameFromFile("Chromatogram");
	}

	@Override
	public boolean isParseSeparationColumnEnabled() {

		/*
		 * Assume that the column has been set and saved already.
		 */
		return false;
	}
}