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
package org.eclipse.chemclipse.keystore.internal.support;

import java.io.File;
import java.util.Map;

import org.eclipse.chemclipse.keystore.TestPathHelper;

import junit.framework.TestCase;

public class KeyFileParser_1_ITest extends TestCase {

	private Map<String, String> keyStore;

	@Override
	protected void setUp() throws Exception {

		File file = new File(TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_KEYSTORE_I_TEST));
		keyStore = KeyFileParser.readKeysFromFile(file);
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testAmount() {

		assertEquals(0, keyStore.size());
	}

	public void testContainsKey_1() {

		assertFalse(keyStore.containsKey("mykeyid"));
	}

	public void testGetKey_1() {

		assertNull(keyStore.get("mykeyid"));
	}
}
