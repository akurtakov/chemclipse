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

import org.eclipse.chemclipse.pdfbox.extensions.settings.ReferenceX;
import org.eclipse.chemclipse.pdfbox.extensions.settings.ReferenceY;

public abstract class AbstractReferenceElement<T> extends AbstractElement<T> implements IReferenceElement<T> {

	private ReferenceX referenceX = ReferenceX.LEFT;
	private ReferenceY referenceY = ReferenceY.TOP;

	@Override
	public ReferenceX getReferenceX() {

		return referenceX;
	}

	@Override
	public T setReferenceX(ReferenceX referenceX) {

		this.referenceX = referenceX;
		return reference();
	}

	@Override
	public ReferenceY getReferenceY() {

		return referenceY;
	}

	@Override
	public T setReferenceY(ReferenceY referenceY) {

		this.referenceY = referenceY;
		return reference();
	}
}
