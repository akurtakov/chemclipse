/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.comparison.math;

import org.eclipse.chemclipse.msd.model.core.IScanMSD;

public class GeometricDistanceCalculator_3_Test extends MassSpectrumSetTestCase {

	private GeometricDistanceCalculator calculator;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		calculator = new GeometricDistanceCalculator();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void test1() {

		IScanMSD unknown = sinapylAclohol.getMassSpectrum();
		IScanMSD reference = syringylAcetone.getMassSpectrum();
		assertEquals(0.61818206f, calculator.calculate(unknown, reference, unknown.getExtractedIonSignal().getIonRange()));
	}

	public void test2() {

		IScanMSD unknown = syringylAcetone.getMassSpectrum();
		IScanMSD reference = sinapylAclohol.getMassSpectrum();
		assertEquals(0.618202f, calculator.calculate(unknown, reference, unknown.getExtractedIonSignal().getIonRange()));
	}

	public void test3() {

		IScanMSD unknown = syringylAcetone.getMassSpectrum();
		IScanMSD reference = syringylAcetone.getMassSpectrum();
		assertEquals(1.0f, calculator.calculate(unknown, reference, unknown.getExtractedIonSignal().getIonRange()));
	}
}
