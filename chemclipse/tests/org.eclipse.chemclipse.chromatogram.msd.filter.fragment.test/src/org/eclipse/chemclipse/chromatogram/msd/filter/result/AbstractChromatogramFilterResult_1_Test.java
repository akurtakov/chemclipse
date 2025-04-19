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
package org.eclipse.chemclipse.chromatogram.msd.filter.result;

import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;

import junit.framework.TestCase;

/**
 * @author eselmeister
 */
public class AbstractChromatogramFilterResult_1_Test extends TestCase {

	private IChromatogramFilterResult chromatogramFilterResult;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		chromatogramFilterResult = null;
		super.tearDown();
	}

	public void testGetResultStatus_1() {

		ResultStatus status = ResultStatus.EXCEPTION;
		chromatogramFilterResult = new TestChromatogramFilterResult(status, "");
		assertEquals("ResultStatus", ResultStatus.EXCEPTION, chromatogramFilterResult.getResultStatus());
	}

	public void testGetResultStatus_2() {

		ResultStatus status = ResultStatus.OK;
		chromatogramFilterResult = new TestChromatogramFilterResult(status, "");
		assertEquals("ResultStatus", ResultStatus.OK, chromatogramFilterResult.getResultStatus());
	}

	public void testGetResultStatus_3() {

		ResultStatus status = ResultStatus.UNDEFINED;
		chromatogramFilterResult = new TestChromatogramFilterResult(status, "");
		assertEquals("ResultStatus", ResultStatus.UNDEFINED, chromatogramFilterResult.getResultStatus());
	}

	public void testGetDescription_3() {

		ResultStatus status = ResultStatus.UNDEFINED;
		chromatogramFilterResult = new TestChromatogramFilterResult(status, "My test description.");
		assertEquals("Description", "My test description.", chromatogramFilterResult.getDescription());
	}

	public void testGetDescription_4() {

		ResultStatus status = ResultStatus.UNDEFINED;
		chromatogramFilterResult = new TestChromatogramFilterResult(status, "");
		assertEquals("Description", "", chromatogramFilterResult.getDescription());
	}
}
