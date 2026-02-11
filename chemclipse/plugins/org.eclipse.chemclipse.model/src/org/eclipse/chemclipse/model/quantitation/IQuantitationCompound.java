/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.quantitation;

import java.io.Serializable;
import java.util.List;

public interface IQuantitationCompound extends Serializable, Comparable<IQuantitationCompound> {

	String getName();

	void setName(String name);

	String getChemicalClass();

	void setChemicalClass(String chemicalClass);

	String getConcentrationUnit();

	void setConcentrationUnit(String concentrationUnit);

	/**
	 * Allowed +/- retention time.
	 */
	IRetentionTimeWindow getRetentionTimeWindow();

	/**
	 * Allowed +/- retention index.
	 */
	IRetentionIndexWindow getRetentionIndexWindow();

	boolean isUseTIC();

	void setUseTIC(boolean useTIC);

	/**
	 * Returns the quantitation signals.
	 */
	IQuantitationSignals getQuantitationSignals();

	/**
	 * Returns the concentration / response entries.
	 */
	IResponseSignals getResponseSignals();

	/**
	 * Linear, ...
	 */
	CalibrationMethod getCalibrationMethod();

	/**
	 * Sets the calibration method.
	 */
	void setCalibrationMethod(CalibrationMethod calibrationMethod);

	/**
	 * Cross zero when calculate the equation.
	 */
	boolean isCrossZero();

	/**
	 * Set use zero crossing.
	 */
	void setUseCrossZero(boolean useCrossZero);

	List<IQuantitationPeak> getQuantitationPeaks();

	/**
	 * IQuantitationSignals and IConcentrationResponseEntries
	 * are automatically calculated using the stored QuantitationPeaks.
	 * TIC or XIC values are calculated depending on the compound setting (isUseTIC).
	 * 
	 */
	void calculateSignalTablesFromPeaks();

	/**
	 * Sets the default TIC quantitation signal.
	 * All other quantitation signals will be removed.
	 */
	void setQuantitationSignalTIC();
}
