/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.converter;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;

public class PathResolver {

	/**
	 * Returns a file within a bundle.
	 * 
	 * @param bundle
	 *            where to search
	 * @param path
	 *            relative path within the bundle
	 * @throws IOException
	 * @return File
	 */
	public static File getFile(final Bundle bundle, final String path) throws IOException {

		if(path == null || "".equals(path)) {
			throw new IOException();
		}

		URL url = FileLocator.find(bundle, new Path(path), null);
		return new File(FileLocator.resolve(url).getPath());
	}
}
