/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.support;

import org.eclipse.chemclipse.converter.exceptions.NoConverterAvailableException;
import org.eclipse.chemclipse.converter.model.IChromatogramOutputEntry;
import org.eclipse.chemclipse.msd.converter.chromatogram.ChromatogramConverterMSD;
import org.eclipse.chemclipse.processing.converter.ISupplier;
import org.eclipse.chemclipse.logging.core.Logger;

// TODO merge with Converter Plug-in
public class ConverterTypeSupportMSD {

	private static final Logger logger = Logger.getLogger(ConverterTypeSupportMSD.class);
	public static final String NOT_AVAILABLE = "n.a.";

	public String getConverterName(IChromatogramOutputEntry entry) {

		String converterName = NOT_AVAILABLE;
		try {
			ISupplier converterSupplier = ChromatogramConverterMSD.getInstance().getChromatogramConverterSupport().getSupplier(entry.getConverterId());
			converterName = converterSupplier.getFilterName();
		} catch(NoConverterAvailableException e) {
			logger.warn(e);
		}
		return converterName;
	}
}
