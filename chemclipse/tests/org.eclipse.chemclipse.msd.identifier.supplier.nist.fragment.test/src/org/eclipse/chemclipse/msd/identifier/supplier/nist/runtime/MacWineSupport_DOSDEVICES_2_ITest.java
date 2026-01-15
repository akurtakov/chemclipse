/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.chemclipse.converter.PathResolver;
import org.eclipse.chemclipse.msd.identifier.supplier.nist.TestPathHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.osgi.framework.FrameworkUtil;

public class MacWineSupport_DOSDEVICES_2_ITest extends AbstractBackgroundTestCase {

	private IExtendedRuntimeSupport runtimeSupport;

	@Override
	@BeforeAll
	public void setUp() throws IOException {

		super.setUp();
	}

	@Test
	public void testConstruct_1() throws IOException {

		File nistApp = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.TESTFILE_WINE_DOSDEVICES_NIST_APPLICATION);
		runtimeSupport = new MacWineSupport(nistApp.getParentFile(), parameterBackground);
		assertNotNull(runtimeSupport);
	}

	@Test
	public void testConstruct_2() {

		String nistApp = "";
		assertThrows(FileNotFoundException.class, () -> {
			runtimeSupport = new MacWineSupport(new File(nistApp).getParentFile(), parameterBackground);
		});
	}
}
