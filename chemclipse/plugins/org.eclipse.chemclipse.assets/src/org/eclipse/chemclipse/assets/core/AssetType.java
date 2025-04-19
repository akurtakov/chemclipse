/*******************************************************************************
 * Copyright (c) 2020, 2025 Christoph Läubrich.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.assets.core;

import java.io.File;

import org.eclipse.chemclipse.logging.support.Settings;
import org.eclipse.chemclipse.support.text.ILabel;

public enum AssetType implements ILabel {

	CONFIGURATION("Configuration", ".cfg", Settings.getSystemConfigDirectory(), "Service Configuration File"), //
	METHOD("Process Method", ".ocm", Settings.getSystemMethodDirectory(), "Process Method File"), //
	PLUGIN("Plugin", ".jar", Settings.getSystemPluginDirectory(), "Plugin Extension");

	private String label;
	private String extension;
	private File directory;
	private String description;

	private AssetType(String label, String extension, File directory, String description) {

		this.label = label;
		this.extension = extension;
		this.directory = directory;
		this.description = description;
	}

	/**
	 * Returns the label.
	 * 
	 * @return {String}
	 */
	@Override
	public String label() {

		return label;
	}

	/**
	 * Returns the file extension.
	 * 
	 * @return {String}
	 */
	public String extension() {

		return extension;
	}

	/**
	 * Return the installation directory.
	 * 
	 * @return {File}
	 */
	public File directory() {

		return directory;
	}

	/**
	 * Returns the description.
	 * 
	 * @return {String}
	 */
	public String description() {

		return description;
	}
}