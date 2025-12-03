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
package org.eclipse.chemclipse.msd.model.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.model.math.IonRoundMethod;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class AbstractIon_1_Test {

	private IonRoundMethod defaultMethod;

	@BeforeAll
	public void setUp() {

		defaultMethod = IonRoundMethod.getActive();
		IonRoundMethod.setActive(IonRoundMethod.DEFAULT);
	}

	@AfterAll
	public void tearDown() {

		IonRoundMethod.setActive(defaultMethod);
	}

	@Test
	public void testGetIon_1() {

		int ion = AbstractIon.getIon(45.4f);
		assertEquals(45, ion);
	}

	@Test
	public void testGetIon_2() {

		int ion = AbstractIon.getIon(0.0f);
		assertEquals(0, ion);
	}

	@Test
	public void testGetIon_3() {

		int ion = AbstractIon.getIon(45.5f);
		assertEquals(46, ion);
	}

	@Test
	public void testGetIon_4() {

		int ion = AbstractIon.getIon(45.7f);
		assertEquals(46, ion);
	}

	@Test
	public void testGetAbundance_1() {

		int abundance = AbstractIon.getAbundance(34345.4f);
		assertEquals(34345, abundance);
	}

	@Test
	public void testGetAbundance_2() {

		int abundance = AbstractIon.getAbundance(0.0f);
		assertEquals(0, abundance);
	}

	@Test
	public void testGetAbundance_3() {

		int abundance = AbstractIon.getAbundance(34345.5f);
		assertEquals(34346, abundance);
	}

	@Test
	public void testGetAbundance_4() {

		int abundance = AbstractIon.getAbundance(34345.7f);
		assertEquals(34346, abundance);
	}
}
