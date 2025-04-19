/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.literature;

import junit.framework.TestCase;

public class LiteratureSupport_2_Test extends TestCase {

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void test1() {

		assertEquals("https://doi.org/10.1186/1471-2105-11-405", LiteratureSupport.getContainedLink("UR  - https://doi.org/10.1186/1471-2105-11-405\n"));
	}

	public void test2() {

		assertEquals("http://doi.org/10.1186/1471-2105-11-405", LiteratureSupport.getContainedLink("UR  - http://doi.org/10.1186/1471-2105-11-405\n"));
	}

	public void test3() {

		assertEquals("https://dx.doi.org/10.1002/ffj.3311", LiteratureSupport.getContainedLink("UR  - https://dx.doi.org/10.1002/ffj.3311\n"));
	}

	public void test4() {

		assertEquals("http://dx.doi.org/10.1002/ffj.3311", LiteratureSupport.getContainedLink("UR  - http://dx.doi.org/10.1002/ffj.3311\n"));
	}
}