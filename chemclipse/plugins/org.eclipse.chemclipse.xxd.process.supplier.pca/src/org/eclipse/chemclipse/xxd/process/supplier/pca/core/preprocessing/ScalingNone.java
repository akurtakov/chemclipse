/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing;

import java.util.List;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.ISampleData;
import org.eclipse.chemclipse.model.statistics.ISamples;
import org.eclipse.chemclipse.model.statistics.IVariable;

public class ScalingNone extends AbstractScaling {

	public ScalingNone(int centeringType) {

		super(centeringType);
	}

	@Override
	public String getDescription() {

		return "--";
	}

	@Override
	public String getName() {

		return "--";
	}

	@Override
	public <V extends IVariable, S extends ISample> void process(ISamples<V, S> samples) {

		boolean onlySelected = isOnlySelected();
		int centeringType = getCenteringType();
		List<V> variables = samples.getVariables();
		List<S> samplesList = samples.getSamples();
		for(int i = 0; i < variables.size(); i++) {
			if(useVariable(samples, i)) {
				double mean = getCenteringValue(samplesList, i, centeringType);
				for(ISample sample : samplesList) {
					ISampleData<?> sampleData = sample.getSampleData().get(i);
					if((sample.isSelected() || !onlySelected)) {
						double data = getData(sampleData);
						double centerData = 0;
						centerData = (data - mean);
						if(Double.isInfinite(centerData)) {
							centerData = Double.NaN;
						}
						sampleData.setModifiedData(centerData);
					}
				}
			}
		}
	}
}
