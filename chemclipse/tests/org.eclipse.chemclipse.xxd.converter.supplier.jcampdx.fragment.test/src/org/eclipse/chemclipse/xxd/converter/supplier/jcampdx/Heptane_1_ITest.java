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

import org.eclipse.chemclipse.msd.converter.database.DatabaseConverter;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.support.model.SeparationColumnType;
import org.eclipse.chemclipse.xxd.converter.supplier.jcampdx.preferences.PreferenceSupplier;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Heptane_1_ITest {

	private IMassSpectra massSpectra;

	@BeforeAll
	public void setUp() {

		PreferenceSupplier.setSeparationColumnTypeRetentionIndex1(SeparationColumnType.NON_POLAR);
		PreferenceSupplier.setSeparationColumnTypeRetentionIndex2(SeparationColumnType.POLAR);
		PreferenceSupplier.setSeparationColumnTypeRetentionIndex3(SeparationColumnType.SEMI_POLAR);
		File file = new File("testData/Heptane_1.JDX");
		IProcessingInfo<IMassSpectra> processingInfo = DatabaseConverter.convert(file, new NullProgressMonitor());
		massSpectra = processingInfo.getProcessingResult();
	}

	@Test
	public void test01() {

		assertNotNull(massSpectra);
		assertEquals(1, massSpectra.size());
	}

	@Test
	public void test02() {

		IScanMSD scanMSD = massSpectra.getMassSpectrum(1);
		assertEquals(700.0f, scanMSD.getRetentionIndex());
		assertEquals(700.0f, scanMSD.getRetentionIndex(SeparationColumnType.NON_POLAR));
		assertEquals(0.0f, scanMSD.getRetentionIndex(SeparationColumnType.POLAR));
		assertEquals(0.0f, scanMSD.getRetentionIndex(SeparationColumnType.SEMI_POLAR));
	}
}