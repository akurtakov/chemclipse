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

public class SampleDTO {

	private String sampleName = "";
	private String sampleDetails = "";
	private String groupName = "";
	private String classification = "";
	private String description = "";
	private boolean selected = true;
	private boolean predicted = false;
	private String rgb = "255,0,0";
	private List<PeakSampleDataDTO> sampleData = new ArrayList<>();

	public String getSampleName() {

		return sampleName;
	}

	public void setSampleName(String sampleName) {

		this.sampleName = sampleName;
	}

	public String getSampleDetails() {

		return sampleDetails;
	}

	public void setSampleDetails(String sampleDetails) {

		this.sampleDetails = sampleDetails;
	}

	public String getGroupName() {

		return groupName;
	}

	public void setGroupName(String groupName) {

		this.groupName = groupName;
	}

	public String getClassification() {

		return classification;
	}

	public void setClassification(String classification) {

		this.classification = classification;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public boolean isSelected() {

		return selected;
	}

	public void setSelected(boolean selected) {

		this.selected = selected;
	}

	public boolean isPredicted() {

		return predicted;
	}

	public void setPredicted(boolean predicted) {

		this.predicted = predicted;
	}

	public String getRgb() {

		return rgb;
	}

	public void setRgb(String rgb) {

		this.rgb = rgb;
	}

	public List<PeakSampleDataDTO> getSampleData() {

		return sampleData;
	}

	public void setSampleData(List<PeakSampleDataDTO> sampleData) {

		this.sampleData = sampleData;
	}
}
