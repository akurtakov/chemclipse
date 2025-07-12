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
package org.eclipse.chemclipse.model.support;

import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.implementation.Peak;

import junit.framework.TestCase;

public class PeakClassifierSupport_1_Test extends TestCase {

	private IPeak peak = new Peak();

	public void test1() {

		assertEquals("", PeakClassifierSupport.getClassifier(peak));
	}

	public void test2() {

		peak.addClassifier("Validated");
		assertEquals("Validated", PeakClassifierSupport.getClassifier(peak));
	}

	public void test3() {

		peak.addClassifier("Validated");
		peak.addClassifier("OK");
		assertEquals("OK | Validated", PeakClassifierSupport.getClassifier(peak));
	}

	public void test4() {

		peak.addClassifier("Validated");
		peak.addClassifier("OK");
		PeakClassifierSupport.setClassifier(null, null);
		assertEquals("OK | Validated", PeakClassifierSupport.getClassifier(peak));
	}

	public void test5() {

		peak.addClassifier("Validated");
		peak.addClassifier("OK");
		PeakClassifierSupport.setClassifier(peak, null);
		assertEquals("OK | Validated", PeakClassifierSupport.getClassifier(peak));
	}

	public void test6() {

		peak.addClassifier("Validated");
		peak.addClassifier("OK");
		PeakClassifierSupport.setClassifier(peak, "");
		assertEquals("", PeakClassifierSupport.getClassifier(peak));
	}

	public void test7() {

		peak.addClassifier("Validated");
		peak.addClassifier("OK");
		PeakClassifierSupport.setClassifier(peak, "  ");
		assertEquals("", PeakClassifierSupport.getClassifier(peak));
	}

	public void test8() {

		peak.addClassifier("Validated");
		peak.addClassifier("OK");
		PeakClassifierSupport.setClassifier(peak, "OK | Validated | Tested");
		assertEquals("OK | Tested | Validated", PeakClassifierSupport.getClassifier(peak));
	}
}