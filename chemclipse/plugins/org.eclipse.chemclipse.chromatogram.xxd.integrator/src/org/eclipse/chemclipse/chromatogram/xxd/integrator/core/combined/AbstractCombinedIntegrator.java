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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.core.combined;

import org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings.combined.ICombinedIntegrationSettings;
import org.eclipse.chemclipse.chromatogram.xxd.integrator.result.ICombinedIntegrationResult;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;

public abstract class AbstractCombinedIntegrator implements ICombinedIntegrator {

	public static final String DESCRIPTION = "Combined Integrator";

	protected IProcessingInfo<ICombinedIntegrationResult> validate(IChromatogramSelection chromatogramSelection, ICombinedIntegrationSettings combinedIntegrationSettings) {

		IProcessingInfo<ICombinedIntegrationResult> processingInfo = new ProcessingInfo<>();
		if(chromatogramSelection == null) {
			processingInfo.addErrorMessage(DESCRIPTION, "The given chromatogram selection must not be null.");
		}
		if(combinedIntegrationSettings == null) {
			processingInfo.addErrorMessage(DESCRIPTION, "The given integration settings must not be null");
		}
		return processingInfo;
	}
}
