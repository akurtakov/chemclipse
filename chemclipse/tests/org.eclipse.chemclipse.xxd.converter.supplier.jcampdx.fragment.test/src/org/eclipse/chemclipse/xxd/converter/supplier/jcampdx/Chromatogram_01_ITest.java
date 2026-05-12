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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.converter.supplier.jcampdx;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.msd.converter.supplier.jcampdx.converter.ChromatogramImportConverter;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Chromatogram_01_ITest {

	private IChromatogramMSD chromatogram;

	@BeforeAll
	public void setUp() {

		File file = new File("testData/Chromatogram_01.jdx");
		ChromatogramImportConverter chromatogramImportConverter = new ChromatogramImportConverter();
		IProcessingInfo<IChromatogramMSD> processingInfo = chromatogramImportConverter.convert(file, new NullProgressMonitor());
		chromatogram = processingInfo.getProcessingResult();
	}

	@Test
	public void test01() {

		assertNotNull(chromatogram);
	}

	@Test
	public void test02() {

		assertEquals(7, chromatogram.getNumberOfScans());
	}

	@Test
	public void test03() {

		IScanMSD scanMSD = chromatogram.getScan(4);
		assertEquals(1, scanMSD.getTargets().size());
		IIdentificationTarget identificationTarget = scanMSD.getTargets().iterator().next();
		ILibraryInformation libraryInformation = identificationTarget.getLibraryInformation();
		assertEquals("Toluene", libraryInformation.getName());
		assertEquals(765.0f, libraryInformation.getRetentionIndex());
	}
}