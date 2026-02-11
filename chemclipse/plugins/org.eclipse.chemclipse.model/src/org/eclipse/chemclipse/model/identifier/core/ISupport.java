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
package org.eclipse.chemclipse.model.identifier.core;

import java.util.List;

import org.eclipse.chemclipse.model.exceptions.NoIdentifierAvailableException;

public interface ISupport {

	/**
	 * Returns the filter names which are actually registered at the
	 * chromatogram converter extension point.<br/>
	 * The filter names are the specific chromatogram file names to be displayed
	 * for example in the SWT FileDialog. Agilent has for example an filter name
	 * "Agilent Chromatogram (.D)".
	 */
	String[] getIdentifierNames() throws NoIdentifierAvailableException;

	/**
	 * Returns the id of the selected identifier index.<br/>
	 * The id of the selected filter is used to determine which identifier
	 * should be used.<br/>
	 * Be aware of that the first index is 0. It is a 0-based index.
	 */
	String getIdentifierId(int index) throws NoIdentifierAvailableException;

	/**
	 * Returns an ArrayList with all available identifier ids.<br/>
	 */
	List<String> getAvailableIdentifierIds() throws NoIdentifierAvailableException;

	/**
	 * Returns an ISupplier object.<br/>
	 * The object stores some additional supplier information.
	 */
	ISupplier getIdentifierSupplier(String identifierId) throws NoIdentifierAvailableException;
}
