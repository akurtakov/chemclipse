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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.pcr.model.core.IPlate;
import org.eclipse.core.runtime.IProgressMonitor;

public class PCRWriter {

	private static final Logger logger = Logger.getLogger(PCRWriter.class);

	public void write(IPlate plate, File file, IProgressMonitor monitor) throws IOException {

		File internalTemporaryFile = new File("rdml_data.xml");
		PCRWriterVersion13 pcrWriter = new PCRWriterVersion13();
		pcrWriter.writePlate(internalTemporaryFile, plate, monitor);
		monitor.subTask("Compress the RDML");
		try (ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
			zipOutputStream.setLevel(9);
			zipOutputStream.setMethod(ZipOutputStream.DEFLATED);
			ZipEntry zipEntry = new ZipEntry(internalTemporaryFile.getName());
			try (FileInputStream fileInputStream = new FileInputStream(internalTemporaryFile)) {
				zipOutputStream.putNextEntry(zipEntry);
				for(int data = fileInputStream.read(); data != -1; data = fileInputStream.read()) {
					zipOutputStream.write(data);
				}
			}
			zipOutputStream.flush();
		}
		if(!internalTemporaryFile.delete()) {
			logger.warn("Failed to delete temporary file " + internalTemporaryFile);
		}
	}
}
