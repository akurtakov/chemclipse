/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.csd.identifier.peak;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.csd.identifier.settings.IPeakIdentifierSettingsCSD;
import org.eclipse.chemclipse.csd.model.core.IPeakCSD;
import org.eclipse.chemclipse.model.identifier.IPeakIdentificationResults;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.support.literature.LiteratureReference;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IPeakIdentifierCSD {

	/**
	 * Identifies a list of peaks.
	 *
	 * @param peaks
	 * @param peakIdentifierSettings
	 * @param monitor
	 * @return {@link IProcessingInfo}
	 */
	IProcessingInfo<IPeakIdentificationResults> identify(List<? extends IPeakCSD> peaks, IPeakIdentifierSettingsCSD peakIdentifierSettings, IProgressMonitor monitor);

	List<LiteratureReference> getLiteratureReferences();
}
