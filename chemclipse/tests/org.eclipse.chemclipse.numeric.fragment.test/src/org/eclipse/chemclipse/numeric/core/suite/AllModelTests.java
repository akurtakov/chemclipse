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
package org.eclipse.chemclipse.numeric.core.suite;

import org.eclipse.chemclipse.numeric.geometry.Slope_1_Test;
import junit.framework.TestSuite;

public class AllModelTests {

	public static TestSuite suite() {

		TestSuite suite = new TestSuite();
		suite.addTestSuite(Slope_1_Test.class);
		// add more TestCases here
		return suite;
	}
}
