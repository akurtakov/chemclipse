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
 * Jan Holy - initial API and implementation
 * Philip Wenig - get rid of system settings
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.processing.supplier.base.settings;

import java.io.Serializable;

import org.eclipse.chemclipse.nmr.processing.supplier.base.settings.support.DigitalFilterTreatmentOptions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DigitalFilterRemovalSettings implements Serializable {

	private static final long serialVersionUID = 7271244127560614155L;
	//
	@JsonProperty("Group delay of digital filter")
	private int leftRotationFid = 0;
	@JsonProperty("Weighting factor for first fid point")
	private double dcOffsetMultiplicationFactor = Double.NaN;
	@JsonProperty("Filter treatment options")
	private DigitalFilterTreatmentOptions treatmentOptions = DigitalFilterTreatmentOptions.SUBSTITUTE_WITH_NOISE;

	public int getLeftRotationFid() {

		return leftRotationFid;
	}

	public void setLeftRotationFid(int leftRotationFid) {

		this.leftRotationFid = leftRotationFid;
	}

	public double getDcOffsetMultiplicationFactor() {

		return dcOffsetMultiplicationFactor;
	}

	public void setDcOffsetMultiplicationFactor(double dcOffsetMultiplicationFactor) {

		this.dcOffsetMultiplicationFactor = dcOffsetMultiplicationFactor;
	}

	public DigitalFilterTreatmentOptions getTreatmentOptions() {

		return treatmentOptions;
	}

	public void setTreatmentOptions(DigitalFilterTreatmentOptions treatmentOptions) {

		this.treatmentOptions = treatmentOptions;
	}

	@Override
	public String toString() {

		return "DigitalFilterRemovalSettings [leftRotationFid=" + leftRotationFid + ", dcOffsetMultiplicationFactor=" + dcOffsetMultiplicationFactor + ", treatmentOptions=" + treatmentOptions + "]";
	}

}