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
package org.eclipse.chemclipse.msd.converter.supplier.excel.io;

import java.io.File;

import org.eclipse.chemclipse.msd.converter.supplier.excel.PathResolver;
import org.eclipse.chemclipse.msd.converter.supplier.excel.TestPathHelper;
import org.eclipse.core.runtime.NullProgressMonitor;

public class ChromatogramExport_1_ITest extends ChromatogramReaderTestCase {

	private ChromatogramWriter chromatogramWriter;

	@Override
	protected void setUp() throws Exception {

		pathImport = PathResolver.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_CHROMATOGRAM_1);
		chromatogramWriter = new ChromatogramWriter();
		super.setUp();
	}

	public void testExport_1() {

		try {
			new File(TestPathHelper.DIRECTORY_EXPORT_TEST).mkdirs();
			File file = new File(PathResolver.getAbsolutePath(TestPathHelper.DIRECTORY_EXPORT_TEST) + File.separator + "Test.xlsx");
			chromatogramWriter.writeChromatogram(file, chromatogram, new NullProgressMonitor());
			assertTrue(file.length() > 0);
			file.delete();
		} catch(Exception e) {
			assertTrue("Exception", false);
		}
	}
}
