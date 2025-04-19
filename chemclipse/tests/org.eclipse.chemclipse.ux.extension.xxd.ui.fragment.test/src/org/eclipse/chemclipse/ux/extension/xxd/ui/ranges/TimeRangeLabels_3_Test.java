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
package org.eclipse.chemclipse.ux.extension.xxd.ui.ranges;

import junit.framework.TestCase;

public class TimeRangeLabels_3_Test extends TestCase {

	private TimeRangeLabels timeRangeLabels;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		timeRangeLabels = new TimeRangeLabels("Some Range", "Test|Value");
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void test1() {

		assertEquals("Some Range", timeRangeLabels.getTitle());
	}

	public void test2() {

		assertEquals("TestValue", timeRangeLabels.getInitialValue());
	}

	public void test3() {

		assertEquals("Add a new Some Range.", timeRangeLabels.getAddMessage());
	}

	public void test4() {

		assertEquals("Please define a new Some Range.", timeRangeLabels.getAddError());
	}

	public void test5() {

		assertEquals("The Some Range exists already.", timeRangeLabels.getAddExists());
	}

	public void test6() {

		assertEquals("Create a new Some Range.", timeRangeLabels.getCreateMessage());
	}

	public void test7() {

		assertEquals("TestValue | 10.2 | 10.4 | 10.6", timeRangeLabels.getCreateInitialValue());
	}

	public void test8() {

		assertEquals("Edit the selected Some Range.", timeRangeLabels.getEditMessage());
	}

	public void test9() {

		assertEquals("Would you like to delete the selected Some Range?", timeRangeLabels.getDeleteMessage());
	}

	public void test10() {

		assertEquals("Would you like to delete the all Some Ranges?", timeRangeLabels.getClearMessage());
	}

	public void test11() {

		assertEquals("The Some Range must not contain the following delimiter '|'.", timeRangeLabels.getErrorDelimiter());
	}

	public void test12() {

		assertEquals(1, timeRangeLabels.getProposals().length);
	}

	public void test13() {

		assertEquals("TestValue", timeRangeLabels.getProposals()[0]);
	}
}