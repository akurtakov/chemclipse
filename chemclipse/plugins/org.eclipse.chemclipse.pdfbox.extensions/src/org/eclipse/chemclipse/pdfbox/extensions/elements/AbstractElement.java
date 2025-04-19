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

public abstract class AbstractElement<T> implements IElement<T> {

	private float x = 0.0f;
	private float y = 0.0f;

	@Override
	public float getX() {

		return x;
	}

	public T setX(float x) {

		this.x = x;
		return reference();
	}

	@Override
	public float getY() {

		return y;
	}

	public T setY(float y) {

		this.y = y;
		return reference();
	}

	@SuppressWarnings("unchecked")
	protected T reference() {

		return (T)this;
	}
}
