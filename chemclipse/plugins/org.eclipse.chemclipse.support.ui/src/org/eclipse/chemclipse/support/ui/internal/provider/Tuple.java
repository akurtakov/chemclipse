/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.internal.provider;

public class Tuple {

	private int position;
	private int index;

	public Tuple(int position, int index) {

		this.position = position;
		this.index = index;
	}

	public int getPosition() {

		return position;
	}

	public int getIndex() {

		return index;
	}
}