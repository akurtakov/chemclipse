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
package org.eclipse.chemclipse.model.statistics;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSamples<V extends IVariable, S extends ISample> implements ISamples<V, S> {

	private List<S> samples;
	private List<V> variables;

	public AbstractSamples() {

		samples = new ArrayList<>();
		variables = new ArrayList<>();
	}

	@Override
	public List<S> getSamples() {

		return samples;
	}

	@Override
	public List<V> getVariables() {

		return variables;
	}
}