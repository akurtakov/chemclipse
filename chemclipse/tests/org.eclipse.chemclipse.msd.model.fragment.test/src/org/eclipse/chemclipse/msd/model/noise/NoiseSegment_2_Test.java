/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.noise;

import junit.framework.TestCase;

public class NoiseSegment_2_Test extends TestCase {

	private INoiseSegmentMSD noiseSegment;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		noiseSegment = new NoiseSegmentMSD(null, null);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testGetAnalysisSegment_1() {

		assertNull(noiseSegment.getAnalysisSegment());
	}

	public void testGetNoiseMassSpectrum_1() {

		assertNull(noiseSegment.getNoiseMassSpectrum());
	}
}