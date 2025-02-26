/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.internal.core.support;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model.TargetTrace;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model.TargetTraces;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.settings.ClassifierSettings;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;

public class Calculator_2_ITest extends ChromatogramTestCase {

	private Calculator calculator;
	private TargetTraces targetTraces;
	private TargetTrace targetTrace;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		calculator = new Calculator();
		ClassifierSettings classifierSettings = new ClassifierSettings();
		targetTraces = classifierSettings.getTargetTraces();
		IChromatogramSelectionMSD chromatogramSelection = getChromatogramSelection();
		targetTraces = calculator.calculateIonPercentages(chromatogramSelection, classifierSettings);
	}

	@Override
	protected void tearDown() throws Exception {

		calculator = null;
		targetTraces = null;
		super.tearDown();
	}

	public void testCalculatedWncIons_1() {

		targetTrace = targetTraces.getTargetTrace(18);
		assertEquals(18, targetTrace.getIon());
		assertEquals("Water", targetTrace.getName());
		assertEquals(21.002375405306804d, targetTrace.getPercentageMaxIntensity());
		assertEquals(1.977177063160481d, targetTrace.getPercentageSumIntensity());
	}

	public void testCalculatedWncIons_2() {

		targetTrace = targetTraces.getTargetTrace(28);
		assertEquals(28, targetTrace.getIon());
		assertEquals("Nitrogen", targetTrace.getName());
		assertEquals(99.99999999999999d, targetTrace.getPercentageMaxIntensity());
		assertEquals(9.414064004688226d, targetTrace.getPercentageSumIntensity());
	}

	public void testCalculatedWncIons_3() {

		targetTrace = targetTraces.getTargetTrace(32);
		assertEquals(32, targetTrace.getIon());
		assertEquals("Oxygen", targetTrace.getName());
		assertEquals(24.744202936490822d, targetTrace.getPercentageMaxIntensity());
		assertEquals(2.3294351018911894d, targetTrace.getPercentageSumIntensity());
	}

	public void testCalculatedWncIons_4() {

		targetTrace = targetTraces.getTargetTrace(44);
		assertEquals(44, targetTrace.getIon());
		assertEquals("Carbon Dioxide", targetTrace.getName());
		assertEquals(21.7383894585452d, targetTrace.getPercentageMaxIntensity());
		assertEquals(2.0464658972158434d, targetTrace.getPercentageSumIntensity());
	}

	public void testCalculatedWncIons_5() {

		targetTrace = targetTraces.getTargetTrace(84);
		assertEquals(84, targetTrace.getIon());
		assertEquals("Solvent Tailing", targetTrace.getName());
		assertEquals(4.285515151830384d, targetTrace.getPercentageMaxIntensity());
		assertEquals(0.40344113932392417d, targetTrace.getPercentageSumIntensity());
	}

	public void testCalculatedWncIons_6() {

		targetTrace = targetTraces.getTargetTrace(207);
		assertEquals(207, targetTrace.getIon());
		assertEquals("Column Bleed", targetTrace.getName());
		assertEquals(6.292490758325699d, targetTrace.getPercentageMaxIntensity());
		assertEquals(0.5923791074778729d, targetTrace.getPercentageSumIntensity());
	}
}