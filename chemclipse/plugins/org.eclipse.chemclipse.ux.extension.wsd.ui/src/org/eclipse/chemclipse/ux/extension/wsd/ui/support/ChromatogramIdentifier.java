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
package org.eclipse.chemclipse.ux.extension.wsd.ui.support;

import org.eclipse.chemclipse.processing.converter.AbstractSupplierFileIdentifier;
import org.eclipse.chemclipse.processing.converter.ISupplierFileIdentifier;
import org.eclipse.chemclipse.wsd.converter.chromatogram.ChromatogramConverterWSD;

public class ChromatogramIdentifier extends AbstractSupplierFileIdentifier implements ISupplierFileIdentifier {

	public ChromatogramIdentifier() {
		super(ChromatogramConverterWSD.getInstance().getChromatogramConverterSupport().getSupplier());
	}

	@Override
	public String getType() {

		return TYPE_WSD;
	}
}
