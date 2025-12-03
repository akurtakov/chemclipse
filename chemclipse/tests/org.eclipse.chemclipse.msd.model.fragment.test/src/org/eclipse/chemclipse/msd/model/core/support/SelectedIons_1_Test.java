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
package org.eclipse.chemclipse.msd.model.core.support;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.eclipse.chemclipse.model.core.MarkedTraceModus;
import org.junit.jupiter.api.Test;

public class SelectedIons_1_Test {

	private IMarkedIons selectedIons = new MarkedIons(MarkedTraceModus.INCLUDE);

	@Test
	public void testContains_1() {

		assertFalse(selectedIons.getIonsNominal().contains(5));
	}

	@Test
	public void testContains_2() {

		selectedIons.add(new MarkedIon(5));
		assertTrue(selectedIons.getIonsNominal().contains(5));
	}

	@Test
	public void testContains_3() {

		selectedIons.add(new MarkedIon(5));
		selectedIons.remove(new MarkedIon(5));
		assertFalse(selectedIons.getIonsNominal().contains(5));
	}

	@Test
	public void testContains_4() {

		selectedIons.add(new MarkedIon(10));
		selectedIons.add(new MarkedIon(5));
		selectedIons.add(new MarkedIon(20));
		assertTrue(selectedIons.getIonsNominal().contains(20));
	}

	@Test
	public void testContains_5() {

		selectedIons.add(10, 12);
		Set<Integer> selectedIonsNominal = selectedIons.getIonsNominal();
		assertFalse(selectedIonsNominal.contains(20));
		assertTrue(selectedIonsNominal.contains(10));
		assertTrue(selectedIonsNominal.contains(11));
		assertTrue(selectedIonsNominal.contains(12));
	}

	@Test
	public void testContains_6() {

		selectedIons.add(12, 10);
		Set<Integer> selectedIonsNominal = selectedIons.getIonsNominal();
		assertFalse(selectedIonsNominal.contains(20));
		assertTrue(selectedIonsNominal.contains(10));
		assertTrue(selectedIonsNominal.contains(11));
		assertTrue(selectedIonsNominal.contains(12));
	}

	@Test
	public void testContains_7() {

		selectedIons.add(12, 12);
		Set<Integer> selectedIonsNominal = selectedIons.getIonsNominal();
		assertFalse(selectedIonsNominal.contains(20));
		assertFalse(selectedIonsNominal.contains(10));
		assertFalse(selectedIonsNominal.contains(11));
		assertTrue(selectedIonsNominal.contains(12));
	}

	@Test
	public void testSize_8() {

		selectedIons.add(12, 12);
		assertEquals(1, selectedIons.getIonsNominal().size());
	}

	@Test
	public void testSize_9() {

		selectedIons.add(new MarkedIon(58));
		selectedIons.add(new MarkedIon(48));
		selectedIons.add(new MarkedIon(372));
		assertEquals(3, selectedIons.getIonsNominal().size());
	}

	@Test
	public void testSize_10() {

		assertEquals(0, selectedIons.getIonsNominal().size());
	}
}
