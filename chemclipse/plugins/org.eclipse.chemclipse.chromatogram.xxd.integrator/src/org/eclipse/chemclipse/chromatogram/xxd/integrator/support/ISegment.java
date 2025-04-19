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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.support;

import org.eclipse.chemclipse.numeric.core.IPoint;

public interface ISegment {

	IPoint getPeakBaselinePoint1();

	void setPeakBaselinePoint1(IPoint point);

	IPoint getPeakBaselinePoint2();

	void setPeakBaselinePoint2(IPoint point);

	IPoint getChromatogramBaselinePoint1();

	void setChromatogramBaselinePoint1(IPoint point);

	IPoint getChromatogramBaselinePoint2();

	void setChromatogramBaselinePoint2(IPoint point);
	/*
	 * The area methods are implemented in SegmentAreaCalculator.
	 */
}
