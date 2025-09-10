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
package org.eclipse.chemclipse.chromatogram.alignment.model.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RetentionIndex_1_Test {

	private RetentionIndex retentionIndex = new RetentionIndex();

	@Test
	public void testRetentionTime_1() {

		retentionIndex.setRetentionTime(7503);
		assertEquals(7503, retentionIndex.getRetentionTime(), "RetentionTime");
	}

	@Test
	public void testRetentionTime_2() {

		retentionIndex.setRetentionTime(0);
		assertEquals(0, retentionIndex.getRetentionTime(), "RetentionTime");
	}

	@Test
	public void testRetentionTime_3() {

		retentionIndex.setRetentionTime(-1);
		assertEquals(0, retentionIndex.getRetentionTime(), "RetentionTime");
	}

	@Test
	public void testRetentionTime_4() {

		retentionIndex.setRetentionTime(Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE, retentionIndex.getRetentionTime(), "RetentionTime");
	}

	@Test
	public void testRetentionTime_5() {

		retentionIndex.setRetentionTime(Integer.MIN_VALUE);
		assertEquals(0, retentionIndex.getRetentionTime(), "RetentionTime");
	}

	@Test
	public void testIndex_1() {

		retentionIndex.setIndex(5000.4f);
		assertEquals(5000.4f, retentionIndex.getIndex(), 0, "Index");
	}

	@Test
	public void testIndex_2() {

		retentionIndex.setIndex(0.0f);
		assertEquals(0.0f, retentionIndex.getIndex(), 0, "Index");
	}

	@Test
	public void testIndex_3() {

		retentionIndex.setIndex(-1.0f);
		assertEquals(0.0f, retentionIndex.getIndex(), 0, "Index");
	}

	@Test
	public void testIndex_4() {

		retentionIndex.setIndex(Float.MAX_VALUE);
		assertEquals(Float.MAX_VALUE, retentionIndex.getIndex(), 0, "Index");
	}

	@Test
	public void testIndex_5() {

		retentionIndex.setIndex(Float.MIN_VALUE);
		assertEquals(Float.MIN_VALUE, retentionIndex.getIndex(), 0, "Index");
	}

	@Test
	public void testIndex_6() {

		retentionIndex.setIndex(Float.NaN);
		assertEquals(0.0f, retentionIndex.getIndex(), 0, "Index");
	}

	@Test
	public void testName_1() {

		retentionIndex.setName("C41");
		assertEquals("C41", retentionIndex.getName(), "Name");
	}

	@Test
	public void testName_2() {

		retentionIndex.setName("");
		assertEquals("", retentionIndex.getName(), "Name");
	}
}
