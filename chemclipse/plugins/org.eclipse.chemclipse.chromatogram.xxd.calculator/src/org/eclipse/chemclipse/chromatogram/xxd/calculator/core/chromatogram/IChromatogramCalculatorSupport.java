/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.core.chromatogram;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.exceptions.NoChromatogramCalculatorSupplierAvailableException;

public interface IChromatogramCalculatorSupport {

	/**
	 * Returns the id of the selected filter name.<br/>
	 * The id of the selected filter is used to determine which filter should be
	 * used to calculate the integration results of the chromatogram.<br/>
	 * Be aware of that the first index is 0. It is a 0-based index.
	 * 
	 * @param index
	 * @return String
	 * @throws NoChromatogramCalculatorSupplierAvailableException
	 */
	String getCalculatorId(int index) throws NoChromatogramCalculatorSupplierAvailableException;

	/**
	 * Returns an IChromatogramFilterSupplier object.<br/>
	 * The object stores some additional supplier information.
	 * 
	 * @param calculatorId
	 * @return {@link IChromatogramCalculatorSupplier}
	 * @throws NoChromatogramCalculatorSupplierAvailableException
	 */
	IChromatogramCalculatorSupplier getCalculatorSupplier(String calculatorId) throws NoChromatogramCalculatorSupplierAvailableException;

	/**
	 * Returns an ArrayList with all available chromatogram calculator supplier ids.<br/>
	 * 
	 * @return List<String>
	 * @throws NoChromatogramCalculatorSupplierAvailableException
	 */
	List<String> getAvailableCalculatorIds() throws NoChromatogramCalculatorSupplierAvailableException;

	/**
	 * Returns the list of available chromatogram calculator names.
	 * 
	 * @return String[]
	 * @throws NoChromatogramCalculatorSupplierAvailableException
	 */
	String[] getCalculatorNames() throws NoChromatogramCalculatorSupplierAvailableException;
}
