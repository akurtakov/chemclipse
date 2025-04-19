/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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

/**
 * This class defines a start and stop background abundances used to create a
 * peak with PeakBuilder.
 */
public interface IBackgroundAbundanceRange {

	float MIN_BACKGROUND_ABUNDANCE = 0;
	float MAX_BACKGROUND_ABUNDANCE = Float.MAX_VALUE;

	float getStartBackgroundAbundance();

	float getStopBackgroundAbundance();
}
