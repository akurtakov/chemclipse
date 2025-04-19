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

import java.util.Collection;

public interface IIdentificationResult {

	/**
	 * Adds a {@link IIdentificationTarget} to the results.
	 * 
	 * @param entry
	 */
	void add(IIdentificationTarget entry);

	/**
	 * Removes a {@link IIdentificationTarget} from the results.
	 * 
	 * @param entry
	 */
	void remove(IIdentificationTarget entry);

	/**
	 * Removes all {@link IIdentificationTarget} entries.
	 */
	void removeAll();

	/**
	 * Returns the best {@link IIdentificationTarget} from the list.
	 * 
	 * @return
	 */
	IIdentificationTarget getBestHit();

	Collection<IIdentificationTarget> getIdentificationEntries();
}
