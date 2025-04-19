/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.container.definition;

public class Container {

	/*
	 * These are the attributes of the extension point elements.
	 */
	public static final String ID = "id"; //$NON-NLS-1$
	public static final String MAGIC_NUMBER_MATCHER = "magicNumberMatcher"; //$NON-NLS-1$
	public static final String GET_CONTENTS = "getContents"; //$NON-NLS-1$

	private Container() {

		// static methods only
	}
}
