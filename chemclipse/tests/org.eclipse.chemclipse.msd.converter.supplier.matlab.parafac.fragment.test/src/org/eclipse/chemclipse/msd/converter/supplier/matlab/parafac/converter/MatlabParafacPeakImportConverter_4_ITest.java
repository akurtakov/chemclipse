/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.matlab.parafac.converter;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;

import org.eclipse.chemclipse.msd.model.core.IPeaksMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MatlabParafacPeakImportConverter_4_ITest {

	private MatlabParafacPeakImportConverter converter = new MatlabParafacPeakImportConverter();

	@Test
	public void testImport_1() {

		assertThrows(NullPointerException.class, () -> {
			File file = new File("testData/files/import/tests/Empty.mpl");
			converter.convert(file, new NullProgressMonitor());
		});
	}

	@Test
	public void testImport_2() {

		File file = new File("testData/files/import/tests/NotReadable.mpl");
		file.setReadable(false);
		IProcessingInfo<IPeaksMSD> processingInfo = converter.convert(file, new NullProgressMonitor());
		assertNull(processingInfo.getProcessingResult());
		file.setReadable(true);
	}

	@Test
	public void testImport_3() {

		assertThrows(NullPointerException.class, () -> {
			File file = new File("testData/files/import/tests/peaks");
			converter.convert(file, new NullProgressMonitor());
		});
	}

	@Test
	public void testImport_4() {

		assertThrows(NullPointerException.class, () -> {
			File file = new File("testData/files/import/tests/peaks.mpl");
			converter.convert(file, new NullProgressMonitor());
		});
	}
}
