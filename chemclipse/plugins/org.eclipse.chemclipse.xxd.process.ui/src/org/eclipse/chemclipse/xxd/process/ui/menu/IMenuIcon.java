/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.ui.menu;

import org.eclipse.swt.graphics.Image;

public interface IMenuIcon {

	public static final String EXTENSION_POINT_ID = "org.eclipse.chemclipse.xxd.process.ui.menu.icon";

	Image getImage();
}
