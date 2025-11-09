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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.eclipse.chemclipse.support.history.EditInformation;
import org.eclipse.chemclipse.support.history.IEditInformation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class EditInformation_4_Test {

	private IEditInformation editInformation;
	private Date date = new Date();

	@BeforeAll
	public void setUp() {

		editInformation = new EditInformation(date, null);
	}

	@Test
	public void testGetEditHistory_1() {

		long millisecondsEdit = editInformation.getDate().getTime();
		long millisecondsCheck = date.getTime();
		assertEquals(millisecondsCheck, millisecondsEdit, 5); // Sometimes the time deviates in the check by 1 ms
	}

	@Test
	public void testGetEditHistory_2() {

		assertEquals(EditInformation.NO_DESCRIPTION, editInformation.getDescription());
	}
}
