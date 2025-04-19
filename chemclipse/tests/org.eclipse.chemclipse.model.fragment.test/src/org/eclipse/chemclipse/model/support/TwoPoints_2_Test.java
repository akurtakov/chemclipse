/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.support;

import org.eclipse.chemclipse.numeric.core.IPoint;
import org.eclipse.chemclipse.numeric.core.Point;
import org.eclipse.chemclipse.numeric.exceptions.PointIsNullException;

import junit.framework.TestCase;

public class TwoPoints_2_Test extends TestCase {

	private IPoint p1;
	private IPoint p2;
	private ITwoPoints points;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testConstructor_1() {

		p1 = new Point(5.0d, 10.0d);
		p2 = new Point(7.0d, 3.0d);
		try {
			points = new TwoPoints(p1, p2);
		} catch(PointIsNullException e) {
			assertTrue("Constructor", false);
		}
		assertNotNull(points);
	}

	public void testConstructor_2() {

		p1 = null;
		p2 = new Point(7.0d, 3.0d);
		try {
			points = new TwoPoints(p1, p2);
		} catch(PointIsNullException e) {
			assertTrue("Constructor", true);
		}
	}

	public void testConstructor_3() {

		p1 = new Point(5.0d, 10.0d);
		p2 = null;
		try {
			points = new TwoPoints(p1, p2);
		} catch(PointIsNullException e) {
			assertTrue("Constructor", true);
		}
	}

	public void testConstructor_4() {

		p1 = null;
		p2 = null;
		try {
			points = new TwoPoints(p1, p2);
		} catch(PointIsNullException e) {
			assertTrue("Constructor", true);
		}
	}
}
