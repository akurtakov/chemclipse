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
package org.eclipse.chemclipse.pdfbox.extensions.settings;

import java.util.HashMap;
import java.util.Map;

public class ConverterFactory {

	private static final Map<Unit, IUnitConverter> UNIT_CONVERTER_MAP = new HashMap<>();
	private static final Map<PageBase, IPageBaseConverter> PAGE_BASE_CONVERTER_MAP = new HashMap<>();

	public static IUnitConverter getInstance(Unit unit) {

		if(!UNIT_CONVERTER_MAP.containsKey(unit)) {
			IUnitConverter unitConverter = new IUnitConverter() {

				@Override
				public float getFactor() {

					return unit.getFactor();
				}

				@Override
				public float convertToPt(float value) {

					return value * getFactor();
				}

				@Override
				public float convertFromPt(float value) {

					return value / getFactor();
				}
			};
			UNIT_CONVERTER_MAP.put(unit, unitConverter);
		}
		//
		return UNIT_CONVERTER_MAP.get(unit);
	}

	public static IPageBaseConverter getInstance(PageBase pageBase) {

		if(!PAGE_BASE_CONVERTER_MAP.containsKey(pageBase)) {
			IPageBaseConverter baseConverter = new IPageBaseConverter() {

				@Override
				public float getPositionX(float pageWidth, float x) {

					return pageBase.getFactorWidth() * pageWidth + (pageBase.isSubtractWidth() ? -x : x);
				}

				@Override
				public float getPositionY(float pageHeight, float y) {

					return pageBase.getFactorHeight() * pageHeight + (pageBase.isSubtractHeight() ? -y : y);
				}
			};
			PAGE_BASE_CONVERTER_MAP.put(pageBase, baseConverter);
		}
		//
		return PAGE_BASE_CONVERTER_MAP.get(pageBase);
	}
}
