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
package org.eclipse.chemclipse.chromatogram.alignment.converter.exceptions;

public class FileIsEmptyException extends Exception {

	private static final long serialVersionUID = -7431013143842747014L;

	public FileIsEmptyException() {
		super();
	}

	public FileIsEmptyException(String message) {
		super(message);
	}
}
