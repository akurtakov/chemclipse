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

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * HashCode and equals test.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class ExtractedIonSignal_2_Test {

	private IExtractedIonSignal extractedIonSignal1;
	private IExtractedIonSignal extractedIonSignal2;

	@BeforeAll
	public void setUp() {

		extractedIonSignal1 = new ExtractedIonSignal(1, 20);
		extractedIonSignal2 = new ExtractedIonSignal(1, 20);
	}

	@Test
	public void testEquals_1() {

		assertTrue(extractedIonSignal1.equals(extractedIonSignal2));
	}

	@Test
	public void testEquals_2() {

		assertTrue(extractedIonSignal2.equals(extractedIonSignal1));
	}

	@Test
	public void testHashCode_1() {

		assertTrue(extractedIonSignal1.hashCode() == extractedIonSignal2.hashCode());
	}

	@Test
	public void testHashCode_2() {

		assertTrue(extractedIonSignal2.hashCode() == extractedIonSignal1.hashCode());
	}
}
