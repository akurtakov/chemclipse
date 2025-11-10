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
package org.eclipse.chemclipse.model.implementation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Chromatogram_2_Test {

	private Chromatogram chromatogram = new Chromatogram();

	@Test
	public void testChromatogram_1() {

		assertFalse(chromatogram.isUnloaded());
	}

	@Test
	public void testChromatogram_2() {

		chromatogram.setUnloaded();
		assertTrue(chromatogram.isUnloaded());
	}
}
