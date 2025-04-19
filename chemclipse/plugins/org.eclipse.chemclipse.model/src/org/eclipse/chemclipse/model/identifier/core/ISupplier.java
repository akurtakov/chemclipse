/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.model.identifier.IIdentifierSettings;
import org.eclipse.chemclipse.support.literature.LiteratureReference;

public interface ISupplier {

	/**
	 * The id of the extension point: e.g.
	 * (org.eclipse.chemclipse.chromatogram.msd.identifier.supplier.fsearch)
	 * 
	 * @return String
	 */
	String getId();

	/**
	 * A short description of the functionality of the extension point.
	 * 
	 * @return String
	 */
	String getDescription();

	/**
	 * The identifier name that will be shown in the FileDialog.
	 * 
	 * @return String
	 */
	String getIdentifierName();

	/**
	 * TODO: either returns a bean-like class or with annotations ..., with a public default constructor, ... or returns <code>null</code> if no filter settings are associated
	 * 
	 * @return
	 */
	Class<? extends IIdentifierSettings> getSettingsClass();

	List<LiteratureReference> getLiteratureReferences();
}
