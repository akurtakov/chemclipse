/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - add support for getting a result by class
 *******************************************************************************/
package org.eclipse.chemclipse.model.core;

import java.util.Collection;

public interface IMeasurementResultSupport {

	/**
	 * An existing result will be replaced if a measurement result with the same id
	 * is still stored.
	 * 
	 * @param chromatogramResult
	 */
	void addMeasurementResult(IMeasurementResult<?> chromatogramResult);

	/**
	 * Returns the result stored by the given identifier.
	 * 
	 * @param identifier
	 * @return {@link IMeasurementResult}
	 */
	IMeasurementResult<?> getMeasurementResult(String identifier);

	/**
	 * Delete the measurement result stored by the given identifier.
	 * 
	 * @param identifier
	 */
	void deleteMeasurementResult(String identifier);

	/**
	 * Deletes all measurement results.
	 */
	void removeAllMeasurementResults();

	/**
	 * Returns a collection of all measurement results.
	 * 
	 * @return Collection
	 */
	Collection<IMeasurementResult<?>> getMeasurementResults();

	default <T extends IMeasurementResult<?>> T getMeasurementResult(Class<T> type) {

		Collection<IMeasurementResult<?>> measurementResults = getMeasurementResults();
		for(IMeasurementResult<?> result : measurementResults) {
			if(type.isInstance(result)) {
				return type.cast(result);
			}
		}

		return null;
	}
}
