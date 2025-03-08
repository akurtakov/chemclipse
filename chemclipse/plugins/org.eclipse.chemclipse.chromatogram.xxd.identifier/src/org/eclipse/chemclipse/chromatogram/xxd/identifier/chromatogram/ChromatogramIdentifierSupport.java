/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
 *
 * All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Dr. Philip Wenig - initial API and implementation
 * Jan Holy - implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.identifier.chromatogram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.exceptions.NoIdentifierAvailableException;
import org.eclipse.chemclipse.model.identifier.core.AbstractSupport;
import org.eclipse.chemclipse.support.literature.LiteratureReference;

public class ChromatogramIdentifierSupport extends AbstractSupport<IChromatogramIdentifierSupplier> implements IChromatogramIdentifierSupport {

	private List<LiteratureReference> literatureReference = new ArrayList<>();

	@Override
	public IChromatogramIdentifierSupplier getIdentifierSupplier(String identifierId) throws NoIdentifierAvailableException {

		return getSpecificIdentifierSupplier(identifierId);
	}

	@Override
	public List<LiteratureReference> getLiteratureReferences() {

		return literatureReference;
	}
}
