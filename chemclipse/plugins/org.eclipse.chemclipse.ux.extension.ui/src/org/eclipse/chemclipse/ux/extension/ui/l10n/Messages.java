/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 * Philip Wenig - more translations
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.l10n;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.chemclipse.ux.extension.ui.l10n.messages"; //$NON-NLS-1$ //

	public static String drives;
	public static String home;
	public static String openAllContainedMeasurements;
	public static String openAs;
	public static String openSelectedMeasurements;
	public static String scanForFilesystemUpdates;
	public static String selectDirectory;
	public static String selectUserLocation;
	public static String storingPreferencesFailed;
	public static String tryToOpenAllSelectedFiles;
	public static String userLocation;
	public static String workspace;
	public static String setAsMethodDirectory;
	public static String setAsActiveMethod;
	public static String literatureReferences;
	public static String literatureReference;
	public static String noLinkIsSupplierYet;
	public static String openInExternalBrowser;
	public static String chooseLocation;
	public static String processorOffersNoOptions;
	public static String rememberDecision;
	public static String resetDefaults;
	public static String settings;
	public static String collapseAllProcessorItems;
	public static String displaySettings;
	public static String yes;
	public static String no;
	public static String editProcessorOptions;
	public static String editStoredDataForSelectedProcessor;
	public static String expandAllProcessorItems;
	public static String managePreferences;
	public static String manageProcessorOptions;
	public static String options;
	public static String systemDefault;
	public static String processorOptionsBelowSelectToManageRemoveState;
	public static String removeStoredDataResetDefaultsForSelectedProcessor;
	public static String removeAllStoredDataResetDefaults;
	public static String resetSettingsForAllProcessors;
	public static String resetSettingsForSelectedProcessors;
	public static String selectOptionsForProcessorName;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {

	}
}
