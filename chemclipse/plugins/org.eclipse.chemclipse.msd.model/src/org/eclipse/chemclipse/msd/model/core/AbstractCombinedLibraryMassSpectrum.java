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
import org.eclipse.chemclipse.model.identifier.LibraryInformation;

public abstract class AbstractCombinedLibraryMassSpectrum extends AbstractCombinedMassSpectrum implements ICombinedLibraryMassSpectrum {

	/**
	 * Renew the serialVersionUID any time you have changed some fields or
	 * methods.
	 */
	private static final long serialVersionUID = -3114256142707811855L;
	private ILibraryInformation libraryInformation;

	protected AbstractCombinedLibraryMassSpectrum() {

		libraryInformation = new LibraryInformation();
	}

	// -----------------------------------------------ILibraryMassSpectrum
	/*
	 * Why is get/set LibraryInformation implemented twice? Here and in {@link
	 * AbstractRegularLibraryMassSpectrum}?<br/> Java does not support multiple
	 * inheritance like in c++.
	 */
	@Override
	public ILibraryInformation getLibraryInformation() {

		return libraryInformation;
	}

	@Override
	public void setLibraryInformation(ILibraryInformation libraryInformation) {

		if(libraryInformation != null) {
			this.libraryInformation = libraryInformation;
		}
	}
	// -----------------------------------------------ILibraryMassSpectrum
}
