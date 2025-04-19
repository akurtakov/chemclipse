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
 * Christoph Läubrich - set size of wizard
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.handlers;

import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.ux.extension.xxd.ui.preferences.PreferenceSupplier;

public class OpenHandlerCSD extends AbstractOpenHandler {

	@Override
	protected DataType getDataType() {

		return DataType.CSD;
	}

	@Override
	protected String getPreferenceKey() {

		return PreferenceSupplier.P_FILTER_PATH_CHROMATOGRAM_CSD;
	}
}
