/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.identifier.supplier.nist.internal.helper;

import java.io.File;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.support.settings.ApplicationSettings;

public class PathHelper {

	private static final Logger logger = Logger.getLogger(PathHelper.class);
	public static final String NIST_IDENTIFIER = "org.eclipse.chemclipse.msd.identifier.supplier.nist";

	/**
	 * Returns the file object (directory) where the chromatogram instances can
	 * temporarily be stored.
	 * 
	 * @return File
	 */
	public static File getStoragePath() {

		File file = new File(ApplicationSettings.getSettingsDirectory().getAbsolutePath() + File.separator + NIST_IDENTIFIER);
		/*
		 * Create the directory if it not exists.
		 */
		if(!file.exists()) {
			if(!file.mkdirs()) {
				logger.warn("The temporarily nist identifier directory could not be created: " + file.getAbsolutePath());
			}
		}
		return file;
	}

	/**
	 * DO NOT CALL THIS METHOD IF YOU NOT REALLY KNOW WHAT YOU ARE DOING.<br/>
	 * Cleans all temporarily stored files in the storage directory.<br/>
	 * This method will be called on bundle start and stop.
	 */
	public static void cleanStoragePath() {

		File directory = getStoragePath();
		deleteFiles(directory);
	}

	/**
	 * Deletes the given directory recursively.
	 * 
	 * @param directory
	 */
	private static void deleteFiles(File directory) {

		/*
		 * Delete all files in all directories.
		 */
		for(File file : directory.listFiles()) {
			if(file.isDirectory()) {
				deleteFiles(file);
			} else {
				if(!file.delete()) {
					logger.warn("The file " + file + "could not be deleted.");
				}
			}
		}
		/*
		 * Delete the directory if all files have been removed.
		 */
		if(!directory.delete()) {
			logger.warn("The directory " + directory + "could not be deleted.");
		}
	}
}
