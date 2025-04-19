/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Jan Holy - initial API and implementation
 * Philip Wenig - improvements
 *******************************************************************************/
package org.eclipse.chemclipse.model.statistics;

public interface ISampleData<T> {

	double getData();

	double getModifiedData();

	default boolean isEmpty() {

		return Double.isNaN(getData());
	}

	void setModifiedData(double normalizedData);

	/**
	 * This is the data source.
	 * 
	 * @return T
	 */
	T getDataObject();
}