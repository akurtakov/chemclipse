/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model;

import junit.framework.TestCase;

public class TargetTrace_1_Test extends TestCase {

	private TargetTrace targetTrace;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testCreateWNCIon_1() {

		String name = "Water";
		int ion = 18;
		targetTrace = new TargetTrace(ion, name);
		assertEquals(ion, targetTrace.getIon());
		assertEquals(name, targetTrace.getName());
	}

	public void testCreateWNCIon_2() {

		String name = "Nitrogen";
		int ion = 28;
		targetTrace = new TargetTrace(ion, name);
		assertEquals(ion, targetTrace.getIon());
		assertEquals(name, targetTrace.getName());
	}

	public void testCreateWNCIon_3() {

		String name = "Nitro;gen";
		int ion = 28;
		targetTrace = new TargetTrace(ion, name);
		assertEquals(ion, targetTrace.getIon());
		assertEquals("Nitrogen", targetTrace.getName());
	}

	public void testCreateWNCIon_4() {

		String name = "Nitro:gen";
		int ion = 28;
		targetTrace = new TargetTrace(ion, name);
		assertEquals(ion, targetTrace.getIon());
		assertEquals("Nitrogen", targetTrace.getName());
	}

	public void testCreateWNCIon_5() {

		String name = "    Ni;tro:gen";
		int ion = 28;
		targetTrace = new TargetTrace(ion, name);
		assertEquals(ion, targetTrace.getIon());
		assertEquals("Nitrogen", targetTrace.getName());
	}

	public void testCreateWNCIon_6() {

		String name = "    Ni;tro:  gen    ";
		int ion = 28;
		targetTrace = new TargetTrace(ion, name);
		assertEquals(ion, targetTrace.getIon());
		assertEquals("Nitro  gen", targetTrace.getName());
	}
}