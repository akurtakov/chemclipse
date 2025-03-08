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

import java.util.List;

import org.eclipse.chemclipse.model.exceptions.NoIdentifierAvailableException;
import org.eclipse.chemclipse.model.identifier.core.ISupport;
import org.eclipse.chemclipse.support.literature.LiteratureReference;

public interface IChromatogramIdentifierSupport extends ISupport {

	@Override
	IChromatogramIdentifierSupplier getIdentifierSupplier(String identifierId) throws NoIdentifierAvailableException;

	List<LiteratureReference> getLiteratureReferences();
}
