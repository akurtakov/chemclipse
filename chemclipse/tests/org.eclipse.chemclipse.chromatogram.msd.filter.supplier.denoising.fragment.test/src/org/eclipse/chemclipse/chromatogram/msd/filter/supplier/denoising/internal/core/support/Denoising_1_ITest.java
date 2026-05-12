/*******************************************************************************
 * Copyright (c) 2010, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.denoising.internal.core.support;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.eclipse.chemclipse.model.core.MarkedTraceModus;
import org.eclipse.chemclipse.msd.model.core.ICombinedMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.support.IMarkedIons;
import org.eclipse.chemclipse.msd.model.core.support.MarkedIon;
import org.eclipse.chemclipse.msd.model.core.support.MarkedIons;
import org.eclipse.chemclipse.msd.model.exceptions.FilterException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Denoising_1_ITest extends ChromatogramImporterTestCase {

	private List<ICombinedMassSpectrum> noiseMassSpectra;

	@Override
	@BeforeAll
	public void setUp() throws FilterException {

		super.setUp();
		IMarkedIons ionsToRemove = new MarkedIons(MarkedTraceModus.INCLUDE);
		ionsToRemove.add(new MarkedIon(18));
		ionsToRemove.add(new MarkedIon(28));
		ionsToRemove.add(new MarkedIon(32));
		ionsToRemove.add(new MarkedIon(84));
		ionsToRemove.add(new MarkedIon(207));
		IMarkedIons ionsToPreserve = new MarkedIons(MarkedTraceModus.INCLUDE);
		ionsToPreserve.add(new MarkedIon(103));
		ionsToPreserve.add(new MarkedIon(103));
		noiseMassSpectra = Denoising.applyDenoisingFilter(chromatogramSelection, ionsToRemove, ionsToPreserve, true, 1, 13, new NullProgressMonitor());
	}

	@Test
	public void testGetSize_1() {

		assertEquals(11, noiseMassSpectra.size(), "Size");
	}
}
