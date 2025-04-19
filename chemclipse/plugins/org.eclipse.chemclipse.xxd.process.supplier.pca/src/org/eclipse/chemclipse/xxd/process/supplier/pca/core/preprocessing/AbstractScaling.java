/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Jan Holy - initial API and implementation
 * Philip Wenig - refactoring
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing;

public abstract class AbstractScaling extends AbstractCentering implements IScaling {

	private int centeringType;

	protected AbstractScaling(int centeringType) {

		this.centeringType = centeringType;
	}

	@Override
	public int getCenteringType() {

		return centeringType;
	}

	@Override
	public void setCenteringType(int centeringType) {

		this.centeringType = centeringType;
	}
}
