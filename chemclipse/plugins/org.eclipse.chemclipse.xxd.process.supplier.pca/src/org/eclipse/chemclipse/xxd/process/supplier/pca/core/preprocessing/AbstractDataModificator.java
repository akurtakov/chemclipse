/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
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
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.ISampleData;
import org.eclipse.chemclipse.model.statistics.ISamples;
import org.eclipse.chemclipse.model.statistics.IVariable;

public abstract class AbstractDataModificator extends AbstractPreprocessing implements IDataModificator {

	protected double getData(ISampleData<?> sampleData) {

		return sampleData.getModifiedData();
	}

	protected <V extends IVariable, S extends ISample> boolean useVariable(ISamples<V, S> samples, int row) {

		return samples.getVariables().get(row).isSelected() && samples.containsValidData(row);
	}
}