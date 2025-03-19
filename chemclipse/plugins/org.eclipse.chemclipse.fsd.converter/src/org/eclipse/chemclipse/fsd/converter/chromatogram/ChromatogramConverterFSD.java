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
package org.eclipse.chemclipse.fsd.converter.chromatogram;

import org.eclipse.chemclipse.converter.chromatogram.AbstractChromatogramConverter;
import org.eclipse.chemclipse.converter.chromatogram.IChromatogramConverter;
import org.eclipse.chemclipse.fsd.model.core.IChromatogramFSD;
import org.eclipse.chemclipse.fsd.model.core.IChromatogramPeakFSD;
import org.eclipse.chemclipse.processing.DataCategory;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramConverterFSD extends AbstractChromatogramConverter<IChromatogramPeakFSD, IChromatogramFSD> implements IChromatogramConverter<IChromatogramPeakFSD, IChromatogramFSD> {

	private static IChromatogramConverter<IChromatogramPeakFSD, IChromatogramFSD> instance = null;

	public ChromatogramConverterFSD() {

		super("org.eclipse.chemclipse.fsd.converter.chromatogramSupplier", IChromatogramFSD.class, DataCategory.FSD);
	}

	public static IChromatogramConverter<IChromatogramPeakFSD, IChromatogramFSD> getInstance() {

		if(instance == null) {
			instance = new ChromatogramConverterFSD();
		}

		return instance;
	}

	@Override
	public void postProcessChromatogram(IProcessingInfo<IChromatogramFSD> processingInfo, IProgressMonitor monitor) {

	}
}
