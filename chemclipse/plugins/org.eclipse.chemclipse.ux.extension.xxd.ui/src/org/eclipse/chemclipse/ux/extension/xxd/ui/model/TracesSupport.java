/*******************************************************************************
 * Copyright (c) 2022, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.model;

import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.support.ScanSupport;
import org.eclipse.chemclipse.ux.extension.xxd.ui.Activator;
import org.eclipse.chemclipse.ux.extension.xxd.ui.l10n.ExtensionMessages;
import org.eclipse.chemclipse.ux.extension.xxd.ui.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.vsd.model.core.IScanVSD;
import org.eclipse.chemclipse.vsd.model.support.WavenumberSupport;
import org.eclipse.chemclipse.wsd.model.core.IScanWSD;
import org.eclipse.chemclipse.wsd.model.core.support.WavelengthSupport;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;

public class TracesSupport {

	private static final IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();

	public static TracesExportOption getTracesExportOption() {

		try {
			return TracesExportOption.valueOf(preferenceStore.getString(PreferenceSupplier.P_TRACES_EXPORT_OPTION));
		} catch(Exception e) {
			return TracesExportOption.SIMPLE_TEXT;
		}
	}

	public static void setTracesExportOption(TracesExportOption tracesExportOption) {

		preferenceStore.setValue(PreferenceSupplier.P_TRACES_EXPORT_OPTION, tracesExportOption.name());
	}

	public static String getTraces(IScan scan, int maxCopyTraces) {

		String traces;
		boolean sortTraces = isSortTraces();

		if(scan instanceof IScanMSD scanMSD) {
			traces = ScanSupport.extractTracesText(scanMSD, maxCopyTraces, sortTraces);
		} else if(scan instanceof IScanWSD scanWSD) {
			traces = WavelengthSupport.extractTracesText(scanWSD, maxCopyTraces, sortTraces);
		} else if(scan instanceof IScanVSD scanVSD) {
			traces = WavenumberSupport.extractTracesText(scanVSD, maxCopyTraces, sortTraces);
		} else {
			traces = "";
		}

		return traces;
	}

	public static void copyTracesToClipboard(Display display, TracesExportOption tracesExportOption, IScan scan, int maxCopyTraces) {

		String traces = getTraces(scan, maxCopyTraces);
		if(!traces.isEmpty()) {
			switch(tracesExportOption) {
				case NAMED_TRACE:
					/*
					 * Styrene | 104 103 ...
					 */
					IScan scanInstance = getScanInstance(scan);
					ILibraryInformation libraryInformation = IIdentificationTarget.getLibraryInformation(scanInstance);
					if(libraryInformation != null) {
						traces = libraryInformation.getName() + " | " + traces;
					} else {
						traces = ExtensionMessages.unknown + " | " + traces;
					}
					break;
				default:
					/*
					 * 104 103 ...
					 */
					break;
			}
			/*
			 * Clipboard
			 */
			TextTransfer textTransfer = TextTransfer.getInstance();
			Object[] data = new Object[]{traces};
			Transfer[] dataTypes = new Transfer[]{textTransfer};
			Clipboard clipboard = new Clipboard(display);
			clipboard.setContents(data, dataTypes);
			clipboard.dispose();
		}
	}

	private static IScan getScanInstance(Object scan) {

		IScan scanInstance = null;

		if(scan instanceof IScanMSD scanMSD) {
			scanInstance = scanMSD;
		} else if(scan instanceof IScanWSD scanWSD) {
			scanInstance = scanWSD;
		} else if(scan instanceof IScanVSD scanVSD) {
			scanInstance = scanVSD;
		}

		return scanInstance;
	}

	private static boolean isSortTraces() {

		return preferenceStore.getBoolean(PreferenceSupplier.P_SORT_COPY_TRACES);
	}
}