/*******************************************************************************
 * Copyright (c) 2010, 2026 Lablicate GmbH.
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

import java.util.List;

public interface IIdentificationResults {

	/**
	 * Adds a {@link IIdentificationResult} to the results.
	 */
	void add(IIdentificationResult result);

	/**
	 * Removes a {@link IIdentificationResult} from the results.
	 */
	void remove(IIdentificationResult result);

	/**
	 * Removes all {@link IIdentificationResult} entries.
	 */
	void removeAll();

	/**
	 * Returns the IIdentificationResult instance with the given index.<br/>
	 * If no object is available or the index is out of range, null will be
	 * returned. The index is 0 based.
	 */
	IIdentificationResult getIdentificationResult(int index);

	/**
	 * Returns a list of all stored elements.
	 */
	List<IIdentificationResult> getIdentificationResults();
}
