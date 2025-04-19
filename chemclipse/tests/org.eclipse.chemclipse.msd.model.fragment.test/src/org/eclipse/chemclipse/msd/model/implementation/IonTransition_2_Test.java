/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.implementation;

import org.eclipse.chemclipse.msd.model.core.IIonTransition;

import junit.framework.TestCase;

public class IonTransition_2_Test extends TestCase {

	private IIonTransition ionTransition1;
	private IIonTransition ionTransition2;
	private IIonTransition ionTransition3;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		ionTransition1 = new IonTransition(120.2d, 121.3d, 88.5d, 87.4d, 7.0d, 1.2, 1.3, 1);
		ionTransition2 = new IonTransition(120.2d, 121.3d, 88.5d, 87.4d, 7.0d, 1.2, 1.3, 1);
		ionTransition3 = new IonTransition(120.2d, 122.3d, 88.5d, 87.4d, 7.0d, 1.2, 1.3, 1);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testEquals_1() {

		assertTrue(ionTransition1.equals(ionTransition2));
	}

	public void testEquals_2() {

		assertTrue(ionTransition2.equals(ionTransition1));
	}

	public void testEquals_3() {

		assertFalse(ionTransition1.equals(ionTransition3));
	}

	public void testEquals_4() {

		assertFalse(ionTransition3.equals(ionTransition1));
	}
}
