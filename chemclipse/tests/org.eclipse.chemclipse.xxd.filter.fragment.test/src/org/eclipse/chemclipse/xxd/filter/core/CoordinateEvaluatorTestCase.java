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
package org.eclipse.chemclipse.xxd.filter.core;

import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.implementation.Scan;
import org.eclipse.chemclipse.xxd.filter.model.CoordinateOption;
import org.eclipse.chemclipse.xxd.filter.model.RangeOption;

import junit.framework.TestCase;

public class CoordinateEvaluatorTestCase extends TestCase {

	public void test1() {

		assertFalse(CoordinateEvaluator.isMatchScan(null, CoordinateOption.NONE, RangeOption.NONE, 0));
	}

	public void test2() {

		IScan scan = createScan(0, 0);
		assertFalse(CoordinateEvaluator.isMatchScan(scan, CoordinateOption.NONE, RangeOption.NONE, 0));
	}

	protected IScan createScan(int retentionTime, float retentionIndex) {

		IScan scan = new Scan(1000);
		scan.setRetentionTime(retentionTime);
		scan.setRetentionIndex(retentionIndex);

		return scan;
	}

}