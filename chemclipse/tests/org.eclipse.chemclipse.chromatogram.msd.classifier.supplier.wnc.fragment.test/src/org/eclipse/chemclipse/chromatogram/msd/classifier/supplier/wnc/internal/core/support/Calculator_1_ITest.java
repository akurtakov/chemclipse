/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.internal.core.support;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.exceptions.ClassifierException;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.settings.ClassifierSettings;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;

public class Calculator_1_ITest extends ChromatogramTestCase {

	private Calculator calculator;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		calculator = new Calculator();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testCalculator_1() {

		try {
			ClassifierSettings classifierSettings = new ClassifierSettings();
			IChromatogramSelectionMSD chromatogramSelection = getChromatogramSelection();
			calculator.calculateIonPercentages(chromatogramSelection, classifierSettings);
		} catch(ClassifierException e) {
			assertTrue("ClassifierException shouldn't be thrown here.", false);
		}
	}
}