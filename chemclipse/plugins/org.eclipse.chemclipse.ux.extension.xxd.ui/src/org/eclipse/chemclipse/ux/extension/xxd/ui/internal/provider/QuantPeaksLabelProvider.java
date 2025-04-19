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
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider;

import java.text.DecimalFormat;

import org.eclipse.chemclipse.model.quantitation.IQuantitationPeak;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.support.ui.provider.AbstractChemClipseLabelProvider;
import org.eclipse.chemclipse.ux.extension.xxd.ui.l10n.ExtensionMessages;
import org.eclipse.chemclipse.ux.extension.xxd.ui.support.charts.PeakDataSupport;
import org.eclipse.swt.graphics.Image;

public class QuantPeaksLabelProvider extends AbstractChemClipseLabelProvider {

	public static final String CONCENTRATION = ExtensionMessages.concentration;
	public static final String CONCENTRATION_UNIT = ExtensionMessages.unit;
	//
	private PeakDataSupport peakDataSupport = new PeakDataSupport();
	//
	public static final String[] TITLES = { //
			CONCENTRATION, //
			CONCENTRATION_UNIT, //
			"Type" //
	};
	//
	public static final int[] BOUNDS = { //
			100, //
			100, //
			100 //
	};

	@Override
	public Image getColumnImage(Object element, int columnIndex) {

		if(columnIndex == 0) {
			return getImage(element);
		}
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		DecimalFormat decimalFormat = getDecimalFormat();
		String text = "";
		if(element instanceof IQuantitationPeak entry) {
			switch(columnIndex) {
				case 0:
					text = decimalFormat.format(entry.getConcentration());
					break;
				case 1:
					text = entry.getConcentrationUnit();
					break;
				case 2:
					text = peakDataSupport.getType(entry.getReferencePeak());
					break;
				default:
					text = "n.v.";
			}
		}
		return text;
	}

	@Override
	public Image getImage(Object element) {

		return ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_QUANTIFY_SELECTED_PEAK, IApplicationImage.SIZE_16x16);
	}
}
