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

public class AssetItem {

	private File file;
	private AssetType assetType;

	public AssetItem(File file, AssetType assetType) {

		this.file = file;
		this.assetType = assetType;
	}

	public File getFile() {

		return file;
	}

	public AssetType getAssetType() {

		return assetType;
	}

	/**
	 * Convenient method to get the name.
	 * 
	 * @return {String}
	 */
	public String getName() {

		return file.getName();
	}

	/**
	 * Convenient method to get the description.
	 * 
	 * @return {String}
	 */
	public String getDescription() {

		return assetType.description();
	}
}