/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.pdfbox.extensions.elements;

import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class ImageElement extends AbstractReferenceElement<ImageElement> {

	private PDImageXObject image;
	private float width = 0.0f;
	private float height = 0.0f;

	public ImageElement(float x, float y) {
		setX(x);
		setY(y);
	}

	public PDImageXObject getImage() {

		return image;
	}

	public ImageElement setImage(PDImageXObject image) {

		this.image = image;
		return this;
	}

	public float getWidth() {

		return width;
	}

	public ImageElement setWidth(float width) {

		this.width = width;
		return this;
	}

	public float getHeight() {

		return height;
	}

	public ImageElement setHeight(float height) {

		this.height = height;
		return this;
	}
}
