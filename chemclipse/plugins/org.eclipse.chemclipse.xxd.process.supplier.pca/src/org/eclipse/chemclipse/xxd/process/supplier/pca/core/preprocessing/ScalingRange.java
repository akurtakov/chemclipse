/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Jan Holy - initial API and implementation
 * Philip Wenig - refactoring
 * Lorenz Gerber - fix algo, improve description
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing;

import java.util.List;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.ISampleData;
import org.eclipse.chemclipse.model.statistics.ISamples;
import org.eclipse.chemclipse.model.statistics.IVariable;

public class ScalingRange extends AbstractScaling {

	public ScalingRange(int centeringType) {

		super(centeringType);
	}

	@Override
	public String getDescription() {

		return "In Range scaling, the feature is re-scaled to a specific range [0,1], no centering";
	}

	@Override
	public String getName() {

		return "Range scaling";
	}

	private <S extends ISample> double getMax(List<S> samples, int index) {

		boolean onlySelected = isOnlySelected();
		return samples.stream().filter(s -> s.isSelected() || !onlySelected).map(s -> s.getSampleData().get(index)).mapToDouble(value -> getData(value)).summaryStatistics().getMax();
	}

	private <S extends ISample> double getMin(List<S> samples, int index) {

		boolean onlySelected = isOnlySelected();
		return samples.stream().filter(s -> s.isSelected() || !onlySelected).map(s -> s.getSampleData().get(index)).mapToDouble(value -> getData(value)).summaryStatistics().getMin();
	}

	@Override
	public <V extends IVariable, S extends ISample> void process(ISamples<V, S> samples) {

		boolean onlySelected = isOnlySelected();
		List<V> variables = samples.getVariables();
		List<S> samplesList = samples.getSamples();
		for(int i = 0; i < variables.size(); i++) {
			if(useVariable(samples, i)) {
				double max = getMax(samplesList, i);
				double min = getMin(samplesList, i);
				for(ISample sample : samplesList) {
					ISampleData<?> sampleData = sample.getSampleData().get(i);
					if((sample.isSelected() || !onlySelected)) {
						double data = getData(sampleData);
						double scaleData = (data - min) / (max - min);
						sampleData.setModifiedData(scaleData);
					}
				}
			}
		}
	}
}