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

import org.eclipse.chemclipse.model.exceptions.NoIdentifierAvailableException;
import org.eclipse.chemclipse.model.identifier.core.AbstractSupport;

public class PeakIdentifierSupportCSD extends AbstractSupport<IPeakIdentifierSupplierCSD> implements IPeakIdentifierSupportCSD {

	@Override
	public IPeakIdentifierSupplierCSD getIdentifierSupplier(String identifierId) throws NoIdentifierAvailableException {

		return getSpecificIdentifierSupplier(identifierId);
	}
}
