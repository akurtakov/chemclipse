/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.classifier.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.chemclipse.chromatogram.xxd.classifier.result.IChromatogramClassifierResult;
import org.eclipse.chemclipse.chromatogram.xxd.classifier.settings.IChromatogramClassifierSettings;
import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.selection.ChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.Test;

public class ChromatogramClassifier_1_Test {

	private IChromatogramClassifier classifier;
	private IChromatogramSelectionMSD chromatogramSelection;
	private IChromatogramMSD chromatogram;
	private IChromatogramClassifierSettings chromatogramClassifierSettings;

	@Test
	public void testConstructor_1() {

		chromatogramSelection = null;
		chromatogramClassifierSettings = null;
		classifier = new TestChromatogramClassifier(DataType.MSD);
		IProcessingInfo<IChromatogramClassifierResult> processingInfo = classifier.applyClassifier(chromatogramSelection, chromatogramClassifierSettings, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
	}

	@Test
	public void testConstructor_2() {

		chromatogram = new ChromatogramMSD();
		assertDoesNotThrow(() -> {
			chromatogramSelection = new ChromatogramSelectionMSD(chromatogram);
		});
		chromatogramClassifierSettings = null;
		classifier = new TestChromatogramClassifier(DataType.MSD);
		IProcessingInfo<IChromatogramClassifierResult> processingInfo = classifier.applyClassifier(chromatogramSelection, chromatogramClassifierSettings, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
	}
}
