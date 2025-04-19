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
 * Jan Holy - initial API and implementation
 * Philip Wenig - refactoring
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.exception;

public class MathIllegalArgumentException extends IllegalArgumentException {

	private static final long serialVersionUID = 9006355266314003863L;

	public MathIllegalArgumentException() {

		super();
	}

	public MathIllegalArgumentException(String message, Throwable cause) {

		super(message, cause);
	}

	public MathIllegalArgumentException(String value) {

		super(value);
	}

	public MathIllegalArgumentException(Throwable cause) {

		super(cause);
	}
}