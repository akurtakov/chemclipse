/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.instruments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Instrument_4_Test {

	private Instrument instrument;

	@BeforeAll
	public void setUp() {

		instrument = new Instrument("%$Instr|um;ent1[", "G|;;C-MS", "Research and ||Development;;");
	}

	@Test
	public void test1() {

		assertEquals("Instrument1", instrument.getIdentifier());
	}

	@Test
	public void test2() {

		assertEquals("GC-MS", instrument.getName());
	}

	@Test
	public void test3() {

		assertEquals("Research and Development", instrument.getDescription());
	}
}
