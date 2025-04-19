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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.backfolding.support;

import org.eclipse.chemclipse.chromatogram.peak.detector.support.DetectorSlope;
import org.eclipse.chemclipse.numeric.core.IPoint;

/**
 * @author eselmeister
 */
public class BackfoldingDetectorSlope extends DetectorSlope implements IBackfoldingDetectorSlope {

	public BackfoldingDetectorSlope(IPoint p1, IPoint p2, int retentionTime) {
		super(p1, p2, retentionTime);
	}
}
