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
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.processing.filter;

/**
 * Object can implement this interface to promote that they are filtered
 * 
 * @author Christoph Läubrich
 *
 * @param <FilteredType>
 */
public interface Filtered<FilteredType, ConfigType> {

	/**
	 * 
	 * @return the context that was responsible for filtering this object
	 */
	FilterContext<FilteredType, ConfigType> getFilterContext();
}
