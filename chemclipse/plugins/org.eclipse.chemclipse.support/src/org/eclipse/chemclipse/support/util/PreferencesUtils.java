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
 * Philip Wenig - generics
 *******************************************************************************/
package org.eclipse.chemclipse.support.util;

public class PreferencesUtils {

	public static String[][] enumToArray(Class<? extends Enum<?>> enums) {

		Enum<?>[] enumValues = enums.getEnumConstants();
		String[][] convertValues = new String[enumValues.length][2];
		for(int i = 0; i < enumValues.length; i++) {
			convertValues[i][0] = enumValues[i].toString();
			convertValues[i][1] = enumValues[i].name();
		}
		return convertValues;
	}
}
