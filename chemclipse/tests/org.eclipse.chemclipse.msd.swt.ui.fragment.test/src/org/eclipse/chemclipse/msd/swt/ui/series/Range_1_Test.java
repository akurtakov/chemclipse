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
package org.eclipse.chemclipse.msd.swt.ui.series;

import org.eclipse.swtchart.Range;

import junit.framework.TestCase;

public class Range_1_Test extends TestCase {

	private Range range;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testRange_1() {

		range = new Range(0, 0);
		assertEquals("lower", 0.0d, range.lower);
	}

	public void testRange_2() {

		range = new Range(0, 0);
		assertEquals("upper", 0.0d, range.upper);
	}
}
