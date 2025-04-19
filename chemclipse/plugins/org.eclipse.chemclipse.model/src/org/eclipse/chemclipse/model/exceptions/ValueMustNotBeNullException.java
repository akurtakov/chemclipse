/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Alexander Kerner - implementation
 *******************************************************************************/
package org.eclipse.chemclipse.model.exceptions;

public class ValueMustNotBeNullException extends RuntimeException {

	public ValueMustNotBeNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ValueMustNotBeNullException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValueMustNotBeNullException(Throwable cause) {
		super(cause);
	}

	/**
	 * Renew the serialVersionUID any time you have changed some fields or
	 * methods.
	 */
	private static final long serialVersionUID = 6845549285214123241L;

	public ValueMustNotBeNullException() {
		super();
	}

	public ValueMustNotBeNullException(String message) {
		super(message);
	}
}
