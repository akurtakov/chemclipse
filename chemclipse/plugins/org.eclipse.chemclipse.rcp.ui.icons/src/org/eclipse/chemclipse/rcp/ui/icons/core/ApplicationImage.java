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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

public class ApplicationImage extends AbstractApplicationImage implements IApplicationImage {

	private ImageDecorator imageDecorator = new ImageDecorator();
	private Map<String, Image> decoratedImageCache = new HashMap<>();

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

	@Override
	public Image getImage(String fileName, String size, boolean active) {

		Image image = super.getImage(fileName, size);
		if(active && image != null) {
			String path = getPath(fileName, size) + "_decorated";
			Image decoratedImage = decoratedImageCache.get(path);
			if(decoratedImage == null) {
				imageDecorator.setSize(size);
				imageDecorator.setImage(image);
				decoratedImage = imageDecorator.createImage();
				if(decoratedImage != null) {
					decoratedImageCache.put(path, decoratedImage);
					image = decoratedImage;
				}
			} else {
				image = decoratedImage;
			}
		}

		return image;
	}
}