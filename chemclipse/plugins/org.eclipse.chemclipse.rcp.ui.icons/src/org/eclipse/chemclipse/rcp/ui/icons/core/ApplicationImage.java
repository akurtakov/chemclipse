/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - reimplementation to support discovering of bundles
 *******************************************************************************/
package org.eclipse.chemclipse.rcp.ui.icons.core;

import org.osgi.framework.Bundle;

public class ApplicationImage extends AbstractApplicationImage implements IApplicationImage {

	public ApplicationImage(Bundle bundle) {

		super(bundle);
	}

	/**
	 * Removes the legacy prefix path.
	 * 
	 * @param fileName
	 * @return String
	 */
	public static String adjustLegacyPath(String fileName) {

		if(fileName.startsWith(PREFIX_PATH_LEGACY)) {
			return fileName.replace(PREFIX_PATH_LEGACY, "");
		} else {
			return fileName;
		}
	}
}