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
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider;

import org.eclipse.chemclipse.model.traces.NamedTrace;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.support.ui.provider.AbstractChemClipseLabelProvider;
import org.eclipse.chemclipse.ux.extension.xxd.ui.l10n.ExtensionMessages;
import org.eclipse.swt.graphics.Image;

public class NamedTracesLabelProvider extends AbstractChemClipseLabelProvider {

	public static final String IDENTIFIER = ExtensionMessages.identifier;
	public static final String TRACES = ExtensionMessages.traces;
	//
	public static final String[] TITLES = { //
			IDENTIFIER, //
			TRACES //
	};
	public static final int[] BOUNDS = { //
			300, //
			250 //
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
		if(element instanceof NamedTrace namedTrace) {
			switch(columnIndex) {
				case 0:
					text = namedTrace.getIdentifier();
					break;
				case 1:
					text = namedTrace.getTraces();
					break;
			}
		}
		return text;
	}

	@Override
	public Image getImage(Object element) {

		return ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_PEAK_TRACES, IApplicationImageProvider.SIZE_16x16);
	}
}
