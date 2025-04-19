/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.matlab.parafac.internal.converter;

public class MatlabParafac {

	private MatlabParafac() {

	}

	public static final String PEAK_IDENTIFIER = "#------------------------------------------";
	public static final String COMMENT = "#";
	public static final String DESCRIPTION = "description";
	public static final String MASS_SPECTRUM = "# mass spectrum";
	public static final String MASS_SPECTRUM_INFO = "(m/z - intensity)";
	public static final String ELUTION_PROFILE = "# elution profile";
	public static final String ELUTION_PROFILE_INFO = "(minutes converted to milliseconds - intensity)";
	public static final String VALUE_DELIMITER = "\t";
	public static final String CRLF = "\r\n";
	public static final String LF = "\n";
	public static final String CR = "\r";
}
