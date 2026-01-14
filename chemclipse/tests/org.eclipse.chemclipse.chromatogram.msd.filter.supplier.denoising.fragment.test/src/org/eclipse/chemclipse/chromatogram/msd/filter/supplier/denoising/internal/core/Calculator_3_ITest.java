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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.denoising.internal.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.denoising.internal.core.support.ChromatogramImporterTestCase;
import org.eclipse.chemclipse.model.core.MarkedTraceModus;
import org.eclipse.chemclipse.msd.model.core.support.IMarkedIons;
import org.eclipse.chemclipse.msd.model.core.support.MarkedIon;
import org.eclipse.chemclipse.msd.model.core.support.MarkedIons;
import org.eclipse.chemclipse.msd.model.exceptions.FilterException;
import org.eclipse.chemclipse.msd.model.noise.Calculator;
import org.eclipse.chemclipse.msd.model.noise.INoiseSegmentMSD;
import org.eclipse.chemclipse.msd.model.xic.ExtractedIonSignalExtractor;
import org.eclipse.chemclipse.msd.model.xic.IExtractedIonSignalExtractor;
import org.eclipse.chemclipse.msd.model.xic.IExtractedIonSignals;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Calculator_3_ITest extends ChromatogramImporterTestCase {

	private Calculator calculator = new Calculator();
	private List<INoiseSegmentMSD> noiseSegments;

	@Override
	@BeforeAll
	public void setUp() throws FilterException, IOException {

		super.setUp();
		IMarkedIons ionsToPreserve = new MarkedIons(MarkedTraceModus.INCLUDE);
		ionsToPreserve.add(new MarkedIon(103));
		ionsToPreserve.add(new MarkedIon(104));
		IExtractedIonSignalExtractor extractedIonSignalExtractor = new ExtractedIonSignalExtractor(chromatogram);
		IExtractedIonSignals extractedIonSignals = extractedIonSignalExtractor.getExtractedIonSignals(chromatogramSelection);
		noiseSegments = calculator.getNoiseSegments(extractedIonSignals, ionsToPreserve, 13, new NullProgressMonitor());
	}

	@Test
	public void testGetSize_1() {

		assertEquals(9, noiseSegments.size(), "Size");
	}
}
