/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.validators;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.junit.Before;
import org.junit.Test;

public class TraceValidator_05_Test {

	private TraceValidator traceValidator = new TraceValidator();
	private String content = "18 28 32 55 56 57 58 59 60 61 62 63 64 65 84 205 206 207";

	private IStatus status;

	@Before
	public void setup() {

		status = traceValidator.validate(content);
	}

	@Test
	public void test01() {

		assertEquals(IStatus.OK, status.getCode());
	}

	@Test
	public void test02() {

		List<Integer> traces = traceValidator.getTracesAsInteger();
		assertEquals(18, traces.size(), 0);
		assertEquals(18, traces.get(0), 0);
		assertEquals(207, traces.get(17), 0);
	}

	@Test
	public void test03() {

		String traces = traceValidator.getTraces();
		assertEquals("18 28 32 55 56 57 58 59 60 61 62 63 64 65 84 205 206 207", traces);
	}

	@Test
	public void test04() {

		String traces = traceValidator.getLegacyTracesCondensed();
		assertEquals("18 28 32 55 - 65 84 205 - 207", traces);
	}
}