/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.support;

import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.processing.core.ICategories;
import org.eclipse.chemclipse.processing.methods.IProcessMethod;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplierContext;

public class NoiseFactorSupport {

	public static void updateNoiseFactor(IChromatogram chromatogram, IProcessMethod processMethod, IProcessSupplierContext processTypeSupport) {

		processMethod.forEach(p -> updateNoiseFactor(chromatogram, processTypeSupport.getSupplier(p.getProcessorId())));
	}

	public static void updateNoiseFactor(IChromatogram chromatogram, IProcessSupplier<?> processSupplier) {

		if(chromatogram != null) {
			if(processSupplier != null) {
				String category = processSupplier.getCategory();
				if(category != null) {
					/*
					 * Only specific action shall trigger a noise factor recalculation.
					 */
					if(category.equals(ICategories.CHROMATOGRAM_FILTER) || category.equals(ICategories.SCAN_MASS_SPECTRUM_FILTER) || category.equals(ICategories.SCAN_FILTER)) {
						chromatogram.recalculateNoiseFactor();
					}
				}
			}
		}
	}
}