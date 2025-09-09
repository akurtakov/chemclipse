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
 * Alexander Kerner - Generics
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.core;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.exceptions.ClassifierException;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.internal.core.support.ChromatogramTestCase;
import org.eclipse.chemclipse.chromatogram.xxd.classifier.result.IChromatogramClassifierResult;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class WncClassifier_1_ITest extends ChromatogramTestCase {

	private IChromatogramClassifierResult result;

	@Override
	@BeforeAll
	public void setUp() throws IOException, ClassifierException {

		super.setUp();
		Classifier wncClassifier = new Classifier();
		IChromatogramSelectionMSD chromatogramSelection = getChromatogramSelection();
		IProcessingInfo<IChromatogramClassifierResult> processingInfo = wncClassifier.applyClassifier(chromatogramSelection, null, new NullProgressMonitor());
		result = processingInfo.getProcessingResult();
	}

	@Test
	public void testGetClassifierResult_1() {

		assertNotNull(result);
	}
}