/*******************************************************************************
 * Copyright (c) 2013, 2026 Lablicate GmbH.
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

public interface IQuantitationEntry extends Serializable {

	/**
	 * Legacy method - Better use:
	 * {@link #getSignals()}.
	 */
	double getSignal();

	/**
	 * Legacy method - Better use:
	 * {@link #setSignals(List)}
	 */
	void setSignal(double signal);

	List<Double> getSignals();

	void setSignals(List<Double> signals);

	String getName();

	String getGroup();

	String getChemicalClass();

	void setChemicalClass(String chemicalClass);

	double getConcentration();

	String getConcentrationUnit();

	double getArea();

	String getCalibrationMethod();

	void setCalibrationMethod(String calibrationMethod);

	boolean getUsedCrossZero();

	void setUsedCrossZero(boolean usedCrossZero);

	String getDescription();

	void setDescription(String description);

	void appendDescription(String description);

	QuantitationFlag getQuantitationFlag();

	void setQuantitationFlag(QuantitationFlag quantitationFlag);
}