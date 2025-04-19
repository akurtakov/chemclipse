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
package org.eclipse.chemclipse.pcr.report.supplier.tabular.ui.internal.provider;

import org.eclipse.chemclipse.pcr.report.supplier.tabular.model.WellMapping;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.support.ui.provider.AbstractChemClipseLabelProvider;
import org.eclipse.swt.graphics.Image;

public class WellMappingLabelProvider extends AbstractChemClipseLabelProvider {

	public static final String[] TITLES = { //
			"Subset", //
			"Sample", //
			"Channels", //
			"Cutoff", //
			"positive", //
			"negative", //
	};
	//
	public static final int[] BOUNDS = { //
			150, //
			200, //
			150, //
			100, //
			200, //
			200, //
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

		String text = "";
		if(element instanceof WellMapping wellMapping) {
			switch(columnIndex) {
				case 0:
					text = wellMapping.getSubset();
					break;
				case 1:
					text = wellMapping.getSample();
					break;
				case 2:
					text = wellMapping.getChannelString();
					break;
				case 3:
					text = String.valueOf(wellMapping.getCutoff());
					break;
				case 4:
					text = wellMapping.getPositive();
					break;
				case 5:
					text = wellMapping.getNegative();
					break;
				default:
					text = "n.a.";
			}
		}
		return text;
	}

	@Override
	public Image getImage(Object element) {

		return ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_FILE, IApplicationImageProvider.SIZE_16x16);
	}
}