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
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

import org.eclipse.chemclipse.xxd.process.supplier.pca.core.IExtractionData;
import org.eclipse.core.runtime.IProgressMonitor;

public class ExtractionDataFilter implements IExtractionData {

	private Samples samples;

	public ExtractionDataFilter(Samples samples) {

		this.samples = samples;
	}

	@Override
	public Samples process(IProgressMonitor monitor) {

		return samples;
	}

}
