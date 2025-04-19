/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.msd.converter.database.IDatabaseImportConverter;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.converter.msp.MSPDatabaseImportConverter;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Ignore;

import junit.framework.TestCase;

@Ignore
public class ImportConverterMspTestCase extends TestCase {

	protected File importFile;
	protected IMassSpectra massSpectra;
	protected IDatabaseImportConverter importConverter;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		importConverter = new MSPDatabaseImportConverter();
		IProcessingInfo<IMassSpectra> processingInfo = importConverter.convert(importFile, new NullProgressMonitor());
		massSpectra = processingInfo.getProcessingResult();
	}

	@Override
	protected void tearDown() throws Exception {

		importFile = null;
		massSpectra = null;
		importConverter = null;
		super.tearDown();
	}
}
