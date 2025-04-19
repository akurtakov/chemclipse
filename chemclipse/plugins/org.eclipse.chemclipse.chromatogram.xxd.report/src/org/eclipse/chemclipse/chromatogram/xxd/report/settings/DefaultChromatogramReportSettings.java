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
 * Philip Wenig - refactor menu categories
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.report.settings;

import org.eclipse.chemclipse.chromatogram.xxd.report.preferences.PreferenceSupplier;

public class DefaultChromatogramReportSettings extends AbstractChromatogramReportSettings {

	@Override
	protected String getDefaultFolder() {

		return PreferenceSupplier.getReportExportFolder();
	}
}