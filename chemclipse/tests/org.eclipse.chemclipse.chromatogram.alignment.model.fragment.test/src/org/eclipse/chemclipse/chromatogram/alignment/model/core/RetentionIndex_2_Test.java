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

public class RetentionIndex_2_Test {

	@Test
	public void testRetentionTime_1() {

		RetentionIndex retentionIndex = new RetentionIndex();
		assertEquals(0, retentionIndex.getRetentionTime(), "RetentionTime");
		assertEquals(0.0f, retentionIndex.getIndex(), 0, "Index");
		assertEquals("", retentionIndex.getName(), "Name");
	}

	@Test
	public void testRetentionTime_2() {

		RetentionIndex retentionIndex = new RetentionIndex(7500, 8000.2f);
		assertEquals(7500, retentionIndex.getRetentionTime(), "RetentionTime");
		assertEquals(8000.2f, retentionIndex.getIndex(), 0, "Index");
		assertEquals("", retentionIndex.getName(), "Name");
	}

	@Test
	public void testRetentionTime_3() {

		RetentionIndex retentionIndex = new RetentionIndex(7500, 8000.2f, "C41");
		assertEquals(7500, retentionIndex.getRetentionTime(), "RetentionTime");
		assertEquals(8000.2f, retentionIndex.getIndex(), 0, "Index");
		assertEquals("C41", retentionIndex.getName(), "Name");
	}

	@Test
	public void testRetentionTime_4() {

		RetentionIndex retentionIndex = new RetentionIndex(-7500, -8000.2f, "C41");
		assertEquals(0, retentionIndex.getRetentionTime(), "RetentionTime");
		assertEquals(0.0f, retentionIndex.getIndex(), 0, "Index");
		assertEquals("C41", retentionIndex.getName(), "Name");
	}
}
