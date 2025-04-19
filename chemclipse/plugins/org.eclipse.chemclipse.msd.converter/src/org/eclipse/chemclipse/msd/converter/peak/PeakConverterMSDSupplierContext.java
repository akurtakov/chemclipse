/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.peak;

import java.util.Collection;

import org.eclipse.chemclipse.processing.converter.ISupplier;
import org.eclipse.chemclipse.processing.converter.SupplierContext;
import org.osgi.service.component.annotations.Component;

@Component(service = {SupplierContext.class})
public class PeakConverterMSDSupplierContext implements SupplierContext {

	@Override
	public Collection<ISupplier> getSupplier() {

		return PeakConverterMSD.getPeakConverterSupport().getSupplier();
	}
}
