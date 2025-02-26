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
 * Philip Wenig - get rid of system settings
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.model.core;

import java.util.List;

import org.eclipse.chemclipse.model.core.IComplexSignalMeasurement;

public interface IMeasurementFID extends IComplexSignalMeasurement<ISignalFID> {

	AcquisitionParameter getAcquisitionParameter();

	/**
	 * Contains the signals of this {@link FIDMeasurement}, ordered with the lowest data time first
	 * 
	 * @return the signals that makes up this {@link FIDMeasurement}
	 */
	@Override
	List<? extends ISignalFID> getSignals();

	DataDimension getDataDimension();

	@Override
	default String getFilterStatistics() {

		return "";
	}
}
