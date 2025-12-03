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
import org.eclipse.chemclipse.msd.model.core.AbstractIon;
import org.junit.jupiter.api.Test;

public class SelectedIons_2_Test {

	private IMarkedIons selectedIons = new MarkedIons(MarkedTraceModus.INCLUDE);

	@Test
	public void testContains_1() {

		assertFalse(selectedIons.getIonsNominal().contains(AbstractIon.getIon(4.9f)));
	}

	@Test
	public void testContains_2() {

		selectedIons.add(new MarkedIon(5));
		assertTrue(selectedIons.getIonsNominal().contains(AbstractIon.getIon(4.9f)));
	}

	@Test
	public void testContains_3() {

		selectedIons.add(new MarkedIon(5));
		selectedIons.remove(new MarkedIon(5));
		assertFalse(selectedIons.getIonsNominal().contains(AbstractIon.getIon(5.4f)));
	}

	@Test
	public void testContains_4() {

		selectedIons.add(new MarkedIon(10));
		selectedIons.add(new MarkedIon(5));
		selectedIons.add(new MarkedIon(20));
		assertTrue(selectedIons.getIonsNominal().contains(AbstractIon.getIon(20.2f)));
	}

	@Test
	public void testContains_5() {

		selectedIons.add(50, 60);
		Set<Integer> list = selectedIons.getIonsNominal();
		assertEquals(11, list.size());
		for(int i = 50; i <= 60; i++) {
			assertTrue(list.contains(i), "ion " + i);
		}
	}
}
