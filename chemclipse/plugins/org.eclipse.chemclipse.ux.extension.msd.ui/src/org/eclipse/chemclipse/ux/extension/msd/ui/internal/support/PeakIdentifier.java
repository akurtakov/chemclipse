/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.msd.ui.internal.support;

import java.io.File;
import java.util.List;

import org.eclipse.chemclipse.msd.converter.peak.PeakConverterMSD;
import org.eclipse.chemclipse.processing.converter.ISupplier;

public class PeakIdentifier {

	private static List<ISupplier> suppliers;

	public static boolean isPeak(File file) {

		String extension = file.toString().toLowerCase();
		/*
		 * All directories are stored in upper cases.
		 */
		if(file.isDirectory()) {
			return false;
		}
		//
		if(suppliers == null) {
			suppliers = PeakConverterMSD.getPeakConverterSupport().getSupplier();
		}
		//
		if(suppliers != null && !suppliers.isEmpty()) {
			for(ISupplier supplier : suppliers) {
				String supplierExtension = supplier.getFileExtension().toLowerCase();
				if(!supplierExtension.isEmpty() && extension.endsWith(supplierExtension)) {
					if(supplier.isImportable()) {
						return true;
					}
				}
			}
		}
		//
		return false;
	}

	public static boolean isPeakDirectory(File file) {

		String directory = file.toString().toUpperCase();
		/*
		 * All directories are stored in upper cases.
		 */
		if(!file.isDirectory()) {
			return false;
		}
		//
		if(suppliers == null) {
			suppliers = PeakConverterMSD.getPeakConverterSupport().getSupplier();
		}
		//
		if(suppliers != null && !suppliers.isEmpty()) {
			for(ISupplier supplier : suppliers) {
				String directoryExtension = supplier.getDirectoryExtension().toUpperCase();
				if(!directoryExtension.isEmpty() && directory.endsWith(directoryExtension)) {
					if(supplier.isImportable()) {
						return true;
					}
				}
			}
		}
		return false;
	}
}