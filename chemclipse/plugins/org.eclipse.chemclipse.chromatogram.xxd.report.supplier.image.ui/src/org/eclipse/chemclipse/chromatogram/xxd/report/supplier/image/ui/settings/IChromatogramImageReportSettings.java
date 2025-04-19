/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.report.supplier.image.ui.settings;

import org.eclipse.chemclipse.chromatogram.xxd.report.settings.IChromatogramReportSettings;

public interface IChromatogramImageReportSettings extends IChromatogramReportSettings {

	int getWidth();

	int getHeight();

	boolean isPeaks();

	boolean isScans();

	ImageFormat getFormat();
}
