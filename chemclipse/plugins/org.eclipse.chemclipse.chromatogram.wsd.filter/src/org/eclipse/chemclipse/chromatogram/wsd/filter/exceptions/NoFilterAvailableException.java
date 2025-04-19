/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.wsd.filter.exceptions;

public class NoFilterAvailableException extends Exception {

	private static final long serialVersionUID = -6571154972789722125L;

	public NoFilterAvailableException() {
		super();
	}

	public NoFilterAvailableException(String message) {
		super(message);
	}
}
