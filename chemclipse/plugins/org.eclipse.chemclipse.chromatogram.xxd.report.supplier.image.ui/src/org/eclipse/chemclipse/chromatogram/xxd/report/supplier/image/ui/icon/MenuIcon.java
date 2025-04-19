/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.report.supplier.image.ui.icon;

import org.eclipse.chemclipse.xxd.process.ui.menu.IMenuIcon;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swtchart.extensions.core.ResourceSupport;

public class MenuIcon implements IMenuIcon {

	@Override
	public Image getImage() {

		return ResourceSupport.getImage(ResourceSupport.ICON_BITMAP);
	}
}
