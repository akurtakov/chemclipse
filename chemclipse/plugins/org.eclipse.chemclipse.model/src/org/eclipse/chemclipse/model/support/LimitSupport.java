/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
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

import java.util.Set;

import org.eclipse.chemclipse.model.identifier.IComparisonResult;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;

public class LimitSupport {

	/**
	 * Returns true if no target is available with >= limit match factor.
	 * 
	 * @param identificationTargets
	 * @param limitMatchFactor
	 * @return boolean
	 */
	public static boolean doIdentify(Set<IIdentificationTarget> identificationTargets, float limitMatchFactor) {

		if(identificationTargets == null) {
			return false;
		}
		//
		for(IIdentificationTarget identificationTarget : identificationTargets) {
			IComparisonResult comparisonResult = identificationTarget.getComparisonResult();
			if(comparisonResult.getMatchFactor() >= limitMatchFactor) {
				return false;
			}
		}
		//
		return true;
	}
}