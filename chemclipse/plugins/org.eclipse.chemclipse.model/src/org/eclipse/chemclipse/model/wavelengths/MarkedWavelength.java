/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.wavelengths;

import org.eclipse.chemclipse.model.core.AbstractMarkedTrace;

public class MarkedWavelength extends AbstractMarkedTrace implements IMarkedWavelength {

	public MarkedWavelength(double trace, int magnification) {

		super(trace, magnification);
	}

	public MarkedWavelength(double trace) {

		super(trace);
	}

	@Override
	public int castTrace() {

		return (int)Math.round(getTrace());
	}
}
