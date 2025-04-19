/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.internal.provider;

import java.text.DecimalFormat;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model.TargetTrace;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.l10n.Messages;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.support.ui.provider.AbstractChemClipseLabelProvider;
import org.eclipse.swt.graphics.Image;

public class WncResultsLabelProvider extends AbstractChemClipseLabelProvider {

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
		String text = ""; //$NON-NLS-1$
		if(element instanceof TargetTrace targetTrace) {
			switch(columnIndex) {
				case 0:
					text = targetTrace.getName();
					break;
				case 1:
					text = Integer.toString(targetTrace.getIon());
					break;
				case 2:
					text = decimalFormat.format(targetTrace.getPercentageSumIntensity());
					break;
				case 3:
					text = decimalFormat.format(targetTrace.getPercentageMaxIntensity());
					break;
				default:
					text = Messages.nv;
			}
		}
		return text;
	}

	@Override
	public Image getImage(Object element) {

		return ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_ION, IApplicationImageProvider.SIZE_16x16);
	}
}