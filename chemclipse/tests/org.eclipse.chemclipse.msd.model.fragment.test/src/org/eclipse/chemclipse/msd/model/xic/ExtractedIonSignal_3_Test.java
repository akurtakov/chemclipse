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
package org.eclipse.chemclipse.msd.model.xic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * HashCode and equals test.
 * 
 * @author Philip Wenig
 */
@TestInstance(Lifecycle.PER_CLASS)
public class ExtractedIonSignal_3_Test {

	private IExtractedIonSignal extractedIonSignal1;
	private IExtractedIonSignal extractedIonSignal2;

	@BeforeAll
	public void setUp() {

		extractedIonSignal1 = new ExtractedIonSignal(1, 15);
		extractedIonSignal2 = new ExtractedIonSignal(1, 20);
	}

	@Test
	public void testEquals_1() {

		assertNotEquals(extractedIonSignal1, extractedIonSignal2);
	}

	@Test
	public void testEquals_2() {

		assertNotEquals(extractedIonSignal2, extractedIonSignal1);
	}

	@Test
	public void testEquals_3() {

		assertEquals(extractedIonSignal1, extractedIonSignal1);
	}

	@Test
	public void testEquals_4() {

		assertEquals(extractedIonSignal2, extractedIonSignal2);
	}

	@Test
	public void testEquals_5() {

		assertNotNull(extractedIonSignal1);
	}

	@Test
	public void testEquals_6() {

		assertNotNull(extractedIonSignal2);
	}

	@Test
	public void testEquals_7() {

		assertNotEquals(extractedIonSignal1, new Object());
	}

	@Test
	public void testEquals_8() {

		assertNotEquals(extractedIonSignal2, new Object());
	}

	@Test
	public void testHashCode_1() {

		assertNotEquals(extractedIonSignal1.hashCode(), extractedIonSignal2.hashCode());
	}

	@Test
	public void testHashCode_2() {

		assertNotEquals(extractedIonSignal2.hashCode(), extractedIonSignal1.hashCode());
	}
}
