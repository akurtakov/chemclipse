/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - add method to check if running in development mode
 *******************************************************************************/
package org.eclipse.chemclipse.support.settings;

public class UserManagement {

	public static String getCurrentUser() {

		return System.getProperty("user.name"); // $NON-NLS-1$
	}

	public static String getUserHome() {

		return System.getProperty("user.home"); // $NON-NLS-1$
	}

	public static boolean isDevMode() {

		String property = System.getProperty("osgi.dev"); // $NON-NLS-1$
		return property != null;
	}

	private UserManagement() {

	}
}
