/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.implementation.QuantitationEntry;
import org.eclipse.chemclipse.model.quantitation.IInternalStandard;
import org.eclipse.chemclipse.model.quantitation.IQuantitationEntry;
import org.eclipse.chemclipse.model.quantitation.InternalStandard;

public class PeakQuantifierSupport_2_Test extends PeakQuantifierSupportTestCase {

	private IPeak peak = null;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		/*
		 * ISTD
		 */
		peak = getPeak();
		//
		InternalStandard internalStandard = new InternalStandard("Styrene", 25.5d, "mg/g", 1.25d);
		peak.addInternalStandard(internalStandard);
		//
		IQuantitationEntry quantitationEntry = new QuantitationEntry("Benzene", 12.45d, "ppm", 35003);
		peak.addQuantitationEntry(quantitationEntry);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void test1() {

		assertEquals("25.5 mg/g x1.25", PeakQuantifierSupport.getInternalStandardConcentrations(peak));
	}

	public void test2() {

		assertEquals("12.45 ppm", PeakQuantifierSupport.getPeakConcentrations(peak));
	}

	public void test3() {

		IInternalStandard internalStandard = PeakQuantifierSupport.getInternalStandard("Styrene", "25.5 mg/g x1.25");
		assertEquals("Styrene", internalStandard.getName());
		assertEquals(25.5d, internalStandard.getConcentration());
		assertEquals("mg/g", internalStandard.getConcentrationUnit());
		assertEquals(1.25d, internalStandard.getCompensationFactor());
	}
}