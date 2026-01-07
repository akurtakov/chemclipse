/*******************************************************************************
 * Copyright (c) 2016, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Dr. Lorenz Gerber - initial API and implementation
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.classifier.supplier.molpeak.model;

import java.util.HashMap;
import java.util.Map;

public class LigninRatios implements ILigninRatios {

	private Map<String, Double> results = new HashMap<>();

	@Override
	public Map<String, Double> getResults() {

		return results;
	}
}
