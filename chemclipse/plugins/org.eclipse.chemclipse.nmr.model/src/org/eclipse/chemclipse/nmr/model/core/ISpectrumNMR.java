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

import org.eclipse.chemclipse.model.core.IComplexSignalMeasurement;
import org.eclipse.chemclipse.model.core.IMeasurementInfo;

public interface ISpectrumNMR extends IMeasurementInfo {

	Collection<IComplexSignalMeasurement<?>> getComplexSignalMeasurements();

	void setComplexSignalMeasurements(Collection<IComplexSignalMeasurement<?>> complexSignalMeasurements);
}
