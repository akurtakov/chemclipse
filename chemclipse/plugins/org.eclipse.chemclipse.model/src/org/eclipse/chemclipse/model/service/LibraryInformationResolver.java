/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.Activator;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.model.services.ILibraryInformationResolverService;
import org.eclipse.chemclipse.model.services.LibraryInformationResolverSettings;
import org.eclipse.chemclipse.model.services.ResolverOption;
import org.eclipse.core.runtime.NullProgressMonitor;

public class LibraryInformationResolver {

	/**
	 * Tries to retrieve the IUPAC name/names for the given synonym.
	 * 
	 * @param searchTerm
	 * @return List
	 */
	public static List<ILibraryInformation> retrieveBySynonym(String searchTerm) {

		List<ILibraryInformation> libraryInformations = new ArrayList<>();
		//
		LibraryInformationResolverSettings settings = new LibraryInformationResolverSettings();
		settings.setResolverOption(ResolverOption.SYNONYM);
		settings.setSearchExact(true);
		settings.setCaseSensitive(false);
		//
		for(ILibraryInformationResolverService service : Activator.getDefault().getLibraryInformationResolverServices()) {
			libraryInformations.addAll(service.retrieve(settings, searchTerm, new NullProgressMonitor()));
		}
		//
		return libraryInformations;
	}
}