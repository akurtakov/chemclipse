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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Traces_19_Test {

	private String content = "400.01627±0.05, 417.028±0.08";

	@Test
	public void test1() {

		List<ITrace> traces = new ArrayList<>();
		traces.addAll(TraceFactory.parseTraces(content, TraceGenericDelta.class));
		assertEquals(2, traces.size());
		assertEquals(400.01627d, traces.get(0).getValue(), 0);
		assertEquals(417.028d, traces.get(1).getValue(), 0);
		String tracesConverted = TraceFactory.getTracesAsString(traces);
		assertEquals("400.01627±0.05,417.028±0.08", tracesConverted);
	}
}