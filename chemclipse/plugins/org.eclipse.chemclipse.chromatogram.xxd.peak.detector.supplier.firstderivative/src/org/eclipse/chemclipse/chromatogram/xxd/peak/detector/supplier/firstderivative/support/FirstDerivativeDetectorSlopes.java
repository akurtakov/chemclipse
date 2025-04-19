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
 * Christoph Läubrich - add constructor
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.peak.detector.supplier.firstderivative.support;

import java.util.Collection;

import org.eclipse.chemclipse.chromatogram.peak.detector.support.DetectorSlopes;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;

public class FirstDerivativeDetectorSlopes extends DetectorSlopes implements IFirstDerivativeDetectorSlopes {

	public FirstDerivativeDetectorSlopes(ITotalScanSignals signals) {

		super(signals);
	}

	public FirstDerivativeDetectorSlopes(Collection<?> signals) {

		super(0, signals.size() - 1);
	}
}
