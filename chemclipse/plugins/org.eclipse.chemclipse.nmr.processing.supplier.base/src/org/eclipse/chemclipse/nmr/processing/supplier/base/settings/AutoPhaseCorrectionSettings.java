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
 * Alexander Stark - initial API and implementation
 * Philip Wenig - get rid of system settings
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.processing.supplier.base.settings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AutoPhaseCorrectionSettings {

	public static final double DEFAULT_PENALTY_FACTORY = 1E-9 / 5;
	public static final int DEFAULT_NUMBER_OF_OPTIMIZATION_CYCLES = 1;
	public static final int DEFAULT_OMIT_PERCENT_OF_SPECTRUM = 15;
	// user might provide better values
	@JsonProperty("Weighting penalty factor")
	private double penaltyFactor = DEFAULT_PENALTY_FACTORY;
	@JsonProperty("No. of optimization cycles")
	private int numberOfOptimizationCycles = DEFAULT_NUMBER_OF_OPTIMIZATION_CYCLES;
	@JsonProperty("Omit edge portions of spectrum [%]")
	private int omitPercentOfTheSpectrum = DEFAULT_OMIT_PERCENT_OF_SPECTRUM;

	@JsonProperty("Apply only 0th order correction")
	private boolean correctOnlyZerothPhase;
	@JsonProperty("0th order correction [�]")
	private double zerothOrderValue = 0.0d;
	@JsonProperty("1st order correction [�]")
	private double firstOrderValue = 0.0d;

	public double getZerothOrderValue() {

		return zerothOrderValue;
	}

	public void setZerothOrderValue(double zerothOrderValue) {

		this.zerothOrderValue = zerothOrderValue;
	}

	public double getFirstOrderValue() {

		return firstOrderValue;
	}

	public void setFirstOrderValue(double firstOrderValue) {

		this.firstOrderValue = firstOrderValue;
	}

	public double getPenaltyFactor() {

		return penaltyFactor;
	}

	public void setPenaltyFactor(double penaltyFactor) {

		this.penaltyFactor = penaltyFactor;
	}

	public boolean isCorrectOnlyZerothPhase() {

		return correctOnlyZerothPhase;
	}

	public void setCorrectOnlyZerothPhase(boolean correctOnlyZerothPhase) {

		this.correctOnlyZerothPhase = correctOnlyZerothPhase;
	}

	public int getNumberOfOptimizationCycles() {

		return numberOfOptimizationCycles;
	}

	public void setNumberOfOptimizationCycles(int numberOfOptimizationCycles) {

		this.numberOfOptimizationCycles = numberOfOptimizationCycles;
	}

	public int getOmitPercentOfTheSpectrum() {

		return omitPercentOfTheSpectrum;
	}

	public void setOmitPercentOfTheSpectrum(int omitPercentOfTheSpectrum) {

		this.omitPercentOfTheSpectrum = omitPercentOfTheSpectrum;
	}

	@Override
	public String toString() {

		return "AutoPhaseCorrectionSettings [penaltyFactor=" + penaltyFactor + ", numberOfOptimizationCycles=" + numberOfOptimizationCycles + ", omitPercentOfTheSpectrum=" + omitPercentOfTheSpectrum + ", correctOnlyZerothPhase=" + correctOnlyZerothPhase + ", zerothOrderValue=" + zerothOrderValue + ", firstOrderValue=" + firstOrderValue + "]";
	}

}