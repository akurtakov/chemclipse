/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.pdfbox.extensions.core.PDTable;

public class TableElement extends AbstractElement<TableElement> {

	private Color colorTitle = Color.GRAY;
	private Color colorData = Color.LIGHT_GRAY;
	private float columnHeight = 1.0f;
	private float textOffsetX = 0.0f;
	private float textOffsetY = 0.0f;
	private float lineWidth = 1.0f;

	private PDTable pdTable = new PDTable();

	public TableElement(float x, float y, float columnHeight) {
		setX(x);
		setY(y);
		this.columnHeight = columnHeight;
	}

	public Color getColorTitle() {

		return colorTitle;
	}

	public TableElement setColorTitle(Color colorTitle) {

		this.colorTitle = colorTitle;
		return this;
	}

	public Color getColorData() {

		return colorData;
	}

	public TableElement setColorData(Color colorData) {

		this.colorData = colorData;
		return this;
	}

	public float getColumnHeight() {

		return columnHeight;
	}

	public TableElement setColumnHeight(float columnHeight) {

		this.columnHeight = columnHeight;
		return this;
	}

	public float getTextOffsetX() {

		return textOffsetX;
	}

	public TableElement setTextOffsetX(float textOffsetX) {

		this.textOffsetX = textOffsetX;
		return this;
	}

	public float getTextOffsetY() {

		return textOffsetY;
	}

	public TableElement setTextOffsetY(float textOffsetY) {

		this.textOffsetY = textOffsetY;
		return this;
	}

	public float getLineWidth() {

		return lineWidth;
	}

	public TableElement setLineWidth(float lineWidth) {

		this.lineWidth = lineWidth;
		return this;
	}

	public PDTable getPDTable() {

		return pdTable;
	}

	public TableElement setPDTable(PDTable pdTable) {

		this.pdTable = pdTable;
		return this;
	}
}
