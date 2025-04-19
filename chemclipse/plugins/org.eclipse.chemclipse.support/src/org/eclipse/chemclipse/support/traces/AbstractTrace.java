/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.traces;

public abstract class AbstractTrace implements ITrace {

	private double value = 0.0d;
	private double scaleFactor = 1.0d;

	@Override
	public double getValue() {

		return value;
	}

	@Override
	public AbstractTrace setValue(double value) {

		if(value >= 0) {
			this.value = value;
		}
		return this;
	}

	@Override
	public double getScaleFactor() {

		return scaleFactor;
	}

	@Override
	public AbstractTrace setScaleFactor(double scaleFactor) {

		if(scaleFactor > 0) {
			this.scaleFactor = scaleFactor;
		}
		return this;
	}

	protected int getValueAsInt() {

		return (int)(Math.round(value));
	}
}