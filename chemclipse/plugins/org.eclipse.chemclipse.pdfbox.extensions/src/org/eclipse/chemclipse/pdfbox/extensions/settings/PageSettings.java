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
package org.eclipse.chemclipse.pdfbox.extensions.settings;

import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class PageSettings {

	private PDRectangle pdRectangle;
	private PageBase pageBase = PageBase.BOTTOM_LEFT;
	private Unit unit = Unit.PT;
	private boolean landscape = false;

	public PageSettings(PDRectangle pdRectangle, PageBase pageBase, Unit unit, boolean landscape) {
		this.pdRectangle = pdRectangle;
		this.pageBase = pageBase;
		this.unit = unit;
		this.landscape = landscape;
	}

	public PDRectangle getPDRectangle() {

		return pdRectangle;
	}

	public PageBase getPageBase() {

		return pageBase;
	}

	public Unit getUnit() {

		return unit;
	}

	public boolean isLandscape() {

		return landscape;
	}
}
