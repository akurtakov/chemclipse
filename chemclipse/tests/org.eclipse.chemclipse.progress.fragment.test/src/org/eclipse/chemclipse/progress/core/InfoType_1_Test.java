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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InfoType_1_Test {

	@Test
	public void testInfoType_1() {

		InfoType infoType = InfoType.MESSAGE;
		assertEquals(InfoType.MESSAGE, infoType);
	}

	@Test
	public void testInfoType_2() {

		InfoType infoType = InfoType.ERROR_MESSAGE;
		assertEquals(InfoType.ERROR_MESSAGE, infoType);
	}
}
