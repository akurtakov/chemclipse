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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.chromatogram.xxd.integrator.supplier.trapezoid.processor.ChromatogramIntegrator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class TrapezoidChromatogramIntegrator_1_Test extends SimpleChromatogramTestCase {

	private ChromatogramIntegrator integrator;

	@Override
	@BeforeAll
	public void setUp() {

		super.setUp();
		integrator = new ChromatogramIntegrator();
	}

	@Test
	public void testIntegrate_1() {

		double area = integrator.integrate(chromatogramSelection);
		assertEquals(30000.0d, area, 0);
	}
}
