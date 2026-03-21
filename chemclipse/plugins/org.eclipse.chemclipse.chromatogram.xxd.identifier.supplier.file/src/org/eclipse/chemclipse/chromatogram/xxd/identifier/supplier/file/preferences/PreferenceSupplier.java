/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - make the default for addUnknownMzListTarget to false
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.preferences;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.settings.ILibraryIdentifierSettings;
import org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.settings.MassSpectrumLibraryIdentifierSettings;
import org.eclipse.chemclipse.support.preferences.AbstractPreferenceSupplier;
import org.eclipse.chemclipse.support.preferences.IPreferenceSupplier;
import org.eclipse.chemclipse.support.util.FileListUtil;
import org.osgi.framework.FrameworkUtil;

public class PreferenceSupplier extends AbstractPreferenceSupplier {

	public static final String P_MASS_SPECTRA_FILES = "massSpectraFiles";
	public static final String DEF_MASS_SPECTRA_FILES = "";

	public static final String P_FILTER_PATH_IDENTIFIER_FILES = "filterPathIdentifierFiles";
	public static final String DEF_FILTER_PATH_IDENTIFIER_FILES = "";

	public static IPreferenceSupplier INSTANCE() {

		return INSTANCE(PreferenceSupplier.class);
	}

	@Override
	public String getPreferenceNode() {

		return FrameworkUtil.getBundle(PreferenceSupplier.class).getSymbolicName();
	}

	@Override
	public void initializeDefaults() {

		putDefault(P_MASS_SPECTRA_FILES, DEF_MASS_SPECTRA_FILES);
		putDefault(P_FILTER_PATH_IDENTIFIER_FILES, DEF_FILTER_PATH_IDENTIFIER_FILES);
	}

	public static MassSpectrumLibraryIdentifierSettings getMassSpectrumIdentifierSettings() {

		MassSpectrumLibraryIdentifierSettings settings = new MassSpectrumLibraryIdentifierSettings();
		initialize(settings);

		return settings;
	}

	public static List<String> getMassSpectraFiles() {

		FileListUtil fileListUtil = new FileListUtil();
		return fileListUtil.getFiles(INSTANCE().get(P_MASS_SPECTRA_FILES, DEF_MASS_SPECTRA_FILES));
	}

	public static void setMassSpectraFiles(List<String> massSpectraFiles) {

		FileListUtil fileListUtil = new FileListUtil();
		String[] items = massSpectraFiles.toArray(new String[massSpectraFiles.size()]);
		INSTANCE().put(P_MASS_SPECTRA_FILES, fileListUtil.createList(items));
	}

	public static String getFilterPathIdentifierFiles() {

		return INSTANCE().get(P_FILTER_PATH_IDENTIFIER_FILES, DEF_FILTER_PATH_IDENTIFIER_FILES);
	}

	public static void setFilterPathIdentifierFiles(String filterPath) {

		INSTANCE().put(P_FILTER_PATH_IDENTIFIER_FILES, filterPath);
	}

	private static void initialize(ILibraryIdentifierSettings settings) {

		settings.setMassSpectraFiles(INSTANCE().get(P_MASS_SPECTRA_FILES, DEF_MASS_SPECTRA_FILES));
	}
}
