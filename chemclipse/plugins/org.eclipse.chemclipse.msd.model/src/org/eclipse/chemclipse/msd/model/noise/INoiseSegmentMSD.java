/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.noise;

import org.eclipse.chemclipse.model.support.IAnalysisSegment;
import org.eclipse.chemclipse.msd.model.core.ICombinedMassSpectrum;

public interface INoiseSegmentMSD {

	/**
	 * Returns the analysis segment. May return null.
	 * 
	 * @return {@link IAnalysisSegment}
	 */
	IAnalysisSegment getAnalysisSegment();

	/**
	 * Returns the noise mass spectrum. May return null.
	 * 
	 * @return
	 */
	ICombinedMassSpectrum getNoiseMassSpectrum();
}