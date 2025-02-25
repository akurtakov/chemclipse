/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - refactoring
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.processing.supplier.base.core;

import org.eclipse.chemclipse.model.core.IMeasurement;
import org.eclipse.chemclipse.nmr.model.core.ISpectrumMeasurement;
import org.eclipse.chemclipse.processing.DataCategory;

public abstract class AbstractSpectrumSignalFilter<ConfigType> extends AbstractComplexSignalFilter<ConfigType, ISpectrumMeasurement> {

	private static final long serialVersionUID = -597003482088833773L;

	protected AbstractSpectrumSignalFilter(Class<ConfigType> configClass) {

		super(configClass);
	}

	@Override
	public DataCategory[] getDataCategories() {

		return new DataCategory[]{DataCategory.NMR};
	}

	@Override
	public boolean acceptsIMeasurement(IMeasurement item) {

		return item instanceof ISpectrumMeasurement spectrumMeasurement && accepts(spectrumMeasurement);
	}

	protected boolean accepts(ISpectrumMeasurement item) {

		return true;
	}
}
