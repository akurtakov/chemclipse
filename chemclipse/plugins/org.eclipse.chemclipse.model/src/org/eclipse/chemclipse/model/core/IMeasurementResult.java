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
 * Christoph Läubrich - add generic
 *******************************************************************************/
package org.eclipse.chemclipse.model.core;

import java.io.Serializable;

public interface IMeasurementResult<ResultType> extends Serializable {

	String getName();

	/**
	 * Returns the result identifier, used to store in the chromatogram hash map.
	 * Prefer to use the IDN of the plug-in that supports the result.
	 * 
	 * @return String
	 */
	String getIdentifier();

	/**
	 * Returns a short description of the result.
	 * 
	 * @return String
	 */
	String getDescription();

	/**
	 * Each plug-in may store its own result object, hence it returns a generic object.
	 * Plug-ins are responsible to cast it.
	 * 
	 * @return Object
	 */
	ResultType getResult();

	/**
	 * 
	 * @return true if this item is currently visible or not (for exanple in an UI)
	 */
	default boolean isVisible() {

		return true;
	}
}
