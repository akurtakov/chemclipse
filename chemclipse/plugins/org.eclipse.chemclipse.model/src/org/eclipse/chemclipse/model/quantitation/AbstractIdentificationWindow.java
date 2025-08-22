/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.quantitation;

public abstract class AbstractIdentificationWindow implements IIdentificationWindow {

	/**
	 * Renew the UUID on change.
	 */
	private static final long serialVersionUID = -1544984148413303660L;

	private float allowedNegativeDeviation; // Sets the negative deviation (>= 0)
	private float allowedPositiveDeviation; // Sets the positive deviation (>= 0)

	@Override
	public float getAllowedNegativeDeviation() {

		return allowedNegativeDeviation;
	}

	@Override
	public void setAllowedNegativeDeviation(float allowedNegativeDeviation) {

		if(allowedNegativeDeviation >= 0) {
			this.allowedNegativeDeviation = allowedNegativeDeviation;
		}
	}

	@Override
	public float getAllowedPositiveDeviation() {

		return allowedPositiveDeviation;
	}

	@Override
	public void setAllowedPositiveDeviation(float allowedPositiveDeviation) {

		if(allowedPositiveDeviation >= 0) {
			this.allowedPositiveDeviation = allowedPositiveDeviation;
		}
	}
}
