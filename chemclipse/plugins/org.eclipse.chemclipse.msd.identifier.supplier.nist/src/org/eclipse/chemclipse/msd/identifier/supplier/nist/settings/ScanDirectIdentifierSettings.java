/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - remove nist application path settings from config
 *******************************************************************************/
package org.eclipse.chemclipse.msd.identifier.supplier.nist.settings;

import java.io.File;

import org.eclipse.chemclipse.support.settings.FileSettingProperty;
import org.eclipse.chemclipse.support.settings.FileSettingProperty.DialogType;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ScanDirectIdentifierSettings extends AbstractScanSearchSettings {

	@JsonProperty(value = "NIST Folder (MSSEARCH)", defaultValue = "")
	@JsonPropertyDescription("Select the NIST-DB folder, called MSSEARCH.")
	@FileSettingProperty(dialogType = DialogType.OPEN_DIALOG, onlyDirectory = true, allowEmpty = false)
	private File nistFolder = null;
	@JsonProperty(value = "Use Optimized Mass Spectrum", defaultValue = "true")
	@JsonPropertyDescription(value = "If true, the optimized spectrum will be used if available.")
	private boolean useOptimizedMassSpectrum = true;
	@JsonProperty(value = "Wait [s]", defaultValue = "3")
	@JsonPropertyDescription(value = "Wait before starting the GUI version.")
	@IntSettingsProperty
	private int waitInSeconds = 3;

	@Override
	public File getNistFolder() {

		return nistFolder;
	}

	public void setNistFolder(File nistFolder) {

		this.nistFolder = nistFolder;
	}

	@Override
	public boolean isUseOptimizedMassSpectrum() {

		return useOptimizedMassSpectrum;
	}

	public void setUseOptimizedMassSpectrum(boolean useOptimizedMassSpectrum) {

		this.useOptimizedMassSpectrum = useOptimizedMassSpectrum;
	}

	@Override
	public int getWaitInSeconds() {

		return waitInSeconds;
	}

	public void setWaitInSeconds(int waitInSeconds) {

		this.waitInSeconds = waitInSeconds;
	}

	@Override
	public boolean isBatchModus() {

		return false;
	}
}
