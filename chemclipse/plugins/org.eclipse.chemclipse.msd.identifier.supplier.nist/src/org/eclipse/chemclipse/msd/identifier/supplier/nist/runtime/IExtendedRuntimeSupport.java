/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.identifier.supplier.nist.runtime;

import java.util.List;

import org.eclipse.chemclipse.support.runtime.IRuntimeSupport;

public interface IExtendedRuntimeSupport extends IRuntimeSupport {

	/**
	 * Returns the NIST specific settings instance.
	 * 
	 * @return {@link INistSupport}
	 */
	INistSupport getNistSupport();

	/**
	 * If the parameter contains '/PAR=2', then the background modus is used.
	 * 
	 * @param parameter
	 * @return boolean
	 */
	default boolean isBatchModus() {

		List<String> parameter = getParameters();
		if(parameter != null) {
			return parameter.contains(INistSupport.PAR2);
		}
		return true;
	}
}
