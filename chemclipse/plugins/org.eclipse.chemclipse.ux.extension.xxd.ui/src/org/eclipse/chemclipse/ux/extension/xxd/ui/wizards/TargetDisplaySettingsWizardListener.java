/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - refactoring target label support
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.wizards;

import org.eclipse.chemclipse.model.targets.ITargetDisplaySettings;

public interface TargetDisplaySettingsWizardListener {

	String getLabelID();

	/**
	 * Set the preview settings
	 * 
	 * @param targetDisplaySettings
	 *            the settings to use for preview or <code>null</code> if no preview is desired
	 * @param viewerFilters
	 */
	void setPreviewSettings(ITargetDisplaySettings targetDisplaySettings);

	boolean isShowPreview();

	void setShowPreview(boolean preview);
}
