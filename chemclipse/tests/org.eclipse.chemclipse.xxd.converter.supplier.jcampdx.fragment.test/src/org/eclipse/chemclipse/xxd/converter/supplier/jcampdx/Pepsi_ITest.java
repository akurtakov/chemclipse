/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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

import java.io.File;

import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.wsd.converter.supplier.jcampdx.converter.ScanImportConverter;
import org.eclipse.chemclipse.wsd.model.core.ISpectrumWSD;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Test;

import junit.framework.TestCase;

public class Pepsi_ITest extends TestCase {

	private ISpectrumWSD spectrumWSD;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		File file = new File(PathResolver.getAbsolutePath(TestPathHelper.PEPSI));
		ScanImportConverter importConverter = new ScanImportConverter();
		IProcessingInfo<ISpectrumWSD> processingInfo = importConverter.convert(file, new NullProgressMonitor());
		spectrumWSD = processingInfo.getProcessingResult();
	}

	@Override
	protected void tearDown() throws Exception {

		spectrumWSD = null;
		super.tearDown();
	}

	@Test
	public void testLoading() {

		assertNotNull(spectrumWSD);
		assertEquals("pepsi-cola (diluted)", spectrumWSD.getDataName());
		assertEquals("PERKIN-ELMER LAMBDA 19 UV/VIS/NIR UV", spectrumWSD.getInstrument());
	}

	@Test
	public void testSignals() {

		assertEquals(101, spectrumWSD.getSignals().size());
	}
}