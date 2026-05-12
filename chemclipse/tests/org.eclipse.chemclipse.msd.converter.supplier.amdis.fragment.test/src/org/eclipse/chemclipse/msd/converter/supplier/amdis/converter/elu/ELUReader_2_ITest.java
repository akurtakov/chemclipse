/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Alexander Kerner - Generics
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.amdis.converter.elu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.msd.converter.supplier.amdis.io.ELUReader;
import org.eclipse.chemclipse.msd.model.core.IPeaksMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ELUReader_2_ITest {

	private IProcessingInfo<IPeaksMSD> processingInfo;

	@BeforeAll
	public void setUp() throws IOException {

		ELUReader reader = new ELUReader();
		File file = new File("testData/files/import/elu/Peaks1.ELU");
		processingInfo = reader.read(file, new NullProgressMonitor());
	}

	@Test
	public void testRead_1() {

		IPeaksMSD peaks = processingInfo.getProcessingResult();
		assertEquals(1154, peaks.getPeaks().size());
		assertEquals(1132, peaks.getPeaks().stream().filter(p -> p.getPeakModel().isStrictModel()).toList().size());
	}
}
