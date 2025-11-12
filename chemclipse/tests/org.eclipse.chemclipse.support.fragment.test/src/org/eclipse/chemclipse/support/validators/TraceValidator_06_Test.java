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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class TraceValidator_06_Test {

	private TraceValidator traceValidator = new TraceValidator();
	private String content = "18 - 45 - 200";

	private IStatus status;

	@BeforeAll
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
		assertEquals(29, traces.size(), 0);
		assertEquals(18, traces.get(0), 0);
		assertEquals(200, traces.get(28), 0);
	}

	@Test
	public void test03() {

		String traces = traceValidator.getTraces();
		assertEquals("18 - 45 - 200", traces);
	}

	@Test
	public void test04() {

		String traces = traceValidator.getLegacyTracesCondensed();
		assertEquals("18 - 45 200", traces);
	}
}