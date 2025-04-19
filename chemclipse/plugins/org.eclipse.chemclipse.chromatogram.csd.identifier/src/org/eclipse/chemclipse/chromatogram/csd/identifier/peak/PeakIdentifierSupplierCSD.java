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
package org.eclipse.chemclipse.chromatogram.csd.identifier.peak;

import org.eclipse.chemclipse.chromatogram.csd.identifier.settings.IPeakIdentifierSettingsCSD;
import org.eclipse.chemclipse.model.identifier.core.AbstractSupplier;

public class PeakIdentifierSupplierCSD extends AbstractSupplier<IPeakIdentifierSettingsCSD> implements IPeakIdentifierSupplierCSD {

	@Override
	public Class<? extends IPeakIdentifierSettingsCSD> getSettingsClass() {

		return getSpecificIdentifierSettingsClass();
	}
}
