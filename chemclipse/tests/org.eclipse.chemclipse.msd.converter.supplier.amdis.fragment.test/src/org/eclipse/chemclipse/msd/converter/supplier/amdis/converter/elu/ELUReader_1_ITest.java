/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.amdis.converter.elu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.chemclipse.converter.exceptions.FileIsEmptyException;
import org.eclipse.chemclipse.converter.exceptions.FileIsNotReadableException;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.TestPathHelper;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.io.ELUReader;

import junit.framework.TestCase;

public class ELUReader_1_ITest extends TestCase {

	private ELUReader reader;
	private File file;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		reader = new ELUReader();
		String pathname = TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_PEAKS_1_ELU);
		file = new File(pathname);
	}

	@Override
	protected void tearDown() throws Exception {

		reader = null;
		super.tearDown();
	}

	public void testRead_1() {

		try {
			reader.read(file, new NullProgressMonitor());
		} catch(FileNotFoundException e) {
			assertTrue(false);
		} catch(FileIsNotReadableException e) {
			assertTrue(false);
		} catch(FileIsEmptyException e) {
			assertTrue(false);
		} catch(IOException e) {
			assertTrue(false);
		}
	}
}
