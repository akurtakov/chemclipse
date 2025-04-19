/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.columns;

import junit.framework.TestCase;

public class SeparationColumnFactory_1_Test extends TestCase {

	public void test1() {

		assertEquals("DEFAULT", SeparationColumnFactory.getSeparationColumnType(null).name());
	}

	public void test2() {

		assertEquals("DEFAULT", SeparationColumnFactory.getSeparationColumnType("").name());
	}

	public void test3() {

		assertEquals("POLAR", SeparationColumnFactory.getSeparationColumnType("POLAR").name());
	}

	public void test4() {

		assertEquals("SEMI_POLAR", SeparationColumnFactory.getSeparationColumnType("SEMI_POLAR").name());
	}

	public void test5() {

		assertEquals("SEMI_POLAR", SeparationColumnFactory.getSeparationColumnType("SEMIPOLAR").name());
	}

	public void test6() {

		assertEquals("NON_POLAR", SeparationColumnFactory.getSeparationColumnType("NON_POLAR").name());
	}

	public void test7() {

		assertEquals("NON_POLAR", SeparationColumnFactory.getSeparationColumnType("APOLAR").name());
	}
}