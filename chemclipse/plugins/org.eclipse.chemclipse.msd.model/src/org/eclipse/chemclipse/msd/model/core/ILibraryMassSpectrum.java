/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.core;

import org.eclipse.chemclipse.model.identifier.ILibraryInformation;

public interface ILibraryMassSpectrum {

	/**
	 * Returns the library information.<br/>
	 * This contains e.g. CAS number, name, etc.
	 * 
	 * @return {@link ILibraryInformation}
	 */
	ILibraryInformation getLibraryInformation();

	/**
	 * Sets a valid library information instance to the current library mass
	 * spectrum.<br/>
	 * LibraryInformation must not be null.
	 * 
	 * @param libraryInformation
	 */
	void setLibraryInformation(ILibraryInformation libraryInformation);
}
