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

import junit.framework.TestCase;

public class ProcessingMessage_3_Test extends TestCase {

	private IProcessingMessage processingMessage;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testGetMessageType_1() {

		processingMessage = new ProcessingMessage(MessageType.ERROR, "Load Peaks", "Peak x2 couldn't be loaded.");
		assertEquals(MessageType.ERROR, processingMessage.getMessageType());
	}

	public void testGetMessageType_2() {

		processingMessage = new ProcessingMessage(MessageType.WARN, "Load Peaks", "Peak x2 was parsed incompletely.");
		assertEquals(MessageType.WARN, processingMessage.getMessageType());
	}

	public void testGetMessageType_3() {

		processingMessage = new ProcessingMessage(MessageType.INFO, "Load Peaks", "Peak x2 was loaded successfully.");
		assertEquals(MessageType.INFO, processingMessage.getMessageType());
	}
}
