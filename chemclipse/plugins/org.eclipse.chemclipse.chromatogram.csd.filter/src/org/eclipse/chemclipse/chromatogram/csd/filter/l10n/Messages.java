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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.csd.filter.l10n;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.chemclipse.chromatogram.csd.filter.l10n.messages"; //$NON-NLS-1$

	public static String invalidChromatogram;
	public static String invalidChromatogramSelection;
	public static String invalidFilterSettings;
	public static String invalidPeak;
	public static String invalidPeakList;
	public static String noChromatogramFilterAvailable;
	public static String noPeakFilterAvailable;
	public static String onlyCSDchromatogramSupported;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {

	}
}
