/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.converter.core;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.converter.TestPathHelper;

import junit.framework.TestCase;

public class MagicNumberMatcher_5_ITest extends TestCase {

	private static final byte[] MAGIC_CODE = new byte[]{(byte)0xF0, (byte)0xA7};

	private class MagicNumberMatcher extends AbstractMagicNumberMatcher implements IMagicNumberMatcher {

		@Override
		public boolean checkFileFormat(File file) {

			return checkMagicCode(file, MAGIC_CODE);
		}
	}

	private IMagicNumberMatcher magicNumberMatcher;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		magicNumberMatcher = new MagicNumberMatcher();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void test1() throws IOException {

		File file = new File(TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_BIN_TEST));
		assertTrue(magicNumberMatcher.checkFileFormat(file));
	}
}
