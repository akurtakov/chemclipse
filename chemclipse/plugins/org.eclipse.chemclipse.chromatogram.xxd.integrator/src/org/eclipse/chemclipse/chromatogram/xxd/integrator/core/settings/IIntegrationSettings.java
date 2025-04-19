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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings;

import org.eclipse.chemclipse.model.settings.IProcessSettings;

public interface IIntegrationSettings extends IProcessSettings {

	/**
	 * Returns the {@link IBaselineSupport} instance.
	 * 
	 * @return {@link IBaselineSupport}
	 */
	IBaselineSupport getBaselineSupport();
}
