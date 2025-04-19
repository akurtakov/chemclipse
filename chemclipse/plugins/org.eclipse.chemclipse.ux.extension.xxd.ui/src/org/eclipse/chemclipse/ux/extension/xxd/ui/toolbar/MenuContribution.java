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

import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;

public class MenuContribution {

	private MMenuElement menuElement = null;
	private int index = -1;

	public MenuContribution(MMenuElement menuElement) {

		this(menuElement, -1);
	}

	public MenuContribution(MMenuElement menuElement, int index) {

		this.menuElement = menuElement;
		this.index = index;
	}

	public MMenuElement getMenuElement() {

		return menuElement;
	}

	public int getIndex() {

		return index;
	}
}
