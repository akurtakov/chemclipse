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
package org.eclipse.chemclipse.ux.extension.msd.ui.support;

import org.eclipse.chemclipse.msd.converter.massspectrum.MassSpectrumConverter;
import org.eclipse.chemclipse.processing.converter.AbstractSupplierFileIdentifier;
import org.eclipse.chemclipse.processing.converter.ISupplierFileIdentifier;

public class MassSpectrumIdentifier extends AbstractSupplierFileIdentifier implements ISupplierFileIdentifier {

	public MassSpectrumIdentifier() {
		super(MassSpectrumConverter.getMassSpectrumConverterSupport().getSupplier());
	}

	@Override
	public String getType() {

		return TYPE_SCAN_MSD;
	}
}
