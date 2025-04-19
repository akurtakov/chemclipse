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
import org.eclipse.chemclipse.msd.model.core.IIonTransitionGroup;

import junit.framework.TestCase;

public class IonTransitionGroup_1_Test extends TestCase {

	private IIonTransitionGroup ionTransitionGroup;
	private IIonTransition ionTransition;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		ionTransitionGroup = new IonTransitionGroup();
		ionTransition = new IonTransition(120.2d, 121.3d, 88.5d, 87.4d, 7.0d, 1.2, 1.3, 1);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testGet_1() {

		assertEquals(0, ionTransitionGroup.size());
	}

	public void testGet_2() {

		assertNull(ionTransitionGroup.get(0));
	}

	public void testGet_3() {

		assertNull(ionTransitionGroup.get(ionTransition));
	}

	public void testGet_4() {

		assertFalse(ionTransitionGroup.contains(ionTransition));
	}

	public void testGet_5() {

		assertNotNull(ionTransitionGroup.getIonTransitions());
	}
}
