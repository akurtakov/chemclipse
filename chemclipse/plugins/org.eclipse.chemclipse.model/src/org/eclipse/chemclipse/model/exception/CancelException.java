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
 * Alexander Kerner - initial API and implementation
 * Philip Wenig - wrong license, it has been adjusted to EPL
 *******************************************************************************/
package org.eclipse.chemclipse.model.exception;

/**
 *
 * @author Alexander Kerner
 *
 */
public class CancelException extends RuntimeException {

	private static final long serialVersionUID = -903919422865740822L;

	public CancelException() {

	}

	public CancelException(final String message) {

		super(message);
	}

	public CancelException(final Throwable cause) {

		super(cause);
	}

	public CancelException(final String message, final Throwable cause) {

		super(message, cause);
	}

	public CancelException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {

		super(message, cause, enableSuppression, writableStackTrace);
	}
}