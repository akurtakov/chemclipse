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
package org.eclipse.chemclipse.support.traces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TraceFactory_04_Test {

	@Test
	public void test01() {

		List<ITrace> traces = new ArrayList<>();
		assertEquals("", TraceFactory.getTracesAsString(traces));
	}

	@Test
	public void test02() {

		List<ITrace> traces = new ArrayList<>();
		traces.add(TraceFactory.parseTrace("400.01627±10ppm (x4.7)", TraceHighResMSD.class));
		assertEquals("400.01627±10ppm (x4.7)", TraceFactory.getTracesAsString(traces));
	}

	@Test
	public void test03() {

		List<ITrace> traces = new ArrayList<>();
		traces.add(TraceFactory.parseTrace("400.01627±10ppm (x4.7)", TraceHighResMSD.class));
		traces.add(TraceFactory.parseTrace("405.08737±10ppm", TraceHighResMSD.class));
		assertEquals("400.01627±10ppm (x4.7),405.08737±10ppm", TraceFactory.getTracesAsString(traces));
	}

	@Test
	public void test04() {

		List<ITrace> traces = new ArrayList<>();
		traces.add(TraceFactory.parseTrace("400.01627±10ppm (x4.7)", TraceHighResMSD.class));
		traces.add(TraceFactory.parseTrace("405.08737±10ppm", TraceHighResMSD.class));
		traces.add(TraceFactory.parseTrace("410.82763+-0.02", TraceHighResMSD.class));
		assertEquals("400.01627±10ppm (x4.7),405.08737±10ppm,410.82763±49ppm", TraceFactory.getTracesAsString(traces));
	}
}