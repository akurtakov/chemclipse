/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.support;

import org.eclipse.chemclipse.model.implementation.Chromatogram;

import junit.framework.TestCase;

public class RetentionIndexMap_7_Test extends TestCase {

	private RetentionIndexMap retentionIndexMap = new RetentionIndexMap(new Chromatogram());

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void test1() {

		assertEquals(-1, retentionIndexMap.getRetentionTime(1000));
	}

	public void test2() {

		assertEquals(0.0f, retentionIndexMap.getRetentionIndex(1000));
	}

	public void test3() {

		assertTrue(retentionIndexMap.isEmpty());
	}

	public void test4() {

		assertEquals(-1, retentionIndexMap.getRetentionIndexStart());
	}

	public void test5() {

		assertEquals(-1, retentionIndexMap.getRetentionIndexStop());
	}
}