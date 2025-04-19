/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - simplify API
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.filter.core.peak;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.result.IPeakFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.settings.IPeakFilterSettings;
import org.eclipse.chemclipse.msd.model.core.IPeakMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public interface IPeakFilter {

	/**
	 * Applies the filter to the selected peaks using the settings.
	 * 
	 * @param peaks
	 * @param peakFilterSettings
	 * @param monitor
	 * @return {@link IProcessingInfo}
	 */
	IProcessingInfo<IPeakFilterResult> applyFilter(List<IPeakMSD> peaks, IPeakFilterSettings peakFilterSettings, IProgressMonitor monitor);

	default IStatus validateSettings(IPeakFilterSettings peakFilterSettings) {

		return Status.OK_STATUS;
	}
}
