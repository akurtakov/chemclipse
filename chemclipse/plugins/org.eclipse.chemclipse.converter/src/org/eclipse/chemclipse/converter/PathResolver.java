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
import java.net.URI;
import java.net.URISyntaxException;
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

		URL url = FileLocator.find(bundle, new Path(path), null);
		if(url == null) {
			throw new IOException("Cannot find resource '" + path + "' in bundle '" + bundle.getSymbolicName() + "'");
		}
		URL fileURL = FileLocator.toFileURL(url);
		try {
			/*
			 * Construct a properly encoded URI from the file: URL components.
			 * Using new URI(scheme, ssp, fragment) encodes special characters
			 * (e.g. spaces) and correctly handles Windows drive-letter paths
			 * where URL.getPath() may include a leading slash (e.g. /C:/...).
			 */
			return new File(new URI(fileURL.getProtocol(), fileURL.getPath(), null));
		} catch(URISyntaxException e) {
			throw new IOException("Cannot convert URL to file: " + fileURL, e);
		}
	}
}
