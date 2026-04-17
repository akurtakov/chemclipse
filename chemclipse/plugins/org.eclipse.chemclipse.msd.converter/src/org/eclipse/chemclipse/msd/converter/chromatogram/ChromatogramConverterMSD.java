/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Alexander Kerner - Generics
 * Christoph Läubrich - Adjust to new API
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.chromatogram;

import org.eclipse.chemclipse.converter.chromatogram.AbstractChromatogramConverter;
import org.eclipse.chemclipse.converter.chromatogram.IChromatogramConverter;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IChromatogramPeakMSD;
import org.eclipse.chemclipse.processing.DataCategory;

public final class ChromatogramConverterMSD extends AbstractChromatogramConverter<IChromatogramPeakMSD, IChromatogramMSD> {

	private static IChromatogramConverter<IChromatogramPeakMSD, IChromatogramMSD> instance = null;

	public ChromatogramConverterMSD() {

		super("org.eclipse.chemclipse.msd.converter.chromatogramSupplier", IChromatogramMSD.class, DataCategory.MSD);
	}

	public static IChromatogramConverter<IChromatogramPeakMSD, IChromatogramMSD> getInstance() {

		if(instance == null) {
			instance = new ChromatogramConverterMSD();
		}

		return instance;
	}
}