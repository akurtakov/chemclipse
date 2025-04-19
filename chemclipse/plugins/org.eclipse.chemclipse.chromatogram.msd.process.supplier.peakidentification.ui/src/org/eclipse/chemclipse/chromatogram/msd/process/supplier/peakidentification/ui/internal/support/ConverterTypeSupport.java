/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.ui.internal.support;

import org.eclipse.chemclipse.converter.exceptions.NoConverterAvailableException;
import org.eclipse.chemclipse.msd.converter.peak.PeakConverterMSD;
import org.eclipse.chemclipse.processing.converter.ISupplier;
import org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.model.IPeakOutputEntry;
import org.eclipse.chemclipse.logging.core.Logger;

/**
 * @author Dr. Philip Wenig
 * 
 */
public class ConverterTypeSupport {

	private static final Logger logger = Logger.getLogger(ConverterTypeSupport.class);
	public static final String NOT_AVAILABLE = "n.a.";

	public String getConverterName(IPeakOutputEntry entry) {

		String converterName = NOT_AVAILABLE;
		try {
			ISupplier converterSupplier = PeakConverterMSD.getPeakConverterSupport().getSupplier(entry.getConverterId());
			converterName = converterSupplier.getFilterName();
		} catch(NoConverterAvailableException e) {
			logger.warn(e);
		}
		return converterName;
	}
}
