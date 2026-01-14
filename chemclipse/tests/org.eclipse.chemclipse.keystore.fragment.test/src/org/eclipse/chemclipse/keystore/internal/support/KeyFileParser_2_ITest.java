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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.eclipse.chemclipse.converter.PathResolver;
import org.eclipse.chemclipse.keystore.TestPathHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.osgi.framework.FrameworkUtil;

@TestInstance(Lifecycle.PER_CLASS)
public class KeyFileParser_2_ITest {

	private Map<String, String> keyStore;

	@BeforeAll
	public void setUp() throws IOException {

		File file = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.TESTFILE_KEYSTORE_II_TEST);
		keyStore = KeyFileParser.readKeysFromFile(file);
	}

	@Test
	public void testAmount() {

		assertEquals(2, keyStore.size());
	}

	@Test
	public void testContainsKey_1() {

		assertFalse(keyStore.containsKey("mykeyid.test"));
	}

	@Test
	public void testContainsKey_2() {

		assertFalse(keyStore.containsKey("mykeyid.hello"));
	}

	@Test
	public void testContainsKey_3() {

		assertTrue(keyStore.containsKey("mykeyid.converter"));
	}

	@Test
	public void testContainsKey_4() {

		assertTrue(keyStore.containsKey("mykeyid.converter.text"));
	}

	@Test
	public void testGetKey_1() {

		assertNull(keyStore.get("mykeyid.test"));
	}

	@Test
	public void testGetKey_2() {

		assertNull(keyStore.get("mykeyid.hello"));
	}

	@Test
	public void testGetKey_3() {

		assertEquals("Hhdjss-237Rhs-378", keyStore.get("mykeyid.converter"));
	}

	@Test
	public void testGetKey_4() {

		assertEquals("Hs893jss-237Rhs-xxx", keyStore.get("mykeyid.converter.text"));
	}
}
