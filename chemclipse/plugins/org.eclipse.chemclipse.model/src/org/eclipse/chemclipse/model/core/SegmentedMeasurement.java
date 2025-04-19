/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.core;

import java.util.List;

import org.eclipse.chemclipse.model.support.IAnalysisSegment;

public interface SegmentedMeasurement extends IMeasurement {

	/**
	 * 
	 * @return a read only view of all current {@link IAnalysisSegment}s in the current measurement
	 */
	List<IAnalysisSegment> getAnalysisSegments();
}
