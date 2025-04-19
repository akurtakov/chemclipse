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
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.core.preprocessing;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.ISamples;
import org.eclipse.chemclipse.model.statistics.IVariable;

public abstract class AbstractPreprocessing implements IPreprocessing {

	private boolean onlySelected;

	protected AbstractPreprocessing() {

		this.onlySelected = true;
	}

	@Override
	public boolean isOnlySelected() {

		return onlySelected;
	}

	@Override
	public void setOnlySelected(boolean onlySelected) {

		this.onlySelected = onlySelected;
	}

	protected <V extends IVariable, S extends ISample> List<S> selectSamples(ISamples<V, S> samples) {

		return samples.getSamples().stream().filter(s -> s.isSelected() || !onlySelected).collect(Collectors.toList());
	}
}
