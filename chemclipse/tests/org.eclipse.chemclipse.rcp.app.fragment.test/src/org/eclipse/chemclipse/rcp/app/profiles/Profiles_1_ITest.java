/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.rcp.app.profiles;

import java.io.File;
import java.io.FileNotFoundException;

import junit.framework.TestCase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;

import org.eclipse.chemclipse.rcp.app.TestPathHelper;

public class Profiles_1_ITest extends TestCase {

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void test1() {

		File file = new File(TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_EXPORT_DIR) + TestPathHelper.TESTFILE_EXPORT_NAME);
		try {
			Profiles.exportProfile(file);
			assertTrue(true);
			assertTrue(file.delete());
		} catch(FileNotFoundException e) {
			assertTrue(false);
		} catch(CoreException e) {
			assertTrue(false);
		} finally {
			/*
			 * Safety delete if something goes wrong.
			 */
			if(file != null) {
				file.delete();
			}
		}
	}

	public void test2() {

		File file = new File(TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_PREFS_1));
		try {
			IStatus status = Profiles.importProfile(file);
			assertEquals(IStatus.OK, status.getCode());
		} catch(FileNotFoundException e) {
			assertTrue(false);
		} catch(CoreException e) {
			System.out.println(e);
			assertTrue(false);
		}
	}
}
