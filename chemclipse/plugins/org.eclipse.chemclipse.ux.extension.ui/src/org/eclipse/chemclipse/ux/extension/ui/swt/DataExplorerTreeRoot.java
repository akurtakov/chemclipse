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
 * Philip Wenig - refactoring
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.swt;

import java.io.File;

import org.eclipse.chemclipse.support.settings.ApplicationSettings;
import org.eclipse.chemclipse.support.settings.UserManagement;
import org.eclipse.chemclipse.ux.extension.ui.l10n.ExtensionMessages;
import org.eclipse.chemclipse.ux.extension.ui.preferences.PreferenceSupplierDataExplorer;
import org.eclipse.core.resources.ResourcesPlugin;

/*
 * https://docs.oracle.com/javase/tutorial/essential/io/fileAttr.html
 */
public enum DataExplorerTreeRoot {

	NONE(""), // //$NON-NLS-1$
	DRIVES(ExtensionMessages.drives), //
	HOME(ExtensionMessages.home), //
	WORKSPACE(ExtensionMessages.workspace), //
	USER_LOCATION(ExtensionMessages.userLocation);

	private String label;

	private DataExplorerTreeRoot(String label) {

		this.label = label;
	}

	@Override
	public String toString() {

		return this != NONE ? label : super.toString();
	}

	public String getPreferenceKeyDefaultPath() {

		switch(this) {
			case DRIVES:
				return PreferenceSupplierDataExplorer.P_SELECTED_DRIVE_PATH;
			case HOME:
				return PreferenceSupplierDataExplorer.P_SELECTED_HOME_PATH;
			case WORKSPACE:
				return PreferenceSupplierDataExplorer.P_SELECTED_WORKSPACE_PATH;
			case USER_LOCATION:
				return PreferenceSupplierDataExplorer.P_SELECTED_USER_LOCATION_PATH;
			case NONE:
			default:
				return "selected" + name() + "Path"; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	public File[] getRootContent() {

		File[] roots;
		switch(this) {
			case DRIVES:
				roots = File.listRoots();
				break;
			case HOME:
				roots = new File[]{new File(UserManagement.getUserHome())};
				break;
			case WORKSPACE:
				File root = new File(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
				if(root.exists()) {
					roots = root.listFiles();
				} else {
					/*
					 * Fallback solution
					 */
					roots = ApplicationSettings.getWorkspaceDirectory().listFiles();
				}
				break;
			case USER_LOCATION:
				roots = new File[]{getUserLocation()};
				break;
			case NONE:
			default:
				roots = new File[]{};
				break;
		}

		return roots;
	}

	public static DataExplorerTreeRoot[] getDefaultRoots() {

		return new DataExplorerTreeRoot[]{DRIVES, HOME, WORKSPACE, USER_LOCATION};
	}

	private static File getUserLocation() {

		String userLocationPath = PreferenceSupplierDataExplorer.getUserLocationPath();
		File userLocation = new File(userLocationPath);
		if(!userLocation.exists()) {
			userLocation = new File(UserManagement.getUserHome());
		}
		return userLocation;
	}
}
