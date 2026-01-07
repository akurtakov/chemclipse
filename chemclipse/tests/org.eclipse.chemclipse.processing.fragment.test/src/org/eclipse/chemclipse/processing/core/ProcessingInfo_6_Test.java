/*******************************************************************************
 * Copyright (c) 2018, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Alexander Kerner - Generics
 *******************************************************************************/
package org.eclipse.chemclipse.processing.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ProcessingInfo_6_Test {

	private IProcessingInfo<String> processingInfo;

	@BeforeAll
	public void setUp() {

		processingInfo = new ProcessingInfo<>();
		String processingResult = "Hello World!";
		processingInfo.setProcessingResult(processingResult);
	}

	@Test
	public void testProcessingInfo_1() {

		String result = processingInfo.getProcessingResult();
		assertNotNull(result);
		assertEquals("Hello World!", result);
	}
}
