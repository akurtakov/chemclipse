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
package org.eclipse.chemclipse.xxd.classification.ui.provider;

import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImageProvider;
import org.eclipse.chemclipse.support.ui.provider.AbstractChemClipseLabelProvider;
import org.eclipse.chemclipse.xxd.classification.model.ClassificationRule;
import org.eclipse.swt.graphics.Image;

public class ClassificationRuleLabelProvider extends AbstractChemClipseLabelProvider {

	public static final String SEARCH_EXPRESSION = "Search Expression";
	public static final String CLASSIFICATION = "Classification";
	public static final String REFERENCE = "Reference";
	//
	public static final String[] TITLES = { //
			SEARCH_EXPRESSION, //
			CLASSIFICATION, //
			REFERENCE //
	};
	public static final int[] BOUNDS = { //
			200, //
			200, //
			200 //
	};

	@Override
	public Image getColumnImage(Object element, int columnIndex) {

		if(columnIndex == 0) {
			return getImage(element);
		} else {
			return null;
		}
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		String text = "";
		if(element instanceof ClassificationRule rule) {
			switch(columnIndex) {
				case 0:
					text = rule.getSearchExpression();
					break;
				case 1:
					text = rule.getClassification();
					break;
				case 2:
					text = rule.getReference().label();
					break;
				default:
					text = "n.a.";
			}
		}
		return text;
	}

	@Override
	public Image getImage(Object element) {

		return ApplicationImageFactory.getInstance().getImage(IApplicationImage.IMAGE_LABELS, IApplicationImageProvider.SIZE_16x16);
	}
}
