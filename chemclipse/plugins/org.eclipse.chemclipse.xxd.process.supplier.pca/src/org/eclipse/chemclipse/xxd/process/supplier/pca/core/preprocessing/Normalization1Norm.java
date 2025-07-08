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
 * Lorenz Gerber - improve description
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing;

import java.util.List;
import java.util.stream.IntStream;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.ISampleData;
import org.eclipse.chemclipse.model.statistics.ISamples;
import org.eclipse.chemclipse.model.statistics.IVariable;

public class Normalization1Norm extends AbstractDataModificator implements INormalization {

	public Normalization1Norm() {

		super();
	}

	@Override
	public String getDescription() {

		return "Vector 1-norm is the sum of absolute values";
	}

	@Override
	public String getName() {

		return "Sample Normalization 1-Norm";
	}

	@Override
	public <V extends IVariable, S extends ISample> void process(ISamples<V, S> samples) {

		for(ISample sample : samples.getSamples()) {
			if(sample.isSelected() || !isOnlySelected()) {
				List<? extends ISampleData<?>> sampleData = sample.getSampleData();
				double sum = IntStream.range(0, sampleData.size()).filter(i -> !sampleData.get(i).isEmpty()).filter(i -> useVariable(samples, i))//
						.mapToDouble(i -> Math.abs(getData(sampleData.get(i)))).sum();
				IntStream.range(0, sampleData.size()).filter(i -> !sampleData.get(i).isEmpty()).filter(i -> useVariable(samples, i))//
						.forEach(i -> sampleData.get(i).setModifiedData(getData(sampleData.get(i)) / sum));
			}
		}
	}
}