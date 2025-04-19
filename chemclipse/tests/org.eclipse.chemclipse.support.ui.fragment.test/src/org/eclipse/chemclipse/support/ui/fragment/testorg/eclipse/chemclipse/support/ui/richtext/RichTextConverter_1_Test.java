/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.fragment.testorg.eclipse.chemclipse.support.ui.richtext;

import org.eclipse.chemclipse.support.ui.richtext.RichTextConverter;
import org.junit.Ignore;

import junit.framework.TestCase;

@Ignore
public class RichTextConverter_1_Test extends TestCase {

	private static final String TEST = "Hello World!";

	public void test1() {

		assertEquals("", RichTextConverter.convertRtfToHtml(null, false));
	}

	public void test2() {

		assertEquals("", RichTextConverter.convertRtfToHtml("", false));
	}

	public void test3() {

		assertEquals(TEST, RichTextConverter.convertRtfToHtml(TEST, true));
	}

	public void test4() {

		assertEquals(TEST, RichTextConverter.convertRtfToHtml(TEST, false));
	}

	public void test5() {

		assertEquals("<p><span style=\"color: #000000\">Hello World!</span></p>", RichTextConverter.convertRtfToHtml(getRichText(), true));
	}

	public void test6() {

		assertEquals("<html><head><style><!----></style></head><body><p><span style=\"color: #000000\">Hello World!</span></p></body></html>", RichTextConverter.convertRtfToHtml(getRichText(), false));
	}

	private String getRichText() {

		return "{\\rtf1\\ansi\\deff3\\adeflang1025{Hello World!}\\par}";
	}
}