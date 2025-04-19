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
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.model.core;

public enum DataDimension {
	ONE_DIMENSIONAL("1D"), TWO_DIMENSIONAL("2D"), THREE_DIMENSIONAL("3D"), FOUR_DIMENSIONAL("4D");

	private String name;

	DataDimension(String name) {
		this.name = name;
	}

	@Override
	public String toString() {

		return name;
	}
}