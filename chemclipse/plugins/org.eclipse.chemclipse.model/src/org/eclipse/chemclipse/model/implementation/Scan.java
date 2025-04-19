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
package org.eclipse.chemclipse.model.implementation;

import org.eclipse.chemclipse.model.core.AbstractScan;
import org.eclipse.chemclipse.model.core.IScan;

public class Scan extends AbstractScan implements IScan {

	/**
	 * Renew the serialVersionUID any time you have changed some fields or
	 * methods.
	 */
	private static final long serialVersionUID = 8733112087675991152L;
	private float totalSignal;

	public Scan(float totalSignal) {
		if(totalSignal >= 0) {
			this.totalSignal = totalSignal;
		}
	}

	@Override
	public float getTotalSignal() {

		return totalSignal;
	}

	@Override
	public void adjustTotalSignal(float totalSignal) {

		if(totalSignal >= 0) {
			this.totalSignal = totalSignal;
		}
	}
}
