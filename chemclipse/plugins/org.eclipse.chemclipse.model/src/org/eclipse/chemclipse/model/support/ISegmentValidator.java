/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.model.support;

public interface ISegmentValidator {

	default boolean acceptSegment(float[] values, double mean) {

		boolean acceptSegment = false;
		if(values.length > 0) {
			double[] doubles = new double[values.length];
			for(int i = 0; i < doubles.length; i++) {
				doubles[i] = values[i];
			}
			//
			acceptSegment = acceptSegment(doubles, mean);
		}

		return acceptSegment;
	}

	boolean acceptSegment(double[] values, double mean);
}