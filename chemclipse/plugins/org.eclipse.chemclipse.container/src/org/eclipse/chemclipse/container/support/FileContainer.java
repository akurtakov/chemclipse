/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.container.support;

import org.eclipse.chemclipse.container.definition.IFileContentProvider;
import org.eclipse.chemclipse.converter.core.IMagicNumberMatcher;

public class FileContainer {

	private String fileExtension = "";
	private IMagicNumberMatcher magicNumberMatcher = null;
	private IFileContentProvider contentProvider = null;

	public String getFileExtension() {

		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {

		this.fileExtension = fileExtension;
	}

	public IMagicNumberMatcher getMagicNumberMatcher() {

		return magicNumberMatcher;
	}

	public void setMagicNumberMatcher(IMagicNumberMatcher magicNumberMatcher) {

		this.magicNumberMatcher = magicNumberMatcher;
	}

	public IFileContentProvider getContentProvider() {

		return contentProvider;
	}

	public void setContentProvider(IFileContentProvider contentProvider) {

		this.contentProvider = contentProvider;
	}
}
