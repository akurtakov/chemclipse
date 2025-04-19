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
package org.eclipse.chemclipse.model.history;

import java.util.Date;

import org.eclipse.chemclipse.support.history.EditInformation;
import org.eclipse.chemclipse.support.history.IEditInformation;

import junit.framework.TestCase;

public class EditInformation_1_Test extends TestCase {

	private IEditInformation editInformation;
	private Date date;
	private final String entry = "I have modified the chromatogram.";

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		date = new Date();
		editInformation = new EditInformation(date, entry);
	}

	@Override
	protected void tearDown() throws Exception {

		editInformation = null;
		super.tearDown();
	}

	public void testGetEditHistory_1() {

		long millisecondsEdit = editInformation.getDate().getTime();
		long millisecondsCheck = date.getTime();
		long delta = millisecondsCheck - millisecondsEdit;
		assertTrue("getDate", delta > -5 && delta < 5); // Sometimes the time deviates in the check by 1 ms
	}

	public void testGetEditHistory_2() {

		assertEquals("getDescription", entry, editInformation.getDescription());
	}
}
