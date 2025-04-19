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

public interface IRetentionIndexLibraryService {

	String getName();

	String getDescription();

	String getVersion();

	List<ILibraryInformation> getLibraryInformation(int retentionIndex, RetentionIndexLibrarySettings settings, IProgressMonitor monitor);
}