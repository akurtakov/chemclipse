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
package org.eclipse.chemclipse.msd.model.implementation;

import org.eclipse.chemclipse.model.core.IIntegrationEntry;
import org.eclipse.chemclipse.model.core.ISignal;
import org.eclipse.chemclipse.model.implementation.IntegrationEntry;

import junit.framework.TestCase;

public class IntegrationEntry_1_Test extends TestCase {

	private IIntegrationEntry integrationEntry;

	@Override
	protected void setUp() throws Exception {

		integrationEntry = new IntegrationEntry(ISignal.TOTAL_INTENSITY, 2308934.78d);
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testGetIon_1() {

		assertEquals(ISignal.TOTAL_INTENSITY, integrationEntry.getSignal());
	}

	public void testGetIntegratedArea_1() {

		assertEquals(2308934.78d, integrationEntry.getIntegratedArea());
	}
}
