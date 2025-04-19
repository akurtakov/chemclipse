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
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider;

import java.text.DecimalFormat;

import org.eclipse.chemclipse.model.core.IIntegrationEntry;
import org.eclipse.chemclipse.model.core.SignalSupport;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.support.ui.provider.AbstractChemClipseLabelProvider;
import org.eclipse.chemclipse.ux.extension.xxd.ui.l10n.ExtensionMessages;
import org.eclipse.swt.graphics.Image;

public class IntegrationAreaLabelProvider extends AbstractChemClipseLabelProvider {

	public static final String AREA = ExtensionMessages.area;
	public static final String TRACE = ExtensionMessages.trace;
	public static final String TYPE = ExtensionMessages.type;
	//
	public static final String[] TITLES = { //
			AREA, //
			TRACE, //
			TYPE //
	};
	//
	public static final int[] BOUNDS = { //
			150, //
			150, //
			150 //
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
		if(element instanceof IIntegrationEntry integrationEntry) {
			switch(columnIndex) {
				case 0:
					text = decimalFormat.format(integrationEntry.getIntegratedArea());
					break;
				case 1: // TIC ...
					text = SignalSupport.asText(integrationEntry.getSignal(), decimalFormat);
					break;
				case 2:
					text = integrationEntry.getIntegrationType().label();
					break;
				default:
					text = "n.v.";
			}
		}
		return text;
	}

	@Override
	public Image getImage(Object element) {

		return ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_INTEGRATION_RESULTS, IApplicationImage.SIZE_16x16);
	}
}