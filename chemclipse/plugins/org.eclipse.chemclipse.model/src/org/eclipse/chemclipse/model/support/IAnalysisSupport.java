/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.support;

import java.util.List;

public interface IAnalysisSupport {

	/**
	 * Returns the number of segments to be analyzed.<br/>
	 * If you have for example a chromatogram with 5726 scans and your analysis
	 * segment width is 13 scans, the analysis support would return a value of
	 * 441.<br/>
	 * Why 441? 440x a segment width of 13 scans and 1x a segment width of 6
	 * scans.
	 */
	int getNumberOfAnalysisSegments();

	/**
	 * Returns a list of the available analysis segments.
	 */
	List<IAnalysisSegment> getAnalysisSegments();
}
