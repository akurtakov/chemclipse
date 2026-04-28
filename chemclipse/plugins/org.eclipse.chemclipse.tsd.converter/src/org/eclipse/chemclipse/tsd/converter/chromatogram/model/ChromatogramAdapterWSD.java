/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.tsd.converter.chromatogram.model;

import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.tsd.model.core.TypeTSD;

public class ChromatogramAdapterWSD extends AbstractChromatogramAdapterTSD {

	private static final long serialVersionUID = -5537308206465038084L;

	public ChromatogramAdapterWSD(IChromatogram chromatogram) {

		super(chromatogram);
	}

	@Override
	public String getLabelAxisX() {

		return "Wavelength [nm]";
	}

	@Override
	public String getLabelAxisY() {

		return "Retention Time [min]";
	}

	@Override
	public TypeTSD getTypeTSD() {

		return TypeTSD.HPLC_DAD;
	}
}
