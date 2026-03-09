/*******************************************************************************
 * Copyright (c) 2025, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.converter.supplier.jcampdx;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.eclipse.chemclipse.csd.converter.supplier.jcampdx.converter.ChromatogramImportConverter;
import org.eclipse.chemclipse.csd.model.core.IChromatogramCSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Guava_ITest {

	private IChromatogramCSD chromatogram;

	@BeforeAll
	public void setUp() {

		File file = new File(TestPathHelper.GUAVA);
		ChromatogramImportConverter chromatogramImportConverter = new ChromatogramImportConverter();
		IProcessingInfo<IChromatogramCSD> processingInfo = chromatogramImportConverter.convert(file, new NullProgressMonitor());
		chromatogram = processingInfo.getProcessingResult();
	}

	@Test
	public void testSample() {

		assertEquals("Headspace from ripe guava", chromatogram.getSampleName());
	}

	@Test
	public void testScans() {

		assertEquals(6004, chromatogram.getNumberOfScans());
	}
}