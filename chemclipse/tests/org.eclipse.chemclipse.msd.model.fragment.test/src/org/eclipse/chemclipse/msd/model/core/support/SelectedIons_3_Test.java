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
package org.eclipse.chemclipse.msd.model.core.support;

import org.eclipse.chemclipse.model.core.MarkedTraceModus;
import org.eclipse.chemclipse.msd.model.core.AbstractIon;
import org.eclipse.chemclipse.msd.model.core.IIon;

import junit.framework.TestCase;

public class SelectedIons_3_Test extends TestCase {

	private IMarkedIons selectedIons;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		selectedIons = new MarkedIons(MarkedTraceModus.INCLUDE);
	}

	@Override
	protected void tearDown() throws Exception {

		selectedIons = null;
		super.tearDown();
	}

	public void testContains_1() {

		selectedIons.add(new MarkedIon((int)IIon.TIC_ION));
		assertTrue("contains", selectedIons.getIonsNominal().contains(0));
	}

	public void testContains_2() {

		selectedIons.add(new MarkedIon((int)IIon.TIC_ION));
		assertTrue("contains", selectedIons.getIonsNominal().contains(AbstractIon.getIon(0.0f)));
	}
}
