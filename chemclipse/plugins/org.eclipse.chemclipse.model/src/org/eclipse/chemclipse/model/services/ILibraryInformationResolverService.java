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
package org.eclipse.chemclipse.model.services;

import java.util.List;

import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * https://en.wikipedia.org/wiki/Chemical_nomenclature
 */
public interface ILibraryInformationResolverService {

	String getName();

	String getDescription();

	String getVersion();

	/**
	 * Returns a list of IUPAC names if matched, based on the
	 * options and values. Could return an empty list.
	 * 
	 * @param settings
	 * @param searchTerm
	 * @param monitor
	 * @return {@link List}
	 */
	List<ILibraryInformation> retrieve(LibraryInformationResolverSettings settings, String searchTerm, IProgressMonitor monitor);
}