/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 * 
 * All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - move method to open wizard, refactor for new settings
 *******************************************************************************/
package org.eclipse.chemclipse.processing.system;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.logging.support.Settings;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplierContext;
import org.eclipse.chemclipse.processing.supplier.IProcessorPreferences;
import org.eclipse.chemclipse.processing.supplier.NodeProcessorPreferences;
import org.eclipse.chemclipse.support.settings.OperatingSystemUtils;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

public class ProcessSettingsSupport {

	private static final Logger logger = Logger.getLogger(ProcessSettingsSupport.class);
	//
	public static final String DESCRIPTION = "Preferences";
	public static final String FILE_EXTENSION = ".prefs";
	public static final String FILE_NAME = DESCRIPTION.replaceAll("\\s", "") + FILE_EXTENSION;
	public static final String FILTER_EXTENSION = "*" + FILE_EXTENSION;
	public static final String FILTER_NAME = DESCRIPTION + " (*" + FILE_EXTENSION + ")";
	//
	private static IEclipsePreferences preferences = null;

	/**
	 * Get the stored preferences as String.
	 * 
	 * @return {@link String}
	 */
	public static String getPreferences() {

		IEclipsePreferences eclipsePreferences = getEclipsePreferences();
		StringBuilder builder = new StringBuilder();
		/*
		 * .../.metadata/.plugins/org.eclipse.core.runtime/.settings/org.eclipse.chemclipse.processing.supplier.IProcessSupplier.prefs
		 */
		StringBuilder path = new StringBuilder();
		path.append(Settings.getWorkspaceDirectory().getAbsolutePath());
		path.append(File.separator);
		path.append(".metadata");
		path.append(File.separator);
		path.append(".plugins");
		path.append(File.separator);
		path.append("org.eclipse.core.runtime");
		path.append(File.separator);
		path.append(".settings");
		path.append(File.separator);
		path.append(eclipsePreferences.absolutePath().replace("/instance/", ""));
		path.append(FILE_EXTENSION);
		File file = new File(path.toString());
		if(file.exists()) {
			try {
				String delimiter = OperatingSystemUtils.getLineDelimiter();
				for(String line : Files.readAllLines(file.toPath())) {
					builder.append(line);
					builder.append(delimiter);
				}
			} catch(IOException e) {
				logger.warn(e);
			}
		}
		//
		return builder.toString();
	}

	public static <T> IProcessorPreferences<T> getWorkspacePreferences(IProcessSupplier<T> supplier) {

		return new NodeProcessorPreferences<>(supplier, getEclipsePreferences().node(supplier.getId()));
	}

	public static Collection<IProcessorPreferences<?>> getPreferences(IProcessSupplierContext context) {

		return getPreferences(context, false);
	}

	public static Collection<IProcessorPreferences<?>> getPreferences(IProcessSupplierContext context, boolean dynamicPreferencesOnly) {

		List<IProcessorPreferences<?>> processorPreferences = new ArrayList<>();
		try {
			IEclipsePreferences eclipsePreferences = getEclipsePreferences();
			String[] childrenNames = eclipsePreferences.childrenNames();
			for(String childrenName : childrenNames) {
				/*
				 * Preferences
				 * Skip empty nodes.
				 */
				Preferences preferences = eclipsePreferences.node(childrenName);
				if(preferences.keys().length == 0) {
					continue;
				}

				IProcessSupplier<?> processSupplier = context.getSupplier(childrenName);
				if(processSupplier != null) {
					if(!dynamicPreferencesOnly) {
						processorPreferences.add(new NodeProcessorPreferences<>(processSupplier, preferences));
					}
				} else {
					String id = preferences.name();
					processSupplier = new DynamicProcessSupplier(id, id, "This is a dynamic process method.");
					processorPreferences.add(new NodeProcessorPreferences<>(processSupplier, preferences));
				}
			}
		} catch(BackingStoreException e) {
		}

		return processorPreferences;
	}

	private static IEclipsePreferences getEclipsePreferences() {

		if(preferences == null) {
			preferences = InstanceScope.INSTANCE.getNode(IProcessSupplier.class.getName());
		}
		//
		return preferences;
	}
}