/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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

import junit.framework.TestCase;

public class ProcessingInfo_5_Test extends TestCase {

	private IProcessingInfo<String> processingInfo;
	private IProcessingMessage processingMessage;
	private String processingResult;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		processingInfo = new ProcessingInfo<>();
		processingResult = "Hello World!";
		processingInfo.setProcessingResult(processingResult);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testProcessingInfo_1() {

		assertFalse(processingInfo.hasWarnMessages());
	}

	public void testProcessingInfo_2() {

		processingMessage = new ProcessingMessage(MessageType.WARN, "Load Peak", "The peak X35P couldn't be loaded completely.");
		processingInfo.addMessage(processingMessage);
		assertTrue(processingInfo.hasWarnMessages());
	}
}
