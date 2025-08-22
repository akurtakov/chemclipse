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

import org.eclipse.chemclipse.model.identifier.template.TargetTemplate;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.support.ui.provider.AbstractChemClipseLabelProvider;
import org.eclipse.swt.graphics.Image;

public class TargetTemplateLabelProvider extends AbstractChemClipseLabelProvider {

	public static final String NAME = "Name";
	public static final String CAS = "CAS";
	public static final String COMMENTS = "Comments";
	public static final String CONTRIBUTOR = "Contributor";
	public static final String REFERENCE_ID = "Reference ID";

	public static final String[] TITLES = { //
			NAME, //
			CAS, //
			COMMENTS, //
			CONTRIBUTOR, //
			REFERENCE_ID//
	};
	public static final int[] BOUNDS = { //
			250, //
			100, //
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

		String text = "";
		if(element instanceof TargetTemplate targetTemplate) {
			switch(columnIndex) {
				case 0:
					text = targetTemplate.getName();
					break;
				case 1:
					text = targetTemplate.getCasNumber();
					break;
				case 2:
					text = targetTemplate.getComments();
					break;
				case 3:
					text = targetTemplate.getContributor();
					break;
				case 4:
					text = targetTemplate.getReferenceId();
					break;
				default:
					text = "n.v.";
			}
		}
		return text;
	}

	@Override
	public Image getImage(Object element) {

		return ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_TARGETS, IApplicationImageProvider.SIZE_16x16);
	}
}
