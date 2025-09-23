/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.peak.detector.support;

import org.eclipse.chemclipse.numeric.geometry.ISlope;

/**
 * @author eselmeister
 */
public interface IDetectorSlope extends ISlope {

	/**
	 * Returns the retention time in milliseconds.
	 * 
	 * @return retention time
	 */
	int getRetentionTime();

	/**
	 * Returns PLUS if the slope value is > 0. Returns MINUS if the slope value
	 * is < 0. Returns a NONE if the slope value is 0.
	 * 
	 * @return Drift
	 */
	Drift getDrift();
}
