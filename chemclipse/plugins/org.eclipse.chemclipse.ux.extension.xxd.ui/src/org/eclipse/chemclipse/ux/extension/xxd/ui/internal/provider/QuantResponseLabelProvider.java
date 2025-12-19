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

import org.eclipse.chemclipse.model.core.SignalSupport;
import org.eclipse.chemclipse.model.quantitation.IResponseSignal;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.support.ui.provider.AbstractChemClipseLabelProvider;
import org.eclipse.chemclipse.ux.extension.xxd.ui.l10n.ExtensionMessages;
import org.eclipse.swt.graphics.Image;

public class QuantResponseLabelProvider extends AbstractChemClipseLabelProvider {

	public static final String SIGNAL = ExtensionMessages.signal;
	public static final String CONCENTRATION = ExtensionMessages.concentration;
	public static final String RESPONSE = ExtensionMessages.response;

	public static final String[] TITLES = { //
			SIGNAL, //
			CONCENTRATION, //
			RESPONSE//
	};

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
		if(element instanceof IResponseSignal responseSignal) {

			switch(columnIndex) {
				case 0:
					text = SignalSupport.asText(responseSignal.getSignal(), decimalFormat);
					break;
				case 1:
					text = decimalFormat.format(responseSignal.getConcentration());
					break;
				case 2:
					text = decimalFormat.format(responseSignal.getResponse());
					break;
				default:
					text = "n.v.";
			}
		}
		return text;
	}

	@Override
	public Image getImage(Object element) {

		return ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_QUANTIFY_SELECTED_PEAK, IApplicationImageProvider.SIZE_16x16);
	}
}
