/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Dr. Lorenz Gerber - initial API and implementation
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.classifier.supplier.molpeak;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class PathResolver {

	public static final String REFERENCES = "standards/references.msl";
	public static final String GERBER_ET_AL_2012 = "standards/gerberetal2012.msl";

	public static String getAbsolutePath(String string) {

		Bundle bundle = FrameworkUtil.getBundle(PathResolver.class);
		IPath path = new Path(string);
		URL url = FileLocator.find(bundle, path, null);
		try {
			return FileLocator.resolve(url).getPath();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
