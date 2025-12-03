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

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.eclipse.chemclipse.model.core.MarkedTraceModus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class SelectedIons_7_Test {

	private IMarkedIons selectedIons;

	@BeforeAll
	public void setUp() {

		selectedIons = new MarkedIons(MarkedTraceModus.INCLUDE);
		selectedIons.add(new MarkedIon(28.82849943f));
		selectedIons.add(new MarkedIon(28.787f));
	}

	@Test
	public void testContains_1() {

		assertFalse(selectedIons.contains(new MarkedIon(28.8d)));
	}
}
