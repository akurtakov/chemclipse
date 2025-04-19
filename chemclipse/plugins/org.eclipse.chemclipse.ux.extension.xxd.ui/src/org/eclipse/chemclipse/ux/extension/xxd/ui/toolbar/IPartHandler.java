/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.toolbar;

import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;

public interface IPartHandler {

	boolean isPartStackAssigned();

	boolean isPartVisible();

	void action(boolean show);

	default String getName() {

		return "";
	}

	PartStackReference getPartStackReference();

	default String getIconURI() {

		return ApplicationImageFactory.getInstance().getURI(IApplicationImage.IMAGE_TAG, IApplicationImageProvider.SIZE_16x16);
	}

	void toggleVisibility();
}