/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.ui.explorer;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public abstract class AbstractSelectionView implements ISelectionView {

	private MPart part;
	private EPartService partService;

	public AbstractSelectionView(MPart part, EPartService partService) {
		this.part = part;
		this.partService = partService;
	}

	@Override
	public boolean isPartVisible() {

		if(partService != null && partService.isPartVisible(part)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean doUpdate(Object document) {

		if(isPartVisible() && document != null) {
			return true;
		}
		return false;
	}
}
