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
package org.eclipse.chemclipse.progress.core;

import junit.framework.TestCase;

public class InfoType_1_Test extends TestCase {

	private InfoType infoType;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testInfoType_1() {

		infoType = InfoType.MESSAGE;
		assertEquals("MESSAGE", InfoType.MESSAGE, infoType);
	}

	public void testInfoType_2() {

		infoType = InfoType.ERROR_MESSAGE;
		assertEquals("ERROR_MESSAGE", InfoType.ERROR_MESSAGE, infoType);
	}
}
