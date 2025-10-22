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
 * Christoph Läubrich - change to Activator.getDefault().getApplicationImage()
 *******************************************************************************/
package org.eclipse.chemclipse.rcp.ui.icons.core;

import org.osgi.framework.FrameworkUtil;

public class ApplicationImageFactory {

	private static IApplicationImage applicationImage = null;

	private ApplicationImageFactory() {

	}

	/**
	 * Returns an instance of IApplicationImage.
	 * 
	 * @return {@link IApplicationImage}
	 */
	public static IApplicationImage getInstance() {

		if(applicationImage == null) {
			applicationImage = new ApplicationImage(FrameworkUtil.getBundle(ApplicationImageFactory.class));
		}

		return applicationImage;
	}
}