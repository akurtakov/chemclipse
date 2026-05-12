/*******************************************************************************
 * Copyright (c) 2019, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.pdfbox.extensions.elements;

import java.awt.Color;

import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.eclipse.chemclipse.pdfbox.extensions.settings.TextOption;

public class TextElement extends AbstractReferenceElement<TextElement> {

	private PDFont font = new PDType1Font(FontName.HELVETICA);
	private float fontSize = 12; // pt
	private Color color = Color.BLACK;
	private float minHeight = -1;
	private float maxWidth = Float.MAX_VALUE;
	private String text = "";
	private TextOption textOption = TextOption.NONE;

	public TextElement(float x, float y, float maxWidth) {

		setX(x);
		setY(y);
		this.maxWidth = maxWidth;
	}

	public PDFont getFont() {

		return font;
	}

	public TextElement setFont(PDFont font) {

		this.font = font;
		return this;
	}

	public float getFontSize() {

		return fontSize;
	}

	public TextElement setFontSize(float fontSize) {

		this.fontSize = fontSize;
		return this;
	}

	public Color getColor() {

		return color;
	}

	public TextElement setColor(Color color) {

		this.color = color;
		return this;
	}

	public float getMinHeight() {

		return minHeight;
	}

	public TextElement setMinHeight(float minHeight) {

		this.minHeight = minHeight;
		return this;
	}

	public float getMaxWidth() {

		return maxWidth;
	}

	public TextElement setMaxWidth(float maxWidth) {

		this.maxWidth = maxWidth;
		return this;
	}

	public String getText() {

		return text;
	}

	public TextElement setText(String text) {

		/*
		 * Tabs shall be eliminated.
		 * https://issues.apache.org/jira/browse/PDFBOX-3805
		 * java.lang.IllegalArgumentException: U+0009 ('controlHT') is not available in this font Helvetica encoding: WinAnsiEncoding
		 */
		if(text != null) {
			this.text = text.replace("\t", " ");
		} else {
			this.text = "";
		}
		return this;
	}

	public TextOption getTextOption() {

		return textOption;
	}

	public TextElement setTextOption(TextOption textOption) {

		this.textOption = textOption;
		return this;
	}
}
