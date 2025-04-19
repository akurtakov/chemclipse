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
 * Philip Wenig - optimize valid calculation
 *******************************************************************************/
package org.eclipse.chemclipse.model.statistics;

import java.util.List;

public interface ISamples<V extends IVariable, S extends ISample> {

	List<S> getSamples();

	List<V> getVariables();

	/**
	 * Returns true if at least 2 samples contain
	 * data for the given feature.
	 * 
	 * @param row
	 * @return boolean
	 */
	default boolean containsValidData(int row) {

		int counter = 0;
		for(ISample sample : getSamples()) {
			if(sample.isSelected()) {
				if(!sample.getSampleData().get(row).isEmpty()) {
					counter++;
					if(counter >= 2) {
						return true;
					}
				}
			}
		}
		//
		return false;
	}
}