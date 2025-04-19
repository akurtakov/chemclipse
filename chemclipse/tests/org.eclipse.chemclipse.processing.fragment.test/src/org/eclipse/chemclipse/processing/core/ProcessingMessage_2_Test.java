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

public class ProcessingMessage_2_Test extends TestCase {

	private IProcessingMessage processingMessage;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		processingMessage = new ProcessingMessage(null, null, null);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testGetValues_1() {

		assertEquals(MessageType.ERROR, processingMessage.getMessageType());
	}

	public void testGetValues_2() {

		assertEquals("Description was null.", processingMessage.getDescription());
	}

	public void testGetValues_3() {

		assertEquals("Message was null.", processingMessage.getMessage());
	}
}
