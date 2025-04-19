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
package org.eclipse.chemclipse.chromatogram.xxd.identifier.chromatogram;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.identifier.settings.IChromatogramIdentifierSettings;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.support.literature.LiteratureReference;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IChromatogramIdentifier {

	/**
	 * Identifies a chromatogram.<br/>
	 * Several plugins can use the extension point mechanism to support a
	 * identifier (e.g. F-Search, DB-Tools, ...).
	 * 
	 * @param chromatogramSelection
	 * @param identifierSettings
	 * @param monitor
	 * @return {@link IProcessingInfo}
	 */
	IProcessingInfo<?> identify(IChromatogramSelection chromatogramSelection, IChromatogramIdentifierSettings identifierSettings, IProgressMonitor monitor);

	/**
	 * The same as the other method but without settings.
	 * 
	 * @param chromatogramSelection
	 * @param monitor
	 * @return {@link IProcessingInfo}
	 */
	IProcessingInfo<?> identify(IChromatogramSelection chromatogramSelection, IProgressMonitor monitor);

	List<LiteratureReference> getLiteratureReferences();
}
