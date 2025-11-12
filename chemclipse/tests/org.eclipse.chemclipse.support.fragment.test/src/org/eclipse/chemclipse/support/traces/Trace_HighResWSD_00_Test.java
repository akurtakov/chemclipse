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

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Trace_HighResWSD_00_Test {

	@Test
	public void test1() {

		assertNull(TraceFactory.parseTrace("", TraceHighResWSD.class));
	}

	@Test
	public void test2() {

		assertNull(TraceFactory.parseTrace("A", TraceHighResWSD.class));
	}

	@Test
	public void test3() {

		assertNull(TraceFactory.parseTrace("0", TraceHighResWSD.class));
	}

	@Test
	public void test4() {

		assertNull(TraceFactory.parseTrace("-1", TraceHighResWSD.class));
	}
}