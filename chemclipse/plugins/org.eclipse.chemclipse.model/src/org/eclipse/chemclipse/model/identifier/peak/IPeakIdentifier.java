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
 *******************************************************************************/
package org.eclipse.chemclipse.model.identifier.peak;

import java.util.List;

import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IPeakIdentifier {

	/**
	 * Identifies a peak.
	 * 
	 * @param peak
	 * @param peakIdentifierSettings
	 * @param monitor
	 * @return {@link IProcessingInfo}
	 */
	IProcessingInfo<?> identify(IPeak peak, IPeakIdentifierSettings peakIdentifierSettings, IProgressMonitor monitor);

	/**
	 * Identifies the peak.
	 * 
	 * @param peak
	 * @param monitor
	 * @return {@link IProcessingInfo}
	 */
	IProcessingInfo<?> identify(IPeak peak, IProgressMonitor monitor);

	/**
	 * Identifies a list of peaks.
	 * 
	 * @param peaks
	 * @param peakIdentifierSettings
	 * @param monitor
	 * @return {@link IProcessingInfo}
	 */
	IProcessingInfo<?> identify(List<IPeak> peaks, IPeakIdentifierSettings peakIdentifierSettings, IProgressMonitor monitor);

	/**
	 * The same as the other method but without settings.
	 * 
	 * @param peaks
	 * @param monitor
	 * @return {@link IProcessingInfo}
	 */
	IProcessingInfo<?> identify(List<IPeak> peaks, IProgressMonitor monitor);

	IProcessingInfo<?> identify(IChromatogramSelection chromatogramSelection, IProgressMonitor monitor);
}
