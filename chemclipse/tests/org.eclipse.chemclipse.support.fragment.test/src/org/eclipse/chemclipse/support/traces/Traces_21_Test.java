/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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

public class Traces_21_Test {

	private String content = "125 > 89.0 @17\n" + //
			"127 > 109.0 @10\n" + //
			"127 > 89.0 @17\n" + "";

	@Test
	public void test1() {

		List<ITrace> traces = new ArrayList<>();
		traces.addAll(TraceFactory.parseTraces(content, TraceTandemMSD.class));
		assertEquals(3, traces.size());
		assertEquals("125 > 89.0 @17", traces.get(0).toString());
		assertEquals("127 > 89.0 @17", traces.get(2).toString());
		String tracesConverted = TraceFactory.getTracesAsString(traces);
		assertEquals("125 > 89.0 @17,127 > 109.0 @10,127 > 89.0 @17", tracesConverted);
	}
}