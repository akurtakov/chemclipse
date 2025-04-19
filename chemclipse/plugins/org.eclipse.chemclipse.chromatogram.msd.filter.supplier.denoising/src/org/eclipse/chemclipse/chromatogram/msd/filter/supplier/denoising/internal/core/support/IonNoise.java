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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.denoising.internal.core.support;

public class IonNoise {

	private int ion;
	private float abundance;

	public IonNoise(int ion, float abundance) {
		this.ion = ion;
		this.abundance = abundance;
	}

	/**
	 * Returns the ion.
	 * 
	 * @return int
	 */
	public int getIon() {

		return ion;
	}

	/**
	 * Returns the abundance.
	 * 
	 * @return float
	 */
	public float getAbundance() {

		return abundance;
	}
}
