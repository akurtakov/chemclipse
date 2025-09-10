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
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.eclipse.chemclipse.chromatogram.alignment.model.exceptions.NoRetentionIndexAvailableException;
import org.eclipse.chemclipse.chromatogram.alignment.model.exceptions.RetentionIndexExistsException;
import org.eclipse.chemclipse.chromatogram.alignment.model.exceptions.RetentionIndexValueException;
import org.junit.jupiter.api.Test;

public class RetentionIndices_1_Test {

	private RetentionIndices retentionIndices = new RetentionIndices();

	@Test
	public void testList_1() {

		assertThrows(NoRetentionIndexAvailableException.class, () -> {
			retentionIndices.getActualRetentionIndex();
		});
	}

	@Test
	public void testList_2() throws RetentionIndexExistsException, RetentionIndexValueException, NoRetentionIndexAvailableException {

		retentionIndices.addRetentionIndex(new RetentionIndex(5758, 1000.0f, "C41"));
		retentionIndices.addRetentionIndex(new RetentionIndex(5760, 2000.0f, "C42"));
		retentionIndices.addRetentionIndex(new RetentionIndex(5770, 3000.0f, "C43"));
		assertEquals("C43", retentionIndices.getActualRetentionIndex().getName());
		assertEquals("C42", retentionIndices.getPreviousRetentionIndex().getName());
		assertEquals("C41", retentionIndices.getPreviousRetentionIndex().getName());
		assertEquals("C42", retentionIndices.getNextRetentionIndex().getName());
		assertEquals("C43", retentionIndices.getNextRetentionIndex().getName());
	}

	@Test
	public void testList_3() throws RetentionIndexExistsException, RetentionIndexValueException, NoRetentionIndexAvailableException {

		retentionIndices.addRetentionIndex(new RetentionIndex(5758, 1000.0f, "C41"));
		retentionIndices.addRetentionIndex(new RetentionIndex(5760, 2000.0f, "C42"));
		retentionIndices.addRetentionIndex(new RetentionIndex(5770, 3000.0f, "C43"));
		assertEquals("C43", retentionIndices.getActualRetentionIndex().getName());
		assertEquals("C42", retentionIndices.getPreviousRetentionIndex().getName());
		assertEquals("C41", retentionIndices.getPreviousRetentionIndex().getName());
	}

	@Test
	public void testList_4() throws RetentionIndexExistsException, RetentionIndexValueException, NoRetentionIndexAvailableException {

		retentionIndices.addRetentionIndex(new RetentionIndex(5758, 1000.0f, "C41"));
		retentionIndices.addRetentionIndex(new RetentionIndex(5760, 2000.0f, "C42"));
		retentionIndices.addRetentionIndex(new RetentionIndex(5770, 3000.0f, "C43"));
	}

	@Test
	public void testList_5() throws RetentionIndexExistsException, RetentionIndexValueException, NoRetentionIndexAvailableException {

		retentionIndices.addRetentionIndex(new RetentionIndex(5770, 3000.0f, "C43"));
		retentionIndices.addRetentionIndex(new RetentionIndex(5758, 1000.0f, "C41"));
		retentionIndices.addRetentionIndex(new RetentionIndex(5760, 2000.0f, "C42"));
		assertEquals("C43", retentionIndices.getLastRetentionIndex().getName());
		assertEquals("C42", retentionIndices.getPreviousRetentionIndex().getName());
		assertEquals("C41", retentionIndices.getPreviousRetentionIndex().getName());
		assertEquals("C42", retentionIndices.getNextRetentionIndex().getName());
		assertEquals("C43", retentionIndices.getNextRetentionIndex().getName());
	}
}
