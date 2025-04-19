/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.identifier.scan;

import org.eclipse.chemclipse.model.exceptions.NoIdentifierAvailableException;
import org.eclipse.chemclipse.model.identifier.core.AbstractSupport;

public class ScanIdentifierSupport extends AbstractSupport<IScanIdentifierSupplier> implements IScanIdentifierSupport {

	@Override
	public IScanIdentifierSupplier getIdentifierSupplier(String identifierId) throws NoIdentifierAvailableException {

		return getSpecificIdentifierSupplier(identifierId);
	}
}
