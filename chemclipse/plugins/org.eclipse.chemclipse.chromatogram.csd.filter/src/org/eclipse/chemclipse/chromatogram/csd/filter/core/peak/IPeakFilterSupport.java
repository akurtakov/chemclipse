/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.csd.filter.core.peak;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.csd.filter.exceptions.NoPeakFilterSupplierAvailableException;

public interface IPeakFilterSupport {

	/**
	 * Returns the id of the selected filter name.<br/>
	 * The id of the selected filter is used to determine which filter should be used.
	 * Be aware of that the first index is 0. It is a 0-based index.
	 * 
	 * @param index
	 * @return String
	 * @throws NoPeakFilterSupplierAvailableException
	 */
	String getFilterId(int index) throws NoPeakFilterSupplierAvailableException;

	/**
	 * Returns an IPeakFilterSupplier object.<br/>
	 * The object stores some additional supplier information.
	 * 
	 * @param filterId
	 * @return {@link IPeakFilterSupplier}
	 * @throws NoPeakFilterSupplierAvailableException
	 */
	IPeakFilterSupplier getFilterSupplier(String filterId) throws NoPeakFilterSupplierAvailableException;

	/**
	 * Returns an ArrayList with all available peak filter supplier ids.<br/>
	 * 
	 * @return List<String>
	 * @throws NoPeakFilterSupplierAvailableException
	 */
	List<String> getAvailableFilterIds() throws NoPeakFilterSupplierAvailableException;

	/**
	 * Returns the list of available peak filter names.
	 * 
	 * @return String[]
	 * @throws NoPeakFilterSupplierAvailableException
	 */
	String[] getFilterNames() throws NoPeakFilterSupplierAvailableException;
}
