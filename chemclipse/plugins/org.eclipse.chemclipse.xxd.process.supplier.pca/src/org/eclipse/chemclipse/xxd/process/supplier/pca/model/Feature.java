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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.statistics.ISampleData;
import org.eclipse.chemclipse.model.statistics.IVariable;

public class Feature {

	private IVariable variable = null;
	private List<ISampleData<?>> sampleData = new ArrayList<>();

	public Feature(IVariable variable) {

		this.variable = variable;
	}

	public IVariable getVariable() {

		return variable;
	}

	public List<ISampleData<?>> getSampleData() {

		return sampleData;
	}
}