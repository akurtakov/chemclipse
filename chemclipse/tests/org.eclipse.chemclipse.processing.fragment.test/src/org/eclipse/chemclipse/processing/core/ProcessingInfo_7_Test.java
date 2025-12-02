/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.processing.core;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.eclipse.chemclipse.processing.core.exceptions.TypeCastException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ProcessingInfo_7_Test {

	private IProcessingInfo<Object> processingInfo;

	@BeforeAll
	public void setUp() {

		processingInfo = new ProcessingInfo<>();
		processingInfo.setProcessingResult(null);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testProcessingInfo_1() {

		assertThrows(TypeCastException.class, () -> processingInfo.getProcessingResult(String.class));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testProcessingInfo_2() {

		assertThrows(TypeCastException.class, () -> processingInfo.getProcessingResult(Integer.class));
	}
}
