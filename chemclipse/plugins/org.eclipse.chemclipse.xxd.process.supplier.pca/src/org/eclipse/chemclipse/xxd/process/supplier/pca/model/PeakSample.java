/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

import org.eclipse.chemclipse.model.statistics.AbstractSample;

public class PeakSample extends AbstractSample<PeakSampleData> {

	public PeakSample(IDataInputEntry dataInputEntry) {

		this(dataInputEntry.getSampleName(), dataInputEntry.getGroupName());
	}

	public PeakSample(String sampleName, String groupName) {

		super(sampleName);
		setGroupName(groupName);
	}
}