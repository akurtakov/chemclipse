/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.backfolding.core;

import org.eclipse.chemclipse.chromatogram.msd.filter.core.chromatogram.IChromatogramFilterMSD;
import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.backfolding.settings.ChromatogramFilterSettings;
import org.eclipse.core.runtime.NullProgressMonitor;

public class BackfoldingFilter_1_ITest extends ChromatogramImporterTestCase {

	private IChromatogramFilterMSD chromatogramFilter;
	private ChromatogramFilterSettings chromatogramFilterSettings;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		chromatogramFilter = new ChromatogramFilterMSD();
		chromatogramFilterSettings = new ChromatogramFilterSettings();
	}

	@Override
	protected void tearDown() throws Exception {

		chromatogramFilter = null;
		chromatogramFilterSettings = null;
		super.tearDown();
	}

	public void testApplyFilter_1() {

		int scan = 1;
		chromatogramFilter.applyFilter(chromatogramSelection, chromatogramFilterSettings, new NullProgressMonitor());
		assertEquals("total signal", 1934.0f, chromatogram.getScan(scan).getTotalSignal());
	}
}
