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

import java.util.ArrayList;
import java.util.List;

public class FeatureDataMatrixDTO {

	private List<String> sampleNames = new ArrayList<>();
	private List<String> groupNames = new ArrayList<>();
	private List<FeatureDTO> features = new ArrayList<>();

	public List<String> getSampleNames() {

		return sampleNames;
	}

	public void setSampleNames(List<String> sampleNames) {

		this.sampleNames = sampleNames;
	}

	public List<String> getGroupNames() {

		return groupNames;
	}

	public void setGroupNames(List<String> groupNames) {

		this.groupNames = groupNames;
	}

	public List<FeatureDTO> getFeatures() {

		return features;
	}

	public void setFeatures(List<FeatureDTO> features) {

		this.features = features;
	}
}
