/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.traces;

public class Trace_NominalMSD_00_Test extends TraceTestCase {

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	public void test1() {

		assertNull(TraceFactory.parseTrace("", TraceTandemMSD.class));
	}

	public void test2() {

		assertNull(TraceFactory.parseTrace("A", TraceTandemMSD.class));
	}

	public void test3() {

		assertNull(TraceFactory.parseTrace("0", TraceTandemMSD.class));
	}

	public void test4() {

		assertNull(TraceFactory.parseTrace("-1", TraceTandemMSD.class));
	}
}