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
package org.eclipse.chemclipse.msd.model.xic;

import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;

/**
 * HashCode and equals test. extractedIonSignal1 = new ExtractedIonSignal(1,
 * 15); extractedIonSignal2 = new ExtractedIonSignal(1, 20);
 * 
 * @author Philip Wenig
 */
public class ExtractedIonSignal_3_Test extends TestCase {

	private IExtractedIonSignal extractedIonSignal1;
	private IExtractedIonSignal extractedIonSignal2;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		extractedIonSignal1 = new ExtractedIonSignal(1, 15);
		extractedIonSignal2 = new ExtractedIonSignal(1, 20);
	}

	@Override
	protected void tearDown() throws Exception {

		extractedIonSignal1 = null;
		extractedIonSignal2 = null;
		super.tearDown();
	}

	public void testEquals_1() {

		assertNotEquals("equals", extractedIonSignal1, extractedIonSignal2);
	}

	public void testEquals_2() {

		assertNotEquals("equals", extractedIonSignal2, extractedIonSignal1);
	}

	public void testEquals_3() {

		assertEquals("equals", extractedIonSignal1, extractedIonSignal1);
	}

	public void testEquals_4() {

		assertEquals("equals", extractedIonSignal2, extractedIonSignal2);
	}

	public void testEquals_5() {

		assertNotNull("equals", extractedIonSignal1);
	}

	public void testEquals_6() {

		assertNotNull("equals", extractedIonSignal2);
	}

	public void testEquals_7() {

		assertNotEquals("equals", extractedIonSignal1, new Object());
	}

	public void testEquals_8() {

		assertNotEquals("equals", extractedIonSignal2, new Object());
	}

	public void testHashCode_1() {

		assertNotEquals("hashCode", extractedIonSignal1.hashCode(), extractedIonSignal2.hashCode());
	}

	public void testHashCode_2() {

		assertNotEquals("hashCode", extractedIonSignal2.hashCode(), extractedIonSignal1.hashCode());
	}
}
