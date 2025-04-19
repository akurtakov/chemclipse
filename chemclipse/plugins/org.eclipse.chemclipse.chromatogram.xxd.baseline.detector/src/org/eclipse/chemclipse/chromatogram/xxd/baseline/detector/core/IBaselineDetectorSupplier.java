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
package org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.core;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.settings.IBaselineDetectorSettings;
import org.eclipse.chemclipse.support.literature.LiteratureReference;

public interface IBaselineDetectorSupplier {

	/**
	 * The id of the extension point: e.g.
	 * (org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.supplier.chemstation)
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
	 * The baseline detector name that can be shown in a list box dialogue.
	 * 
	 * @return String
	 */
	String getDetectorName();

	/**
	 * TODO: either returns a bean-like class or with annotations ..., with a public default constructor, ... or returns <code>null</code> if no filter settings are associated
	 * 
	 * @return
	 */
	Class<? extends IBaselineDetectorSettings> getSettingsClass();

	List<LiteratureReference> getLiteratureReferences();
}
