/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.help;

public class HelpContext {

	HelpContext() {

		// static only
	}

	public static final String PREFIX = "org.eclipse.chemclipse.ux.extension.xxd.ui."; //$NON-NLS-1$

	public static final String CHROMATOGRAM_EDITOR = PREFIX + "chromatogram_editor"; //$NON-NLS-1$
	public static final String CHROMATOGRAM_OVERLAY = PREFIX + "chromatogram_overlay"; //$NON-NLS-1$
	public static final String PEAK_SCAN_LIST = PREFIX + "peak_scan_list"; //$NON-NLS-1$
	public static final String TARGETS = PREFIX + "targets"; //$NON-NLS-1$
}
