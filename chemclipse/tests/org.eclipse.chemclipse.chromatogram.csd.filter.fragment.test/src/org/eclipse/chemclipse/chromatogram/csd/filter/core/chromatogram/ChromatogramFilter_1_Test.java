/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.csd.filter.core.chromatogram;

import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.csd.model.core.IChromatogramCSD;
import org.eclipse.chemclipse.csd.model.core.selection.ChromatogramSelectionCSD;
import org.eclipse.chemclipse.csd.model.core.selection.IChromatogramSelectionCSD;
import org.eclipse.chemclipse.csd.model.implementation.ChromatogramCSD;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.Test;

public class ChromatogramFilter_1_Test {

	private IChromatogramFilterCSD filter;
	private IChromatogramSelectionCSD chromatogramSelection;
	private IChromatogramCSD chromatogram;
	private IChromatogramFilterSettings chromatogramFilterSettings;

	@Test
	public void testConstructor_1() {

		chromatogramSelection = null;
		chromatogramFilterSettings = null;
		filter = new TestChromatogramFilter();
		filter.applyFilter(chromatogramSelection, chromatogramFilterSettings, new NullProgressMonitor());
	}

	@Test
	public void testConstructor_2() {

		chromatogram = new ChromatogramCSD();
		chromatogramSelection = new ChromatogramSelectionCSD(chromatogram);
		chromatogramFilterSettings = null;
		filter = new TestChromatogramFilter();
		filter.applyFilter(chromatogramSelection, chromatogramFilterSettings, new NullProgressMonitor());
	}
}
