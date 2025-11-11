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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Traces_18_Test {

	private String content = "400.01627±0.05, 417.028±0.08";

	@Test
	public void test1() {

		List<? extends ITrace> traces = TraceFactory.parseTraces(content, TraceType.GENERIC.clazz());
		assertEquals(2, traces.size());
		assertEquals(400.01627d, traces.get(0).getValue(), 0);
		assertEquals(417.028d, traces.get(1).getValue(), 0);
	}

	@Test
	public void test2() {

		List<? extends ITrace> traces = TraceFactory.parseTraces(content, TraceType.MSD_NOMINAL.clazz());
		assertTrue(traces.isEmpty());
	}

	@Test
	public void test3() {

		List<? extends ITrace> traces = TraceFactory.parseTraces(content, TraceType.MSD_TANDEM.clazz());
		assertTrue(traces.isEmpty());
	}

	@Test
	public void test4() {

		List<? extends ITrace> traces = TraceFactory.parseTraces(content, TraceType.MSD_HIGHRES.clazz());
		assertEquals(2, traces.size());
		assertEquals(400.01627d, ((TraceHighResMSD)traces.get(0)).getMZ(), 0);
		assertEquals(417.028d, ((TraceHighResMSD)traces.get(1)).getMZ(), 0);
	}

	@Test
	public void test5() {

		List<? extends ITrace> traces = TraceFactory.parseTraces(content, TraceType.VSD_RASTERED.clazz());
		assertTrue(traces.isEmpty());
	}

	@Test
	public void test6() {

		List<? extends ITrace> traces = TraceFactory.parseTraces(content, TraceType.WSD_RASTERED.clazz());
		assertTrue(traces.isEmpty());
	}

	@Test
	public void test7() {

		List<? extends ITrace> traces = TraceFactory.parseTraces(content, TraceType.WSD_HIGHRES.clazz());
		assertFalse(traces.isEmpty());
	}
}