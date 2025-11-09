/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.support;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Tests the class IonRange concerning equals, hashCode and toString.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class ScanRange_3_Test {

	private IScanRange scanRange1;
	private IScanRange scanRange2;

	@BeforeAll
	public void setUp() {

		scanRange1 = new ScanRange(3, 5);
		scanRange2 = new ScanRange(1, 5);
	}

	@Test
	public void testEquals_1() {

		assertFalse(scanRange1.equals(scanRange2));
	}

	@Test
	public void testEquals_2() {

		assertFalse(scanRange2.equals(scanRange1));
	}

	@Test
	public void testHashCode_1() {

		assertFalse(scanRange1.hashCode() == scanRange2.hashCode());
	}

	@Test
	public void testHashCode_2() {

		assertFalse(scanRange2.hashCode() == scanRange1.hashCode());
	}

	@Test
	public void testToString_1() {

		assertFalse(scanRange1.toString().equals(scanRange2.toString()));
	}

	@Test
	public void testToString_2() {

		assertFalse(scanRange2.toString().equals(scanRange1.toString()));
	}
}
