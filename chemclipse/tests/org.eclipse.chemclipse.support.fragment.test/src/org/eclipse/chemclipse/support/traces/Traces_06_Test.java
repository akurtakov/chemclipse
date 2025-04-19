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

import java.util.List;

public class Traces_06_Test extends TraceTestCase {

	public void test1a() {

		String content = "400.01627±10ppm\n417.028±5ppm";
		List<? extends ITrace> traces = TraceFactory.parseTraces(content, TraceType.MSD_HIGHRES.clazz());
		assertEquals(2, traces.size());
		assertEquals(400.01627d, ((TraceHighResMSD)traces.get(0)).getMZ());
		assertEquals(417.028d, ((TraceHighResMSD)traces.get(1)).getMZ());
	}

	public void test1b() {

		String content = "400.01627+-10ppm\n417.028+-5ppm";
		List<? extends ITrace> traces = TraceFactory.parseTraces(content, TraceType.MSD_HIGHRES.clazz());
		assertEquals(2, traces.size());
		assertEquals(400.01627d, ((TraceHighResMSD)traces.get(0)).getMZ());
		assertEquals(417.028d, ((TraceHighResMSD)traces.get(1)).getMZ());
	}

	public void test1c() {

		String content = "400.01627±0.02\n417.028±0.01";
		List<? extends ITrace> traces = TraceFactory.parseTraces(content, TraceType.MSD_HIGHRES.clazz());
		assertEquals(2, traces.size());
		assertEquals(400.01627d, ((TraceHighResMSD)traces.get(0)).getMZ());
		assertEquals(417.028d, ((TraceHighResMSD)traces.get(1)).getMZ());
	}

	public void test1d() {

		String content = "400.01627+-0.02\n417.028+-0.01";
		List<? extends ITrace> traces = TraceFactory.parseTraces(content, TraceType.MSD_HIGHRES.clazz());
		assertEquals(2, traces.size());
		assertEquals(400.01627d, ((TraceHighResMSD)traces.get(0)).getMZ());
		assertEquals(417.028d, ((TraceHighResMSD)traces.get(1)).getMZ());
	}

	public void test2c() {

		String content = "400.01627±0.02\n417.028±0.01";
		List<? extends ITrace> traces = TraceFactory.parseTraces(content, TraceType.WSD_HIGHRES.clazz());
		assertEquals(2, traces.size());
		assertEquals(400.01627d, ((TraceHighResWSD)traces.get(0)).getWavelength());
		assertEquals(417.028d, ((TraceHighResWSD)traces.get(1)).getWavelength());
	}

	public void test2d() {

		String content = "400.01627+-0.02\n417.028+-0.01";
		List<? extends ITrace> traces = TraceFactory.parseTraces(content, TraceType.WSD_HIGHRES.clazz());
		assertEquals(2, traces.size());
		assertEquals(400.01627d, ((TraceHighResWSD)traces.get(0)).getWavelength());
		assertEquals(417.028d, ((TraceHighResWSD)traces.get(1)).getWavelength());
	}
}