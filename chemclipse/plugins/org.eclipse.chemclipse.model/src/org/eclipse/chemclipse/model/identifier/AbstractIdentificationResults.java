/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.identifier;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractIdentificationResults implements IIdentificationResults {

	private List<IIdentificationResult> results;

	public AbstractIdentificationResults() {

		results = new ArrayList<IIdentificationResult>();
	}

	@Override
	public void add(IIdentificationResult result) {

		results.add(result);
	}

	@Override
	public void remove(IIdentificationResult result) {

		results.remove(result);
	}

	@Override
	public void removeAll() {

		results.clear();
	}

	@Override
	public IIdentificationResult getIdentificationResult(int index) {

		IIdentificationResult result = null;
		/*
		 * If the list is empty.
		 */
		if(results.isEmpty()) {
			return result;
		}
		if(index >= 0 && index < results.size()) {
			result = results.get(index);
		}
		return result;
	}

	@Override
	public List<IIdentificationResult> getIdentificationResults() {

		return results;
	}
}
