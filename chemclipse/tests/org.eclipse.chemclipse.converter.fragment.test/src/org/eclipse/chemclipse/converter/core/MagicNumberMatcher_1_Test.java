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

import junit.framework.TestCase;

public class MagicNumberMatcher_1_Test extends TestCase {

	private class MagicNumberMatcher extends AbstractMagicNumberMatcher implements IMagicNumberMatcher {

		@Override
		public boolean checkFileFormat(File file) {

			return checkFileExtension(file, ".txt");
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

	public void test1() {

		File file = new File("HelloWorld.txt");
		assertTrue(magicNumberMatcher.checkFileFormat(file));
	}

	public void test2() {

		File file = new File("HelloWorld.TXT");
		assertTrue(magicNumberMatcher.checkFileFormat(file));
	}

	public void test3() {

		File file = new File("HelloWorld.png");
		assertFalse(magicNumberMatcher.checkFileFormat(file));
	}

	public void test4() {

		File file = new File("HelloWorld.PNG");
		assertFalse(magicNumberMatcher.checkFileFormat(file));
	}
}
