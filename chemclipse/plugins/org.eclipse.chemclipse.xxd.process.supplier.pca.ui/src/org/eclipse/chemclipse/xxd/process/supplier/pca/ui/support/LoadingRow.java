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
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.support;

public class LoadingRow {

	private final String variableName;
	private final double[] loadings;

	public LoadingRow(String variableName, double[] loadings) {

		this.variableName = variableName;
		this.loadings = loadings;
	}

	public String getVariableName() {

		return variableName;
	}

	public double[] getLoadings() {

		return loadings;
	}
}