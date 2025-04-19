/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.xic;

import junit.framework.TestCase;

public class ExtractedIonSignal_7_Test extends TestCase {

	private IExtractedIonSignal extractedIonSignal;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testSize_1() {

		extractedIonSignal = new ExtractedIonSignal(22, 28);
		extractedIonSignal.setAbundance(22, 389.2f);
		extractedIonSignal.setAbundance(23, 298.6f);
		extractedIonSignal.setAbundance(24, 128.2f);
		extractedIonSignal.setAbundance(25, 192.1f);
		extractedIonSignal.setAbundance(26, 2788.89f);
		extractedIonSignal.setAbundance(27, 829.1f);
		extractedIonSignal.setAbundance(28, 568.89f);
		//
		assertEquals(26, extractedIonSignal.getIonMaxIntensity());
		assertEquals(742.14f, extractedIonSignal.getMeanIntensity());
	}

	public void testSize_2() {

		extractedIonSignal = new ExtractedIonSignal(22, 28);
		extractedIonSignal.setAbundance(22, 389.2f);
		extractedIonSignal.setAbundance(23, 298.6f);
		extractedIonSignal.setAbundance(24, 235.2f);
		extractedIonSignal.setAbundance(25, 2788.89f);
		extractedIonSignal.setAbundance(26, 2788.89f);
		extractedIonSignal.setAbundance(27, 829.1f);
		extractedIonSignal.setAbundance(28, 568.89f);
		//
		assertEquals(25, extractedIonSignal.getIonMaxIntensity());
		assertEquals(1128.3958f, extractedIonSignal.getMeanIntensity());
	}

	public void testSize_3() {

		extractedIonSignal = new ExtractedIonSignal(22, 28);
		//
		assertEquals(0, extractedIonSignal.getIonMaxIntensity());
		assertEquals(0.0f, extractedIonSignal.getMeanIntensity());
	}
}
