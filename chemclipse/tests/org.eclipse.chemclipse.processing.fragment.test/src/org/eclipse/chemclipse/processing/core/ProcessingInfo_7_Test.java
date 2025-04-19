/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.processing.core;

import org.eclipse.chemclipse.processing.core.exceptions.TypeCastException;

import junit.framework.TestCase;

public class ProcessingInfo_7_Test extends TestCase {

	private IProcessingInfo<Object> processingInfo;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		processingInfo = new ProcessingInfo<>();
		processingInfo.setProcessingResult(null);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	@SuppressWarnings("deprecation")
	public void testProcessingInfo_1() {

		try {
			processingInfo.getProcessingResult(String.class);
		} catch(TypeCastException e) {
			assertTrue(true);
		}
	}

	@SuppressWarnings("deprecation")
	public void testProcessingInfo_2() {

		try {
			processingInfo.getProcessingResult(Integer.class);
		} catch(TypeCastException e) {
			assertTrue(true);
		}
	}
}
