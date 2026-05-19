/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.io;

/**
 * All preprocessing strategy fields are stored as class simple names. The
 * {@code scalingCenteringType} is only meaningful for AbstractScaling
 * subclasses (ICentering.MEAN=1, ICentering.MEDIAN=2).
 */
public class PreprocessingSettingsDTO {

	private String replacerType = "SmallValuesReplacer";
	private String transformationType = null;
	private String normalizationType = "Normalization1Norm";
	private String centeringType = "ScalingAuto";
	private int scalingCenteringType = 1;

	public String getReplacerType() {

		return replacerType;
	}

	public void setReplacerType(String replacerType) {

		this.replacerType = replacerType;
	}

	public String getTransformationType() {

		return transformationType;
	}

	public void setTransformationType(String transformationType) {

		this.transformationType = transformationType;
	}

	public String getNormalizationType() {

		return normalizationType;
	}

	public void setNormalizationType(String normalizationType) {

		this.normalizationType = normalizationType;
	}

	public String getCenteringType() {

		return centeringType;
	}

	public void setCenteringType(String centeringType) {

		this.centeringType = centeringType;
	}

	public int getScalingCenteringType() {

		return scalingCenteringType;
	}

	public void setScalingCenteringType(int scalingCenteringType) {

		this.scalingCenteringType = scalingCenteringType;
	}
}
