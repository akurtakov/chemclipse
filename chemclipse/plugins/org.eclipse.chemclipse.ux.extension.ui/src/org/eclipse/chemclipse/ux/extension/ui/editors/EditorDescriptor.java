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
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.editors;

import org.eclipse.jface.resource.ImageDescriptor;

public interface EditorDescriptor {

	/**
	 * 
	 * @return the {@link ImageDescriptor} for this editor or <code>null</code> if the default should be used
	 */
	default ImageDescriptor getImageDescriptor() {

		return null;
	}
}
