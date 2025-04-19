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
package org.eclipse.chemclipse.msd.identifier.supplier.nist.runtime;

import java.io.File;
import java.io.FileNotFoundException;

import org.eclipse.chemclipse.msd.identifier.supplier.nist.TestPathHelper;

public class MacWineSupport_DRIVE_2_ITest extends AbstractBackgroundTestCase {

	private IExtendedRuntimeSupport runtimeSupport;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testConstruct_1() {

		String nistApp = TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_WINE_DRIVE_NIST_APPLICATION);
		try {
			runtimeSupport = new MacWineSupport(new File(nistApp).getParentFile(), parameterBackground);
			assertNotNull(runtimeSupport);
		} catch(FileNotFoundException e) {
			assertTrue("A file not found exception should not occur here.", false);
		}
	}

	public void testConstruct_2() {

		String nistApp = "";
		try {
			runtimeSupport = new MacWineSupport(new File(nistApp).getParentFile(), parameterBackground);
			assertNull(runtimeSupport);
		} catch(FileNotFoundException e) {
			assertTrue("A file not found exception should not occur here.", true);
		}
	}
}
