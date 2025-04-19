/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Lorenz Gerber - additional Constructor
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

import org.eclipse.chemclipse.model.statistics.AbstractSample;

public class Sample extends AbstractSample<PeakSampleData> {

	public Sample(String sampleName, String groupName) {

		this(sampleName, groupName, "", "");
	}

	public Sample(String sampleName, String groupName, String description) {

		this(sampleName, groupName, "", description);
	}

	public Sample(String sampleName, String groupName, String classification, String description) {

		super(sampleName);
		setGroupName(groupName);
		setClassification(classification);
		setDescription(description);
	}

	public Sample(String sampleName, String sampleDetails, String groupName, String classification, String description) {

		super(sampleName);
		setSampleDetails(sampleDetails);
		setGroupName(groupName);
		setClassification(classification);
		setDescription(description);
	}
}