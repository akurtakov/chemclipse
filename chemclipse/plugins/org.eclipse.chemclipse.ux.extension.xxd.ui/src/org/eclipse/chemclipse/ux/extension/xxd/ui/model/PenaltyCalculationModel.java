/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.model;

import org.eclipse.chemclipse.model.identifier.PenaltyCalculation;

public class PenaltyCalculationModel {

	private PenaltyCalculation penaltyCalculation;
	private double referenceValue;
	private double penaltyWindow;
	private double penaltyLevelFactor;
	private double maxPenalty;

	public PenaltyCalculationModel(PenaltyCalculation penaltyCalculation, double referenceValue, double penaltyWindow, double penaltyLevelFactor, double maxPenalty) {

		this.penaltyCalculation = penaltyCalculation;
		this.referenceValue = referenceValue;
		this.penaltyWindow = penaltyWindow;
		this.penaltyLevelFactor = penaltyLevelFactor;
		this.maxPenalty = maxPenalty;
	}

	public PenaltyCalculation getPenaltyCalculation() {

		return penaltyCalculation;
	}

	public double getReferenceValue() {

		return referenceValue;
	}

	public double getPenaltyWindow() {

		return penaltyWindow;
	}

	public double getPenaltyLevelFactor() {

		return penaltyLevelFactor;
	}

	public double getMaxPenalty() {

		return maxPenalty;
	}
}