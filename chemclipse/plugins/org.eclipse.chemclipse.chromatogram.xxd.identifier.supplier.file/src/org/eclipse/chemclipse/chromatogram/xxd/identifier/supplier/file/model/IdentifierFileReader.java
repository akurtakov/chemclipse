/*******************************************************************************
 * Copyright (c) 2016, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.columns.ISeparationColumn;
import org.eclipse.chemclipse.model.columns.SeparationColumnFactory;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.format.MSL;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.format.MSP;
import org.eclipse.chemclipse.support.model.SeparationColumnType;

public class IdentifierFileReader {

	private static final Logger logger = Logger.getLogger(IdentifierFileReader.class);

	public ISeparationColumn parse(File file) {

		/*
		 * Extract the separation column if the library contains the info, e.g. in a *.msl or *.msp file.
		 * Otherwise, create a default column.
		 */
		ISeparationColumn separationColumn = SeparationColumnFactory.getSeparationColumn(SeparationColumnType.DEFAULT);
		if(isSeparationColumnFile(file)) {
			separationColumn = extractSeparationColumn(file);
		}

		return separationColumn;
	}

	private ISeparationColumn extractSeparationColumn(File file) {

		/*
		 * Restrict to *.msl and *.msp files at the moment.
		 * Otherwise use default.
		 */
		ISeparationColumn separationColumn = SeparationColumnFactory.getSeparationColumn(SeparationColumnType.DEFAULT);

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			/*
			 * Column Specification
			 */
			String name = SeparationColumnType.DEFAULT.name();
			String length = "";
			String diameter = "";
			String phase = "";

			String line;
			while((line = bufferedReader.readLine()) != null) {
				if(line.startsWith(IColumnFormat.COLUMN_MARKER)) {
					/*
					 * Column data
					 * #COLUMN_NAME=DB5
					 * ...
					 */
					if(line.startsWith(IColumnFormat.COLUMN_NAME)) {
						name = getValue(line);
					} else if(line.startsWith(IColumnFormat.COLUMN_LENGTH)) {
						length = getValue(line);
					} else if(line.startsWith(IColumnFormat.COLUMN_DIAMETER)) {
						diameter = getValue(line);
					} else if(line.startsWith(IColumnFormat.COLUMN_PHASE)) {
						phase = getValue(line);
					}
				}
			}
			/*
			 * Create the column.
			 */
			separationColumn = SeparationColumnFactory.getSeparationColumn(name, length, diameter, phase);
		} catch(IOException e) {
			logger.error(e);
		}

		return separationColumn;
	}

	private boolean isSeparationColumnFile(File file) {

		boolean isSeparationColumnFile = false;
		if(file != null && file.exists()) {
			String name = file.getName().toLowerCase();
			if(name.endsWith(MSL.FILE_EXTENSION.toLowerCase()) || name.endsWith(MSP.FILE_EXTENSION.toLowerCase())) {
				isSeparationColumnFile = true;
			}
		}

		return isSeparationColumnFile;
	}

	private String getValue(String line) {

		String value = "";
		String[] values = line.split(IColumnFormat.HEADER_VALUE_DELIMITER);
		if(values.length == 2) {
			value = values[1].trim();
		}
		return value;
	}
}