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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.support.util;

public class ValueParserSupport {

	public boolean parseBoolean(String[] values, int index) {

		return parseBoolean(values, index, false);
	}

	public boolean parseBoolean(String[] values, int index, boolean def) {

		boolean result = def;
		String value = parseString(values, index, "").toLowerCase();
		if(Boolean.toString(true).equals(value)) {
			result = true;
		} else if(Boolean.toString(false).equals(value)) {
			result = false;
		}
		return result;
	}

	public String parseString(String[] values, int index) {

		return parseString(values, index, "");
	}

	public String parseString(String[] values, int index, String def) {

		return (values.length > index) ? values[index].trim() : def;
	}

	public int parseInteger(String[] values, int index) {

		return parseInteger(values, index, 0);
	}

	public int parseInteger(String[] values, int index, int def) {

		int result = def;
		String value = parseString(values, index, "");
		if(!"".equals(value)) {
			try {
				result = Integer.parseInt(value);
			} catch(NumberFormatException e) {

			}
		}
		return result;
	}

	public float parseFloat(String[] values, int index) {

		return parseFloat(values, index, 0.0f);
	}

	public float parseFloat(String[] values, int index, float def) {

		float result = def;
		String value = parseString(values, index, "");
		if(!"".equals(value)) {
			try {
				result = Float.parseFloat(value);
			} catch(NumberFormatException e) {

			}
		}
		return result;
	}

	public double parseDouble(String[] values, int index) {

		return parseDouble(values, index, 0.0d);
	}

	public double parseDouble(String[] values, int index, double def) {

		double result = def;
		String value = parseString(values, index, "");
		if(!"".equals(value)) {
			try {
				result = Double.parseDouble(value);
			} catch(NumberFormatException e) {

			}
		}
		return result;
	}
}