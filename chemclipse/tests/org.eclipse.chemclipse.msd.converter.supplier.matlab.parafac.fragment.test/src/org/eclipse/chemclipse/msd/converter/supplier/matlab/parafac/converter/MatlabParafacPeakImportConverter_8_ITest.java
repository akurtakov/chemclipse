/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.matlab.parafac.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.eclipse.chemclipse.msd.converter.supplier.matlab.parafac.TestPathHelper;
import org.eclipse.chemclipse.msd.model.core.IPeaksMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MatlabParafacPeakImportConverter_8_ITest {

	private IPeaksMSD peaks;

	@BeforeAll
	public void setUp() {

		MatlabParafacPeakImportConverter converter = new MatlabParafacPeakImportConverter();
		File file = new File(TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_PARAFAC_TEST_4));
		IProcessingInfo<IPeaksMSD> processingInfo = converter.convert(file, new NullProgressMonitor());
		peaks = processingInfo.getProcessingResult();
	}

	@Test
	public void testImport_1() {

		assertEquals(3, peaks.getPeaks().size());
	}
}
