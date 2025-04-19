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
 *******************************************************************************/
package org.eclipse.chemclipse.converter.exceptions;

import java.io.IOException;

public class FileIsNotReadableException extends IOException {

	/**
	 * Renew the serialVersionUID any time you have changed some fields or methods.
	 */
	private static final long serialVersionUID = -3782004378833262084L;

	public FileIsNotReadableException() {
		super();
	}

	public FileIsNotReadableException(final String message) {
		super(message);
	}
}
