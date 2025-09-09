/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.denoising.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.chemclipse.model.core.MarkedTraceModus;
import org.eclipse.chemclipse.msd.model.core.support.MarkedIons;
import org.eclipse.chemclipse.support.util.TraceSettingUtil;
import org.junit.jupiter.api.Test;

public class DenoisingFilterSettings_1_Test {

	private FilterSettings settings = new FilterSettings();

	@Test
	public void testGetIonsToRemove_1() {

		assertNotNull(settings.getIonsToRemove());
	}

	@Test
	public void testGetIonsToRemove_2() {

		TraceSettingUtil settingIon = new TraceSettingUtil();
		assertEquals(4, new MarkedIons(settingIon.extractTraces(settingIon.deserialize(settings.getIonsToRemove())), MarkedTraceModus.INCLUDE).getIonsNominal().size(), "IonsToRemove Size");
	}

	@Test
	public void testGetIonsToPreserve_1() {

		assertNotNull(settings.getIonsToPreserve());
	}

	@Test
	public void testGetIonsToPreserve_2() {

		TraceSettingUtil settingIon = new TraceSettingUtil();
		assertEquals(2, new MarkedIons(settingIon.extractTraces(settingIon.deserialize(settings.getIonsToPreserve())), MarkedTraceModus.INCLUDE).getIonsNominal().size(), "IonsToPreserve Size");
	}

	@Test
	public void testGetAdjustThresholdTransitions_1() {

		assertTrue(settings.isAdjustThresholdTransitions());
	}

	@Test
	public void testGetAdjustThresholdTransitions_2() {

		settings.setAdjustThresholdTransitions(false);
		assertFalse(settings.isAdjustThresholdTransitions());
	}

	@Test
	public void testGetNumberOfUsedIonsForCoefficient_1() {

		assertEquals(1, settings.getNumberOfUsedIonsForCoefficient(), "NumberOfUsedIonsForCoefficient");
	}

	@Test
	public void testGetNumberOfUsedIonsForCoefficient_2() {

		settings.setNumberOfUsedIonsForCoefficient(5);
		assertEquals(5, settings.getNumberOfUsedIonsForCoefficient(), "NumberOfUsedIonsForCoefficient");
	}

	@Test
	public void testGetNumberOfUsedIonsForCoefficient_3() {

		settings.setNumberOfUsedIonsForCoefficient(0);
		assertEquals(1, settings.getNumberOfUsedIonsForCoefficient(), "NumberOfUsedIonsForCoefficient");
	}

	@Test
	public void testGetNumberOfUsedIonsForCoefficient_4() {

		settings.setNumberOfUsedIonsForCoefficient(-1);
		assertEquals(1, settings.getNumberOfUsedIonsForCoefficient(), "NumberOfUsedIonsForCoefficient");
	}
}
