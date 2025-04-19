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
 * Jan Holy - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.model.exceptions;

public class BaselineIsNotDefinedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 825282295872083616L;

	public BaselineIsNotDefinedException() {

		super();
	}

	public BaselineIsNotDefinedException(String message) {

		super(message);
	}
}
