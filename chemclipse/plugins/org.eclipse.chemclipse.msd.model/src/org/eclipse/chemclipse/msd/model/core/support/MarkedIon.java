/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.core.support;

import org.eclipse.chemclipse.model.core.AbstractMarkedTrace;
import org.eclipse.chemclipse.msd.model.core.AbstractIon;

public class MarkedIon extends AbstractMarkedTrace implements IMarkedIon {

	public MarkedIon(double trace, int magnification) {

		super(trace, magnification);
	}

	public MarkedIon(double trace) {

		super(trace);
	}

	@Override
	public int castTrace() {

		return AbstractIon.getIon(getTrace());
	}
}