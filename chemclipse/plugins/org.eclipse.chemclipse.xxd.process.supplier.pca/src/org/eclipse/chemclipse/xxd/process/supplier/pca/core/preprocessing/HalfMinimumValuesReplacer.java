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
package org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing;

import java.util.List;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.ISampleData;
import org.eclipse.chemclipse.model.statistics.ISamples;
import org.eclipse.chemclipse.model.statistics.IVariable;

public class HalfMinimumValuesReplacer extends AbstractDataModificator implements IReplacer {

	@Override
	public String getDescription() {

		return "Replace NAN value with half of the minimum value of the current variable";
	}

	@Override
	public String getName() {

		return "Half Minimum Value Setter";
	}

	@Override
	public <V extends IVariable, S extends ISample> void process(ISamples<V, S> samples) {

		List<V> variables = samples.getVariables();
		List<S> sampleList = samples.getSamples();
		for(int i = 0; i < variables.size(); i++) {
			if(useVariable(samples, i)) {
				double minimum = Double.POSITIVE_INFINITY;
				for(S sample : sampleList) {
					if(sample.isSelected() || !isOnlySelected()) {
						ISampleData<?> sampleData = sample.getSampleData().get(i);
						double value = getData(sampleData);
						if(!Double.isNaN(value) && value < minimum) {
							minimum = value;
						}
					}
				}
				if(minimum != Double.POSITIVE_INFINITY) {
					double replacement = 0.5d * minimum;
					for(S sample : sampleList) {
						if(sample.isSelected() || !isOnlySelected()) {
							ISampleData<?> sampleData = sample.getSampleData().get(i);
							if(Double.isNaN(getData(sampleData))) {
								sampleData.setModifiedData(replacement);
							}
						}
					}
				}
			}
		}
	}
}