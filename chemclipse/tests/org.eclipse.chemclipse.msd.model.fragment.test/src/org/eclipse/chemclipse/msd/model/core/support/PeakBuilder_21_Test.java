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
package org.eclipse.chemclipse.msd.model.core.support;

import org.easymock.EasyMock;
import org.eclipse.chemclipse.model.exceptions.PeakException;
import org.eclipse.chemclipse.model.support.IScanRange;
import org.eclipse.chemclipse.model.support.ScanRange;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;

import junit.framework.TestCase;

/**
 * Test the peak exceptions.
 * 
 * @author eselmeister
 */
public class PeakBuilder_21_Test extends TestCase {

	private IChromatogramMSD chromatogram;
	private IScanRange scanRange;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		chromatogram = EasyMock.createMock(IChromatogramMSD.class);
		EasyMock.expect(chromatogram.getNumberOfScans()).andStubReturn(20);
		EasyMock.replay(chromatogram);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testCheckScanRange_1() {

		scanRange = new ScanRange(10, 20);
		try {
			PeakBuilderMSD.checkScanRange(chromatogram, scanRange);
		} catch(PeakException e) {
			assertTrue("PeakException", false);
		}
	}

	public void testCheckScanRange_2() {

		scanRange = new ScanRange(0, 20);
		try {
			PeakBuilderMSD.checkScanRange(chromatogram, scanRange);
		} catch(PeakException e) {
			assertTrue("PeakException", true);
		}
	}

	public void testCheckScanRange_3() {

		scanRange = new ScanRange(10, 22);
		try {
			PeakBuilderMSD.checkScanRange(chromatogram, scanRange);
		} catch(PeakException e) {
			assertTrue("PeakException", true);
		}
	}
}
