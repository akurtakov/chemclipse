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
package org.eclipse.chemclipse.xxd.converter.supplier.ocx.internal.support;

public class BaselineElement implements IBaselineElement {

	private int retentionTime;
	private float backgroundAbundance;

	public BaselineElement(int retentionTime, float backgroundAbundance) {
		this.retentionTime = retentionTime;
		this.backgroundAbundance = backgroundAbundance;
	}

	@Override
	public int getRetentionTime() {

		return retentionTime;
	}

	@Override
	public float getBackgroundAbundance() {

		return backgroundAbundance;
	}
}
