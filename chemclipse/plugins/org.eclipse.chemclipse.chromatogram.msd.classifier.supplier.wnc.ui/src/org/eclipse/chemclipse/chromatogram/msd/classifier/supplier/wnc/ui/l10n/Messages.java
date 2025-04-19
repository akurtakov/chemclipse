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
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.l10n;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.l10n.messages"; //$NON-NLS-1$
	//
	public static String addIonToAnalyze;
	public static String ion;
	public static String ionValueMustBeInteger;
	public static String name;
	public static String nameMustBeSpecified;
	public static String nameWithoutDisallowedCharacters;
	public static String nv;
	public static String percentageMaxIntensity;
	public static String percentageSumIntensity;
	public static String wncClassifierSettings;
	public static String targetTrace;
	//
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {

	}
}