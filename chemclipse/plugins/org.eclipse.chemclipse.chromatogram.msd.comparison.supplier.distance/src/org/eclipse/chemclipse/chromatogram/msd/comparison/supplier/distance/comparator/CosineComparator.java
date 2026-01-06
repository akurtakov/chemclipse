/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - don't extract ion signal more than once, use lazy result
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.comparison.supplier.distance.comparator;

import org.eclipse.chemclipse.msd.model.xic.IExtractedIonSignal;

public class CosineComparator extends AbstractCosineComparator {

	@Override
	protected double getVectorValue(IExtractedIonSignal signal, int i) {

		return signal.getAbundance(i);
	}
}