/*******************************************************************************
 * Copyright (c) 2020, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.msd.ui.swt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.msd.model.core.IRegularMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IStandaloneMassSpectrum;
import org.eclipse.chemclipse.support.text.ValueFormat;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class ExtendedMassSpectrumHeaderUI extends Composite {

	private StyledText styledText;

	public ExtendedMassSpectrumHeaderUI(Composite parent, int style) {

		super(parent, style);
		createControl();
	}

	public void updateMassSpectrum(IRegularMassSpectrum massSpectrum) {

		StringBuilder builder = new StringBuilder();
		List<StyleRange> styleRanges = new ArrayList<>();
		if(massSpectrum != null) {
			int offset = 0;
			offset = addHeaderLine(builder, styleRanges, "Data", massSpectrum.getMassSpectrumType().label(), offset);
			offset = addHeaderLine(builder, styleRanges, "Technique", "MS" + massSpectrum.getMassSpectrometer(), offset);
			offset = addHeaderLine(builder, styleRanges, "Ions", Integer.toString(massSpectrum.getNumberOfIons()), offset);
			offset = addHeaderLine(builder, styleRanges, "Polarity", massSpectrum.getPolarity().label(), offset);
			if(massSpectrum instanceof IStandaloneMassSpectrum standaloneMassSpectrum) {
				offset = addHeaderLine(builder, styleRanges, "Name", standaloneMassSpectrum.getName(), offset);
				offset = addHeaderLine(builder, styleRanges, "File", standaloneMassSpectrum.getFile().getName(), offset);
				offset = addHeaderLine(builder, styleRanges, "Sample", standaloneMassSpectrum.getSampleName(), offset);
				offset = addHeaderLine(builder, styleRanges, "Description", standaloneMassSpectrum.getDescription(), offset);
				offset = addHeaderLine(builder, styleRanges, "Instrument", standaloneMassSpectrum.getInstrument(), offset);
				offset = addHeaderLine(builder, styleRanges, "Operator", standaloneMassSpectrum.getOperator(), offset);
				offset = addHeaderLine(builder, styleRanges, "Plate", standaloneMassSpectrum.getPlate(), offset);
				offset = addHeaderLine(builder, styleRanges, "Position", standaloneMassSpectrum.getPosition(), offset);
				if(standaloneMassSpectrum.getDate() != null) {
					addHeaderLine(builder, styleRanges, "Date", ValueFormat.getDateFormatEnglish().format(standaloneMassSpectrum.getDate()), offset);
				}
			}
		}

		styledText.setText(builder.toString());
		styledText.setStyleRanges(styleRanges.toArray(new StyleRange[styleRanges.size()]));
	}

	private int addHeaderLine(StringBuilder builder, List<StyleRange> styleRanges, String key, String value, int offset) {

		if(value == null) {
			return offset;
		}

		builder.append(key);
		builder.append(": ");
		builder.append(value);
		builder.append(System.lineSeparator());

		StyleRange styleRange = new StyleRange();
		styleRange.start = offset;
		styleRange.length = key.length();
		styleRange.fontStyle = SWT.BOLD;
		styleRanges.add(styleRange);

		return offset + key.length() + 2 + value.length() + System.lineSeparator().length();
	}

	private void createControl() {

		setLayout(new FillLayout());
		styledText = new StyledText(this, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
	}
}
