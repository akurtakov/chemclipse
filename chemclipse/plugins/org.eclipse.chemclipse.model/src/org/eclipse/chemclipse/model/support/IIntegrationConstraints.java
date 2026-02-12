/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.support;

import java.io.Serializable;

public interface IIntegrationConstraints extends Serializable {

	/**
	 * Add an integration constraint to the list.
	 * 
	 * @param integrationConstraint
	 */
	void add(IntegrationConstraint integrationConstraint);

	/**
	 * Removes the given integration constraint from the list.
	 * 
	 * @param integrationConstraint
	 */
	void remove(IntegrationConstraint integrationConstraint);

	/**
	 * Removes all stored integration constraints from the list.
	 */
	void removeAll();

	/**
	 * Checks if the given integration constraint is stored.
	 * 
	 * @param integrationConstraint
	 * @return boolean
	 */
	boolean hasIntegrationConstraint(IntegrationConstraint integrationConstraint);
}
