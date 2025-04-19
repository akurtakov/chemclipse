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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.supplier.trapezoid.internal.core;

import org.eclipse.chemclipse.chromatogram.xxd.integrator.supplier.trapezoid.TestPathHelper;
import org.eclipse.chemclipse.chromatogram.xxd.integrator.supplier.trapezoid.processor.ChromatogramIntegrator;

public class TrapezoidChromatogramIntegrator_2_ITest extends ChromatogramImportTestCase {

	private ChromatogramIntegrator integrator;

	@Override
	protected void setUp() throws Exception {

		chromatogramRelativePath = TestPathHelper.TESTFILE_IMPORT_CHROMATOGRAM_1;
		super.setUp();
		integrator = new ChromatogramIntegrator();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testIntegrate_1() {

		double area = integrator.integrate(chromatogramSelection);
		assertEquals("", 7.893094987865009E9, area);
	}
}
