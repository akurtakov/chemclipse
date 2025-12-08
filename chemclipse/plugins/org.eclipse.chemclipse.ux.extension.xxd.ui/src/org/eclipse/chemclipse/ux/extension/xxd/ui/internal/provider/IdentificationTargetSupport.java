/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.model.identifier.IComparisonResult;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.identifier.IRatingSupplier;
import org.eclipse.chemclipse.rcp.ui.icons.core.ApplicationImageFactory;
import org.eclipse.chemclipse.rcp.ui.icons.core.IApplicationImage;
import org.eclipse.swt.graphics.Image;

public class IdentificationTargetSupport {

	public static Image getRatingSymbol(IIdentificationTarget identificationTarget) {

		IComparisonResult comparisonResult = identificationTarget.getComparisonResult();
		IRatingSupplier ratingSupplier = comparisonResult.getRatingSupplier();

		String fileName;
		switch(ratingSupplier.getStatus()) {
			case VERY_GOOD:
				fileName = IApplicationImage.IMAGE_RATING_VERY_GOOD;
				break;
			case GOOD:
				fileName = IApplicationImage.IMAGE_RATING_GOOD;
				break;
			case AVERAGE:
				fileName = IApplicationImage.IMAGE_RATING_AVERAGE;
				break;
			case BAD:
				fileName = IApplicationImage.IMAGE_RATING_BAD;
				break;
			case VERY_BAD:
				fileName = IApplicationImage.IMAGE_RATING_VERY_BAD;
				break;
			default:
				fileName = "";
				break;
		}

		if(!fileName.isEmpty()) {
			return ApplicationImageFactory.getInstance().getImage(fileName, IApplicationImage.SIZE_16x16);
		}

		return null;
	}
}
