/*******************************************************************************
 * Copyright (c) 2015, 2025 Michael Chang.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Michael Chang - initial API and implementation
 * Philip Wenig - name and area calculation
 *******************************************************************************/
package org.eclipse.chemclipse.wsd.converter.supplier.ocx.model.chromatogram;

import org.eclipse.chemclipse.wsd.model.core.AbstractChromatogramWSD;

public class VendorChromatogram extends AbstractChromatogramWSD implements IVendorChromatogram {

	private static final long serialVersionUID = -1918459516874863928L;

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