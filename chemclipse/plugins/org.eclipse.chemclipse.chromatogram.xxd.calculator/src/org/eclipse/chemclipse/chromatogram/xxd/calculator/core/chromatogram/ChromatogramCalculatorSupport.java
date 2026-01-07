/*******************************************************************************
 * Copyright (c) 2016, 2026 Lablicate GmbH.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.exceptions.NoChromatogramCalculatorSupplierAvailableException;

public class ChromatogramCalculatorSupport implements IChromatogramCalculatorSupport {

	private List<IChromatogramCalculatorSupplier> suppliers;

	/**
	 * Creates a new suppliers list.
	 */
	public ChromatogramCalculatorSupport() {

		suppliers = new ArrayList<>();
	}

	/**
	 * Adds a {@link IChromatogramCalculatorSupplier} to the {@link IChromatogramCalculatorSupport}.
	 * 
	 * @param supplier
	 */
	protected void add(IChromatogramCalculatorSupplier supplier) {

		suppliers.add(supplier);
	}

	@Override
	public List<String> getAvailableCalculatorIds() throws NoChromatogramCalculatorSupplierAvailableException {

		/*
		 * Test if the suppliers ArrayList is empty.
		 */
		areChromatogramCalculatorsStored();
		List<String> availableFilters = new ArrayList<>();
		for(IChromatogramCalculatorSupplier supplier : suppliers) {
			availableFilters.add(supplier.getId());
		}
		return availableFilters;
	}

	@Override
	public String getCalculatorId(int index) throws NoChromatogramCalculatorSupplierAvailableException {

		/*
		 * Test if the suppliers ArrayList is empty.
		 */
		areChromatogramCalculatorsStored();
		/*
		 * Test if the index is out of range.
		 */
		if(index < 0 || index > suppliers.size() - 1) {
			throw new NoChromatogramCalculatorSupplierAvailableException("There is no chromatogram calculator available with the following id: " + index + ".");
		}
		IChromatogramCalculatorSupplier supplier = suppliers.get(index);
		return supplier.getId();
	}

	@Override
	public String[] getCalculatorNames() throws NoChromatogramCalculatorSupplierAvailableException {

		/*
		 * Test if the suppliers ArrayList is empty.
		 */
		areChromatogramCalculatorsStored();
		/*
		 * If the ArrayList is not empty, return the registered chromatogram
		 * converter filter names.<br/>
		 */
		ArrayList<String> filterNames = new ArrayList<>();
		for(IChromatogramCalculatorSupplier supplier : suppliers) {
			filterNames.add(supplier.getCalculatorName());
		}
		return filterNames.toArray(new String[filterNames.size()]);
	}

	@Override
	public IChromatogramCalculatorSupplier getCalculatorSupplier(String calculatorId) throws NoChromatogramCalculatorSupplierAvailableException {

		IChromatogramCalculatorSupplier filterSupplier = null;
		/*
		 * Test if the suppliers ArrayList is empty.
		 */
		areChromatogramCalculatorsStored();
		if(calculatorId == null || calculatorId.equals("")) {
			throw new NoChromatogramCalculatorSupplierAvailableException("There is no chromatogram calculator supplier available with the following id: " + calculatorId + ".");
		}
		endsearch:
		for(IChromatogramCalculatorSupplier supplier : suppliers) {
			if(supplier.getId().equals(calculatorId)) {
				filterSupplier = supplier;
				break endsearch;
			}
		}
		if(filterSupplier == null) {
			throw new NoChromatogramCalculatorSupplierAvailableException("There is no chromatogram calculator supplier available with the following id: " + calculatorId + ".");
		} else {
			return filterSupplier;
		}
	}

	// -------------------------------------private methods
	private void areChromatogramCalculatorsStored() throws NoChromatogramCalculatorSupplierAvailableException {

		if(suppliers.isEmpty()) {
			throw new NoChromatogramCalculatorSupplierAvailableException();
		}
	}
	// -------------------------------------private methods
}
