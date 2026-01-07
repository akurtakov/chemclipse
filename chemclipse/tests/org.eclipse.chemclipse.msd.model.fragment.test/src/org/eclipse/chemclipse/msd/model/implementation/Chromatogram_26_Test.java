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
package org.eclipse.chemclipse.msd.model.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.core.IIntegrationEntry;
import org.eclipse.chemclipse.model.implementation.IntegrationEntry;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Chromatogram_26_Test {

	private IChromatogramMSD chromatogram;

	@BeforeAll
	public void setUp() {

		chromatogram = new ChromatogramMSD();
		/*
		 * Chromatogram Integration Entries
		 */
		List<IIntegrationEntry> chromatogramIntegrationEntries = new ArrayList<>();
		IIntegrationEntry chromatogramIntegrationEntry = new IntegrationEntry(25.3f, 26778.7d);
		chromatogramIntegrationEntries.add(chromatogramIntegrationEntry);
		chromatogramIntegrationEntry = new IntegrationEntry(28.1f, 3446.2d);
		chromatogramIntegrationEntries.add(chromatogramIntegrationEntry);
		chromatogramIntegrationEntry = new IntegrationEntry(29.2f, 84598.5d);
		chromatogramIntegrationEntries.add(chromatogramIntegrationEntry);
		chromatogramIntegrationEntry = new IntegrationEntry(34.7f, 4885.1d);
		chromatogramIntegrationEntries.add(chromatogramIntegrationEntry);
		/*
		 * Background Integration Entries
		 */
		List<IIntegrationEntry> backgroundIntegrationEntries = new ArrayList<>();
		IIntegrationEntry backgroundIntegrationEntry = new IntegrationEntry(28.2f, 378374.78d);
		backgroundIntegrationEntries.add(backgroundIntegrationEntry);
		backgroundIntegrationEntry = new IntegrationEntry(56.1f, 92043074.78d);
		backgroundIntegrationEntries.add(backgroundIntegrationEntry);

		chromatogram.setIntegratedArea(chromatogramIntegrationEntries, backgroundIntegrationEntries, "Test Integrator");
	}

	@Test
	public void testGetChromatogramIntegratedArea_1() {

		assertEquals(119708.5d, chromatogram.getChromatogramIntegratedArea(), 0);
	}

	@Test
	public void testGetChromatogramIntegratorDescription_1() {

		assertEquals("Test Integrator", chromatogram.getIntegratorDescription());
	}

	@Test
	public void testGetBackgroundIntegratedArea_1() {

		assertEquals(92421449.56d, chromatogram.getBackgroundIntegratedArea(), 0);
	}

	@Test
	public void testGetBackgroundIntegratorDescription_1() {

		assertEquals("Test Integrator", chromatogram.getIntegratorDescription());
	}
}
