/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Alexander Kerner - implementation
 *******************************************************************************/
package org.eclipse.chemclipse.model.identifier;

import org.eclipse.chemclipse.model.settings.IProcessSettings;

public interface IDeltaCalculationSettings extends IProcessSettings {

	float MIN_DELTA_WINDOW = 0.0f;
	float MAX_DELTA_WINDOW = Float.MAX_VALUE;

	/**
	 * Retention Time / Index Delta Calculation
	 */
	DeltaCalculation getDeltaCalculation();

	void setDeltaCalculation(DeltaCalculation deltaCalculation);

	float getDeltaWindow();

	void setDeltaWindow(float deltaWindow);
}
