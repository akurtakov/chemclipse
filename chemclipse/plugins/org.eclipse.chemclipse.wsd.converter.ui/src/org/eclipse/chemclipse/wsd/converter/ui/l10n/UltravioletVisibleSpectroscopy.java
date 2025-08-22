/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.wsd.converter.ui.l10n;

import org.eclipse.osgi.util.NLS;

public class UltravioletVisibleSpectroscopy extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.chemclipse.wsd.converter.ui.l10n.messages"; //$NON-NLS-1$

	public static String saveUVVis;

	static {
		NLS.initializeMessages(BUNDLE_NAME, UltravioletVisibleSpectroscopy.class);
	}

	private UltravioletVisibleSpectroscopy() {

	}
}