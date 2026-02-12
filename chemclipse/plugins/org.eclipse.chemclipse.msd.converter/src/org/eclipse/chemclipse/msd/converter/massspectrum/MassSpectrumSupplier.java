/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.massspectrum;

import org.eclipse.chemclipse.converter.core.AbstractSupplier;

public class MassSpectrumSupplier extends AbstractSupplier implements IMassSpectrumSupplier {

	@Override
	public void setFileExtension(final String fileExtension) {

		if(fileExtension != null && !fileExtension.isEmpty()) {
			String cleanedExtension = fileExtension.startsWith(".") ? fileExtension.substring(1) : fileExtension;
			super.setFileExtension(cleanedExtension);
		}
	}
}
