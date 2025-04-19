/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Dr. Alexander Kerner - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.converter.exceptions;

import java.io.IOException;

public class UnknownVersionException extends IOException {

	/**
	 *
	 */
	private static final long serialVersionUID = 7248123969997448857L;

	public UnknownVersionException() {
	}

	public UnknownVersionException(final String message) {
		super(message);
	}

	public UnknownVersionException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public UnknownVersionException(final Throwable cause) {
		super(cause);
	}
}
