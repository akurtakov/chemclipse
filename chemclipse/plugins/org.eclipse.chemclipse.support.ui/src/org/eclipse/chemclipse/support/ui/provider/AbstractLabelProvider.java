/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.provider;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

public abstract class AbstractLabelProvider implements ILabelProvider {

	@Override
	public void removeListener(ILabelProviderListener listener) {

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {

		return false;
	}

	@Override
	public void dispose() {

	}

	@Override
	public void addListener(ILabelProviderListener listener) {

	}

	@Override
	public String getText(Object element) {

		return null;
	}

	@Override
	public Image getImage(Object element) {

		return null;
	}
}
