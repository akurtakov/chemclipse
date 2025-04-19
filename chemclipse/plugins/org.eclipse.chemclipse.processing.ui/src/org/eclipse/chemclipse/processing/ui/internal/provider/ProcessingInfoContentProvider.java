/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - use {@link IMessageProvider} interface
 *******************************************************************************/
package org.eclipse.chemclipse.processing.ui.internal.provider;

import org.eclipse.chemclipse.processing.core.IMessageProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ProcessingInfoContentProvider implements IStructuredContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	@Override
	public Object[] getElements(Object inputElement) {

		/*
		 * Processing messages
		 */
		if(inputElement instanceof IMessageProvider processingInfo) {
			return processingInfo.getMessages().toArray();
		} else {
			return null;
		}
	}
}
