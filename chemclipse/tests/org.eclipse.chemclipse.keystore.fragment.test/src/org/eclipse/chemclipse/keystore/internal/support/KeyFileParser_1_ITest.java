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
package org.eclipse.chemclipse.keystore.internal.support;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.eclipse.chemclipse.keystore.TestPathHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class KeyFileParser_1_ITest {

	private Map<String, String> keyStore;

	@BeforeAll
	public void setUp() throws IOException {

		File file = new File(TestPathHelper.TESTFILE_KEYSTORE_I_TEST);
		keyStore = KeyFileParser.readKeysFromFile(file);
	}

	@Test
	public void testAmount() {

		assertEquals(0, keyStore.size());
	}

	@Test
	public void testContainsKey_1() {

		assertFalse(keyStore.containsKey("mykeyid"));
	}

	@Test
	public void testGetKey_1() {

		assertNull(keyStore.get("mykeyid"));
	}
}
