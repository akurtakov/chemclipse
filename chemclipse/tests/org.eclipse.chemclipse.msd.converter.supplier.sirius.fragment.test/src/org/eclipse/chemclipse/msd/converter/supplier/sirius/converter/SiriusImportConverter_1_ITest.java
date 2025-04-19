/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.sirius.converter;

import java.io.File;

import org.eclipse.chemclipse.msd.converter.supplier.sirius.TestPathHelper;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;

import junit.framework.TestCase;

public class SiriusImportConverter_1_ITest extends TestCase {

	private SiriusImportConverter converter;
	private File file;
	private IMassSpectra massSpectra;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		file = new File(TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_BICUCULLINE));
		converter = new SiriusImportConverter();
		IProcessingInfo<IMassSpectra> processingInfo = converter.convert(file, new NullProgressMonitor());
		massSpectra = processingInfo.getProcessingResult();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testSize() {

		assertEquals(1, massSpectra.size());
	}
}
