/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.converter.supplier.jcampdx;

import java.io.File;

import org.eclipse.chemclipse.model.core.IComplexSignalMeasurement;
import org.eclipse.chemclipse.nmr.converter.supplier.jcampdx.converter.ScanImportConverterNMR;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;

import junit.framework.TestCase;

public class BrukerAFFN_ITest extends TestCase {

	private IComplexSignalMeasurement<?> complexSignalMeasurement;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		File file = new File(PathResolver.getAbsolutePath(TestPathHelper.REAL_SPECTRUM_ASCII_FREE_FORMAT_NUMERIC));
		ScanImportConverterNMR importConverter = new ScanImportConverterNMR();
		IProcessingInfo<IComplexSignalMeasurement<?>> processingInfo = importConverter.convert(file, new NullProgressMonitor());
		complexSignalMeasurement = processingInfo.getProcessingResult();
	}

	@Override
	protected void tearDown() throws Exception {

		complexSignalMeasurement = null;
		super.tearDown();
	}

	public void testLoading() {

		assertNotNull(complexSignalMeasurement);
	}

	public void testSignals() {

		assertEquals(16754, complexSignalMeasurement.getSignals().size());
	}
}
