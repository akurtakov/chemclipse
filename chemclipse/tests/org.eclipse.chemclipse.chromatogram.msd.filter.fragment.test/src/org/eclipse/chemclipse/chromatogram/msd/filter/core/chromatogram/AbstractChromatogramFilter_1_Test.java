/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.core.chromatogram;

import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.model.exceptions.ChromatogramIsNullException;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.selection.ChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;
import org.eclipse.core.runtime.NullProgressMonitor;

import junit.framework.TestCase;

/**
 * @author Philip Wenig
 */
public class AbstractChromatogramFilter_1_Test extends TestCase {

	private IChromatogramFilterMSD filter;
	private IChromatogramSelectionMSD chromatogramSelection;
	private IChromatogramMSD chromatogram;
	private IChromatogramFilterSettings chromatogramFilterSettings;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testConstructor_1() {

		chromatogramSelection = null;
		chromatogramFilterSettings = null;
		filter = new TestChromatogramFilter();
		filter.applyFilter(chromatogramSelection, chromatogramFilterSettings, new NullProgressMonitor());
	}

	public void testConstructor_2() {

		chromatogram = new ChromatogramMSD();
		try {
			chromatogramSelection = new ChromatogramSelectionMSD(chromatogram);
		} catch(ChromatogramIsNullException e) {
			assertTrue("ChromatogramIsNullException", false);
		}
		chromatogramFilterSettings = null;
		filter = new TestChromatogramFilter();
		filter.applyFilter(chromatogramSelection, chromatogramFilterSettings, new NullProgressMonitor());
	}
}
