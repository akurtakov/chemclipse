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

public interface IIdentifierSettings extends IProcessSettings {

	float DEF_LIMIT_MATCH_FACTOR = 100.0f;
	float MIN_LIMIT_MATCH_FACTOR = 0.0f;
	float MAX_LIMIT_MATCH_FACTOR = 100.0f;

	/**
	 * Limit Match Factor
	 * 
	 * @return float
	 */
	float getLimitMatchFactor();

	/**
	 * Only identify the peak if no target is available with a match factor >= the limit.
	 * 
	 * @param limitMatchFactor
	 */
	void setLimitMatchFactor(float limitMatchFactor);
}