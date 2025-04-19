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
package org.eclipse.chemclipse.converter.ui.l10n;

import org.eclipse.osgi.util.NLS;

public class ConverterMessagesUI extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.chemclipse.converter.ui.l10n.messages"; //$NON-NLS-1$
	//
	public static String spectrum;
	public static String saveSpectrumAs;
	public static String spectrumConverter;
	public static String converterDoesNotExist;
	public static String overwrite;
	public static String overwriteFile;
	//
	static {
		NLS.initializeMessages(BUNDLE_NAME, ConverterMessagesUI.class);
	}

	private ConverterMessagesUI() {

	}
}