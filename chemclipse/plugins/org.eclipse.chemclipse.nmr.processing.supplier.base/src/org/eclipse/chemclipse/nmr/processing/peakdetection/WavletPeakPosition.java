/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - refactoring
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.processing.peakdetection;

import org.eclipse.chemclipse.model.core.PeakPosition;
import org.eclipse.chemclipse.model.core.PeakType;

public class WavletPeakPosition implements PeakPosition {

	@Override
	public int getPeakMaximum() {

		return 100;
	}

	@Override
	public int getPeakStart() {

		return 90;
	}

	@Override
	public int getPeakEnd() {

		return 105;
	}

	@Override
	public PeakType getPeakType() {

		return PeakType.DEFAULT;
	}
}
