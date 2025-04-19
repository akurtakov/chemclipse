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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.model;

import org.eclipse.chemclipse.ux.extension.ui.swt.DataExplorerTreeRoot;
import org.eclipse.jface.preference.IPreferenceStore;

public class DataExplorerTreeSettings {

	private IPreferenceStore preferenceStore = null;
	private DataExplorerTreeRoot[] dataExplorerTreeRoots = null;

	public DataExplorerTreeSettings(IPreferenceStore preferenceStore) {

		this(preferenceStore, DataExplorerTreeRoot.getDefaultRoots());
	}

	public DataExplorerTreeSettings(IPreferenceStore preferenceStore, DataExplorerTreeRoot[] dataExplorerTreeRoots) {

		this.preferenceStore = preferenceStore;
		this.dataExplorerTreeRoots = dataExplorerTreeRoots;
	}

	public IPreferenceStore getPreferenceStore() {

		return preferenceStore;
	}

	public DataExplorerTreeRoot[] getDataExplorerTreeRoots() {

		return dataExplorerTreeRoots;
	}
}