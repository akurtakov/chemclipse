/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ProcessingInfo_4_Test {

	private IProcessingInfo<String> processingInfo;
	private IProcessingMessage processingMessage;
	private String processingResult;

	@BeforeAll
	public void setUp() {

		processingInfo = new ProcessingInfo<>();
		processingResult = "Hello World!";
		processingInfo.setProcessingResult(processingResult);

		processingMessage = new ProcessingMessage(MessageType.WARN, "Load Peak", "The peak X35P couldn't be loaded completely.");
		processingInfo.addMessage(processingMessage);

		processingMessage = new ProcessingMessage(MessageType.INFO, "Calculate Abundance", "The abundance was calculated correctly.");
		processingInfo.addMessage(processingMessage);
	}

	@Test
	public void testProcessingInfo_1() {

		assertFalse(processingInfo.hasErrorMessages());
		processingMessage = new ProcessingMessage(MessageType.ERROR, "Load Peak", "The peak X35P couldn't be loaded, cause it seems to have no values.");
		processingInfo.addMessage(processingMessage);
	}

	@Test
	public void testProcessingInfo_2() {

		processingMessage = new ProcessingMessage(MessageType.ERROR, "Load Peak", "The peak X35P couldn't be loaded, cause it seems to have no values.");
		processingInfo.addMessage(processingMessage);
		assertTrue(processingInfo.hasErrorMessages());
	}
}
