/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.nmr.model.core;

import java.util.Collection;

import org.eclipse.chemclipse.model.core.AbstractMeasurementInfo;
import org.eclipse.chemclipse.model.core.IComplexSignalMeasurement;

public class SpectrumNMR extends AbstractMeasurementInfo implements ISpectrumNMR {

	private static final long serialVersionUID = 4818664376666278484L;

	private Collection<IComplexSignalMeasurement<?>> complexSignalMeasurements;

	@Override
	public Collection<IComplexSignalMeasurement<?>> getComplexSignalMeasurements() {

		return complexSignalMeasurements;
	}

	@Override
	public void setComplexSignalMeasurements(Collection<IComplexSignalMeasurement<?>> complexSignalMeasurements) {

		this.complexSignalMeasurements = complexSignalMeasurements;
	}
}