/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.vsd.converter.service;

import org.eclipse.chemclipse.converter.core.IFileContentMatcher;
import org.eclipse.chemclipse.converter.core.IMagicNumberMatcher;
import org.eclipse.chemclipse.model.settings.IProcessSettings;
import org.eclipse.chemclipse.vsd.converter.chromatogram.IExportConverterVSD;
import org.eclipse.chemclipse.vsd.converter.chromatogram.IImportConverterVSD;

public interface IConverterServiceVSD {

	String getId();

	String getDescription();

	String getFilterName();

	String getFileExtension();

	String getFileName();

	String getDirectoryExtension();

	IImportConverterVSD getImportConverter();

	IExportConverterVSD getExportConverter();

	IMagicNumberMatcher getMagicNumberMatcher();

	IFileContentMatcher getFileContentMatcher();

	IProcessSettings getProcessSettings();

	default boolean isImportable() {

		return getImportConverter() != null;
	}

	default boolean isExportable() {

		return getExportConverter() != null;
	}

	default boolean hasProcessSettings() {

		return getProcessSettings() != null;
	}
}