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
package org.eclipse.chemclipse.xxd.model.quantitation;

import org.eclipse.chemclipse.model.quantitation.ResponseSignal;
import org.eclipse.chemclipse.model.quantitation.IResponseSignal;

import junit.framework.TestCase;

public class ConcentrationResponseEntry_1_Test extends TestCase {

	private IResponseSignal concentrationResponseEntry;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		concentrationResponseEntry = new ResponseSignal(76.2d, 0.7d, 47875);
	}

	@Override
	protected void tearDown() throws Exception {

		concentrationResponseEntry = null;
		super.tearDown();
	}

	public void testGetIon_1() {

		assertEquals(76.2d, concentrationResponseEntry.getSignal());
	}

	public void testGetConcenctration_1() {

		assertEquals(0.7d, concentrationResponseEntry.getConcentration());
	}

	public void testGetResponse_1() {

		assertEquals(47875.0d, concentrationResponseEntry.getResponse());
	}
}
