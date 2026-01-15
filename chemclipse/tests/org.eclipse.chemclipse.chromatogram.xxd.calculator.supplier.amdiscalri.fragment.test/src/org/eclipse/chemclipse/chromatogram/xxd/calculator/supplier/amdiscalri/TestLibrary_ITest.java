/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.io.StandardsReader;
import org.eclipse.chemclipse.converter.PathResolver;
import org.junit.jupiter.api.Test;
import org.osgi.framework.FrameworkUtil;

public class TestLibrary_ITest {

	@Test
	public void test1() throws IOException {

		File file = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), StandardsReader.ALKANES);
		assertTrue(file.exists());
	}
}