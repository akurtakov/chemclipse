/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.numeric.equations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class QuadraticEquations_1_Test {

	private QuadraticEquation equation;

	@BeforeAll
	public void setUp() {

		equation = new QuadraticEquation(0.0d, 310206.81754652766d, 206670.62686893356d);
	}

	@Test
	public void testCreateLinearEquation_1() {

		/*
		 * A == 0
		 */
		double result = equation.calculateX(4192434.278134346d);
		assertEquals(12.848730027242523d, result, 0);
	}
}