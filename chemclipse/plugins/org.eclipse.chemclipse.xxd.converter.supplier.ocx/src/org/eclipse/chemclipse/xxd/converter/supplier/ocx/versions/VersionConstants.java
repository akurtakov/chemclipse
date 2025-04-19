/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.ocx.versions;

public class VersionConstants {

	private VersionConstants() {

	}

	public static final String DESCRIPTION_CHROMATOGRAM = "Open Chromatography Binary";
	public static final String FILE_EXTENSION_CHROMATOGRAM = ".ocb";
	public static final String FILE_NAME_CHROMATOGRAM = DESCRIPTION_CHROMATOGRAM.replaceAll("\\s", "") + FILE_EXTENSION_CHROMATOGRAM;
	public static final String FILTER_EXTENSION_CHROMATOGRAM = "*" + FILE_EXTENSION_CHROMATOGRAM;
	public static final String FILTER_NAME_CHROMATOGRAM = DESCRIPTION_CHROMATOGRAM + " (*" + FILE_EXTENSION_CHROMATOGRAM + ")";
	public static final String CONVERTER_ID_CHROMATOGRAM = "org.eclipse.chemclipse.xxd.converter.supplier.chemclipse";
	//
	public static final String DESCRIPTION_METHOD = "Open Chromatography Method";
	public static final String FILE_EXTENSION_METHOD = ".ocm";
	public static final String FILE_NAME_METHOD = DESCRIPTION_METHOD.replaceAll("\\s", "") + FILE_EXTENSION_METHOD;
	public static final String FILTER_EXTENSION_METHOD = "*" + FILE_EXTENSION_METHOD;
	public static final String FILTER_NAME_METHOD = DESCRIPTION_METHOD + " (*" + FILE_EXTENSION_METHOD + ")";
	public static final String CONVERTER_ID_METHOD = "org.eclipse.chemclipse.xxd.converter.supplier.chemclipse.processMethodSupplier";
}