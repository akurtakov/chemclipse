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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.core.column;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.settings.ChromatogramColumnParserSettings;
import org.eclipse.chemclipse.chromatogram.xxd.classifier.core.AbstractChromatogramClassifier;
import org.eclipse.chemclipse.chromatogram.xxd.classifier.result.IChromatogramClassifierResult;
import org.eclipse.chemclipse.chromatogram.xxd.classifier.settings.IChromatogramClassifierSettings;
import org.eclipse.chemclipse.model.columns.SeparationColumnMapping;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.support.ColumnField;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.model.support.ChromatogramColumnSupport;
import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramColumnParser extends AbstractChromatogramClassifier {

	public ChromatogramColumnParser() {

		super(DataType.CSD, DataType.MSD);
	}

	@Override
	public IProcessingInfo<IChromatogramClassifierResult> applyClassifier(IChromatogramSelection chromatogramSelection, IChromatogramClassifierSettings chromatogramClassifierSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramClassifierResult> processingInfo = new ProcessingInfo<>();
		//
		IChromatogram chromatogram = chromatogramSelection.getChromatogram();
		ChromatogramColumnParserSettings chromatogramColumnParserSettings = getChromatogramColumnParserSettings(chromatogramClassifierSettings);
		ColumnField columnField = chromatogramColumnParserSettings.getColumnField();
		SeparationColumnMapping separationColumnMapping = chromatogramColumnParserSettings.getSeparationColumnMapping();
		boolean parseReferences = chromatogramColumnParserSettings.isParseReferences();
		ChromatogramColumnSupport.parseSeparationColumn(chromatogram, columnField, separationColumnMapping, parseReferences);
		//
		return processingInfo;
	}

	private ChromatogramColumnParserSettings getChromatogramColumnParserSettings(IChromatogramClassifierSettings chromatogramClassifierSettings) {

		if(chromatogramClassifierSettings instanceof ChromatogramColumnParserSettings chromatogramColumnParserSettings) {
			return chromatogramColumnParserSettings;
		} else {
			return new ChromatogramColumnParserSettings();
		}
	}
}