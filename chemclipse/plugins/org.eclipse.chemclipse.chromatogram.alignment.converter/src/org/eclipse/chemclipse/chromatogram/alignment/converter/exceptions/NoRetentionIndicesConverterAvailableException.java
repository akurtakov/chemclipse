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

public class NoRetentionIndicesConverterAvailableException extends Exception {

	private static final long serialVersionUID = -3182700779195097912L;

	public NoRetentionIndicesConverterAvailableException() {
		super();
	}

	public NoRetentionIndicesConverterAvailableException(String message) {
		super(message);
	}
}
