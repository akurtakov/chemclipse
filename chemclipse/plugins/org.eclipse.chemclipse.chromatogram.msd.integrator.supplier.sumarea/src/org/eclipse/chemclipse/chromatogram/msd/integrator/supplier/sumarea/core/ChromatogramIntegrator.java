/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.integrator.supplier.sumarea.core;

import org.eclipse.chemclipse.chromatogram.msd.integrator.supplier.sumarea.internal.support.ChromatogramIntegratorSupport;
import org.eclipse.chemclipse.chromatogram.msd.integrator.supplier.sumarea.settings.ChromatogramIntegrationSettings;
import org.eclipse.chemclipse.chromatogram.xxd.integrator.core.chromatogram.AbstractChromatogramIntegrator;
import org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings.chromatogram.IChromatogramIntegrationSettings;
import org.eclipse.chemclipse.chromatogram.xxd.integrator.result.IChromatogramIntegrationResults;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramIntegrator extends AbstractChromatogramIntegrator {

	@Override
	public IProcessingInfo<IChromatogramIntegrationResults> integrate(IChromatogramSelection chromatogramSelection, IChromatogramIntegrationSettings chromatogramIntegrationSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramIntegrationResults> processingInfo = super.validate(chromatogramSelection, chromatogramIntegrationSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramSelection instanceof IChromatogramSelectionMSD chromatogramSelectionMSD && chromatogramIntegrationSettings instanceof ChromatogramIntegrationSettings settings) {
				ChromatogramIntegratorSupport chromatogramIntegratorSupport = new ChromatogramIntegratorSupport();
				IChromatogramIntegrationResults chromatogramIntegrationResults = chromatogramIntegratorSupport.calculateChromatogramIntegrationResults(chromatogramSelectionMSD, settings, monitor);
				processingInfo.setProcessingResult(chromatogramIntegrationResults);
			} else {
				processingInfo.addErrorMessage("Sum Area Integrator", "The settings and/or chromatogram are not of type MSD.");
			}
		}
		return processingInfo;
	}
}
