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

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.integrator.exceptions.ValueMustNotBeNullException;
import org.eclipse.chemclipse.chromatogram.xxd.integrator.supplier.trapezoid.processor.PeakIntegrator;
import org.eclipse.chemclipse.msd.model.core.IPeakMSD;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class TrapezoidPeakIntegrator_2_Test extends DefaultPeakTestCase {

	private PeakIntegrator integrator;

	@Override
	@BeforeAll
	public void setUp() {

		super.setUp();
		integrator = new PeakIntegrator();
	}

	@Test
	public void testIntegrate_1() {

		assertThrows(ValueMustNotBeNullException.class, () -> {
			integrator.integrate(super.getPeak(), null);
		});
	}

	@Test
	public void testIntegrate_2() {

		List<IPeakMSD> peaks = new ArrayList<>();
		peaks.add(super.getPeak());
		assertThrows(ValueMustNotBeNullException.class, () -> {
			integrator.integrate(peaks, null, new NullProgressMonitor());
		});
	}
}
