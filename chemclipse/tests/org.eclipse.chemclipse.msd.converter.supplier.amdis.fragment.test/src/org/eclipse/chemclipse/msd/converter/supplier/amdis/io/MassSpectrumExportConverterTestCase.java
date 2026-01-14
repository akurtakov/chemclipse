/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Alexander Kerner - Generics
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.amdis.io;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.msd.converter.database.IDatabaseExportConverter;
import org.eclipse.chemclipse.msd.converter.database.IDatabaseImportConverter;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.converter.msl.MSLDatabaseExportConverter;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.converter.msl.MSLDatabaseImportConverter;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;

/**
 * Imports a msl file.
 */
@Disabled
public class MassSpectrumExportConverterTestCase {

	protected File exportFile;
	protected IDatabaseExportConverter exportConverter;
	protected File importFile;
	protected IMassSpectra massSpectra;
	protected IDatabaseImportConverter importConverter;

	@BeforeAll
	public void setUp() throws IOException {

		exportConverter = new MSLDatabaseExportConverter();
		importConverter = new MSLDatabaseImportConverter();
	}

	@AfterAll
	public void tearDown() {

		if(exportFile.exists()) {
			exportFile.delete();
		}
	}
}
