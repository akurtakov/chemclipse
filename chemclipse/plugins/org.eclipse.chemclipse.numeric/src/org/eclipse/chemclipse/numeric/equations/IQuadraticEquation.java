/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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

public interface IQuadraticEquation extends IEquation {

	/*
	 * Quadratic Term
	 */
	double getA();

	/*
	 * Linear Term
	 */
	double getB();

	/*
	 * Constant Term
	 */
	double getC();

	double getApexValueForX(Apex result);
}